package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

public class FormCreatorServlet extends HttpServlet {

	static {
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Form> forms = (List<Form>) ofy().load().type(Form.class)
					.filter("rank", ofy().load().type(Form.class).list().size()).list();
			Form form = forms.get(forms.size() - 1);
			req.setAttribute("formfilter", forms);

			this.getServletContext().getRequestDispatcher("/WEB-INF/displayForm.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {

			List<Form> forms = (List<Form>) ofy().load().type(Form.class)
					.filter("rank", ofy().load().type(Form.class).list().size()).list();
			Form form = forms.get(forms.size() - 1);
			Map<String, Question> liste = new HashMap<String, Question>();

			for (int i = 0; i < form.getNbquestions(); i++) {
				String enonce = req.getParameter("titreQuestion" + i);
				String typeQuestion = req.getParameter("typeQuestion" + i);
				String nbrepontxt = req.getParameter("numberAnswer" + i);
				System.out.println(nbrepontxt);

				int nbreponse = Integer.parseInt(nbrepontxt);

				Question question = new Question(enonce, typeQuestion);
				question.setNbreponses(nbreponse);

				List<Reponse> reponses = new ArrayList<Reponse>();
				for (int j = 0; j < nbreponse; j++) {
					String reponse = req.getParameter(i + "reponse" + j);
					Reponse rep = new Reponse(reponse);
					reponses.add(rep);
				}
				question.setReponses(reponses);
				liste.put(enonce, question);
				ofy().save().entity(question);

			}
			form.setMap(liste);
			ofy().save().entity(form).now();

			resp.sendRedirect("/panel");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
			req.setAttribute("form", forms);

			this.getServletContext().getRequestDispatcher("/WEB-INF/displayForm.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
//			String number = req.getParameter("numberQuestion");
//			System.out.println(number);
			
			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
			Form form = forms.get(forms.size() - 1);
			
			for (int i = 0; i <form.getNbquestions(); i++) {
				String enonce = req.getParameter("titreQuestion" + i);
				String typeQuestion = req.getParameter("typeQuestion");
				
				
				String nbreponses = req.getParameter("numberAnswers" + i);
				System.out.println(nbreponses);
				
				int nb = Integer.parseInt(nbreponses);
				Question question = new Question(enonce, typeQuestion, nb);
				
				List<Reponse> bufferReponse = new ArrayList<Reponse>();
				for (int j = 0; j < nb; j++) {
					String reponse = req.getParameter(i + "reponse" + j);
					Reponse rep = new Reponse(reponse);
					
					bufferReponse.add(rep);
				}
				
				question.setReponses(bufferReponse);
				
			}

			resp.sendRedirect("/panel");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

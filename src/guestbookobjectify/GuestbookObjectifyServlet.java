package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class GuestbookObjectifyServlet extends HttpServlet {

	static {
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
			req.setAttribute("form", forms);
			this.getServletContext().getRequestDispatcher("/WEB-INF/initForm.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String name = req.getParameter("nameform");
			Form form = new Form(name);

			String nb = req.getParameter("nbquestion");
			form.setNbquestions(Integer.valueOf(nb));

			//TODO Devra partir
			System.out.println(form.getId());

			//TODO Devra partir
			for (int i = 0; i < Integer.valueOf(nb); i++) {
				Reponse reponse = new Reponse("reponse1");
				Reponse reponse2 = new Reponse("reponse2");
				
				Question question = new Question("Question checkbox" + i, "checkbox", 2);
				question.getReponses().add(reponse);
				question.getReponses().add(reponse2);

				Question question2 = new Question("Question radio" + i , "radio", 2);
				question2.getReponses().add(reponse);
				question2.getReponses().add(reponse2);
				
				Question question3 = new Question("Question texte" + i, "text", 2);
				question3.getReponses().add(reponse);
				question3.getReponses().add(reponse2);

				form.getListe().put("Question checkbox" + i, question);
				form.getListe().put("Question radio" + i, question2);
				form.getListe().put("Question texte" + i, question3);
			}

			//TODO Devra partir
			form.setId(123L);

			ofy().save().entity(form).now();

			resp.sendRedirect("/formpanel"); 
			//TODO A rechanger!
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

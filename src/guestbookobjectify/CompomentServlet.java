package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

public class CompomentServlet extends HttpServlet {
	static{
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			
			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
			Form lastElement = forms.get(forms.size() - 1);
			List<Question> questions = (List<Question>) ofy().load().type(Question.class).parent(lastElement);

			req.setAttribute("question", questions);
			req.setAttribute("form", forms);
			this.getServletContext().getRequestDispatcher("/WEB-INF/panel.jsp").forward(req, resp);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}

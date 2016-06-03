package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.cmd.LoadType;

public class CompomentServlet extends HttpServlet {
	static{
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
		Form lastElement = forms.get(forms.size()-1);
		List<Question> qs = (List<Question>) ofy().load().type(Question.class).filter(lastElement.getName(), lastElement).list();
		System.out.println(qs);
		System.out.println(lastElement.getName());
		System.out.println(lastElement.getMap());
		req.setAttribute("form", forms);
		req.setAttribute("question", qs);
		try {
			this.getServletContext().getRequestDispatcher("/WEB-INF/panel.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}

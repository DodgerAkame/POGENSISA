package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;
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
		List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
		req.setAttribute("form", forms);
		
	}
	
	
}

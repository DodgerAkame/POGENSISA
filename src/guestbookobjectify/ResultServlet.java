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

public class ResultServlet extends HttpServlet {

	static {
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
		ObjectifyService.register(User.class);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			
			StringBuffer url = req.getRequestURL();
			String uri = req.getRequestURI();
			String ctx = req.getContextPath();
			String base = url.substring(0, url.length() - uri.length() + ctx.length()) + "/";
			
			System.out.println(base);
			
			List<Form> forms = (List<Form>) ofy().load().type(Form.class)
					.filter("rank", ofy().load().type(Form.class).list().size()).list();
			Form form = forms.get(forms.size() - 1);
			
			List<User> users = (List<User>) ofy().load().type(User.class).filter("idForm", form.getId()).list();
			
			req.setAttribute("formResult", form);
			req.setAttribute("users", users);

			this.getServletContext().getRequestDispatcher("/WEB-INF/dispResult.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}

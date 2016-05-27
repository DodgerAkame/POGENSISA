package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
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
			List<User> users = (List<User>) ofy().load().type(User.class).list();
			req.setAttribute("numberuser", users.size());
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/dispResult.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {

	}

}

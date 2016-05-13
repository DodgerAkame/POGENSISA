package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

@SuppressWarnings("serial")
public class GuestbookObjectifyServlet extends HttpServlet {

	static {
		ObjectifyService.register(Formulaire.class);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			List<Formulaire> form = ofy().load().type(Formulaire.class).list();
			req.setAttribute("formulaire", form);
			this.getServletContext().getRequestDispatcher("/WEB-INF/guestbook.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String name = req.getParameter("name");
			Formulaire form = new Formulaire(name);

			ofy().save().entity(form).now();

			resp.sendRedirect("/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

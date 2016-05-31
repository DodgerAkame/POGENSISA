package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

public class PanelServlet extends HttpServlet {

	static {
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
		ObjectifyService.register(Histo.class);

	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
			List<Histo> histos = (List<Histo>) ofy().load().type(Histo.class)
					.filter("rang", ofy().load().type(Histo.class).list().size()).list();
			Histo h = histos.get(histos.size() - 1);
			for (Form f : forms) {
				String id = Long.toString(f.getId());
				String X = f.getName() + id;
				if (X.equals(h.getName())) {
					req.setAttribute("form", f);
				}
			}

			this.getServletContext().getRequestDispatcher("/WEB-INF/panel2.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

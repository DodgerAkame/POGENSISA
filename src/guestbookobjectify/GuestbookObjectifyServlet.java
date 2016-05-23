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

			ofy().save().entity(form).now();

			resp.sendRedirect("/formcreator"); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

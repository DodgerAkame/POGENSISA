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

@SuppressWarnings("serial")
public class GuestbookObjectifyServlet extends HttpServlet {

	static {
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
	}

	/*
	 * public void doGet(HttpServletRequest req, HttpServletResponse resp)
	 * throws IOException { try { List<Message> message =
	 * ofy().load().type(Message.class).list(); req.setAttribute("messages",
	 * message);
	 * this.getServletContext().getRequestDispatcher("/WEB-INF/guestbook.jsp").
	 * forward(req, resp); } catch (ServletException e) { e.printStackTrace(); }
	 * }
	 * 
	 * public void doPost(HttpServletRequest req, HttpServletResponse resp) {
	 * try { String name = req.getParameter("name"); String msg =
	 * req.getParameter("message"); String[] checked =
	 * req.getParameterValues("option"); String bouton =
	 * req.getParameter("button"); List<String> checkboxes = new
	 * ArrayList<String>();
	 * 
	 * Message message = new Message(name, msg); for (int i = 0; i <
	 * checked.length; i++) { checkboxes.add(checked[i]); }
	 * message.setCheckboxes(checkboxes); message.setCheck(bouton);
	 * 
	 * ofy().save().entity(message).now();
	 * 
	 * resp.sendRedirect("/"); } catch (IOException e) { e.printStackTrace(); }
	 * }
	 */

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		try {
			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
			req.setAttribute("form", forms);
			this.getServletContext().getRequestDispatcher("/WEB-INF/guestbook.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String name = req.getParameter("nameform");
			Form form = new Form(name);
			form.setNbquestions(Integer.valueOf(req.getParameter("nbquestion")));
			

			ofy().save().entity(form).now();

			resp.sendRedirect("/displayForm.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

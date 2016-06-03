package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.VoidWork;

@SuppressWarnings("serial")
public class GuestbookObjectifyServlet extends HttpServlet {

	static {
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
			req.setAttribute("form", forms);
			this.getServletContext().getRequestDispatcher("/WEB-INF/initForm.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			String action = req.getParameter("action");

			if (action.equals("Créer")) {

				List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();

				String name = req.getParameter("nameform");
				Form form = new Form(name, forms.size() + 1);

				String nb = req.getParameter("nbquestion");
				form.setNbquestions(Integer.valueOf(nb));

				ofy().save().entity(form).now();

				resp.sendRedirect("/formcreator");
			} else if (action.equals("Mettre à jour")) {

				List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();

				if (req.getParameterValues("Open") != null) {
					String[] checked = req.getParameterValues("Open");

					for (Form form : forms) {
						for (int i = 0; i < checked.length; i++) {
							
							if (form.getId().toString().equals(checked[i])){
								form.setOpened(true);
								break;
							}
							
							if (i == checked.length - 1)
								form.setOpened(false);
						}
					}

				} else {
					for (Form form : forms)
						form.setOpened(false);
				}

				for (Form form : forms){
					ofy().save().entity(form).now();
				}
				
				resp.sendRedirect("/");
			}
			
			else if (action.matches("redirection/[0-9]*")){
			
				StringTokenizer st = new StringTokenizer(action, "/");
				st.nextToken();
				
				resp.sendRedirect("/results/" + st.nextToken().trim());
				
			}
			
			else if (action.matches("reponse/[0-9]*")){
				StringTokenizer st = new StringTokenizer(action, "/");
				st.nextToken();
				
				resp.sendRedirect("/panel/" + st.nextToken().trim());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

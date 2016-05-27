package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

public class CompomentServlet extends HttpServlet {
	static {
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
		ObjectifyService.register(User.class);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {

			List<Form> forms = (List<Form>) ofy().load().type(Form.class)
					.filter("rank", ofy().load().type(Form.class).list().size()).list();
			// Form lastElement = forms.get(forms.size() - 1);
			req.setAttribute("form", forms);
			this.getServletContext().getRequestDispatcher("/WEB-INF/panel.jsp").forward(req, resp);

		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Form> forms = (List<Form>) ofy().load().type(Form.class)
					.filter("rank", ofy().load().type(Form.class).list().size()).list();
			Form form = forms.get(forms.size() - 1);
			Map<String, Reponse> userReponse = new HashMap<String, Reponse>();

			for (int i = 0; i < form.getNbquestions(); i++) {
				List<Question> listeQs = form.getListe();

				for (int l = 0; l < listeQs.size(); l++) {
					Question qs = listeQs.get(l);
					StringBuffer sb = new StringBuffer();

					if (qs.getQuestion().equals("checkbox")) {
						String[] checked = req.getParameterValues("checkboxes" + l);
						for (int j = 0; j < checked.length; j++) {
							sb.append(checked[j]);
							sb.append('|');
						}
					}

					else if (qs.getQuestion().equals("text")) {
						sb.append(req.getParameter("textreponse"));
					} else {
						sb.append(req.getParameter("radios"+l));
					}

					Reponse rep = new Reponse(sb.toString());
					userReponse.put(qs.getEnonce(), rep);
				}

			}

			User user = new User();
			user.setReponses(userReponse);

			ofy().save().entity(user).now();

			resp.sendRedirect("/");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

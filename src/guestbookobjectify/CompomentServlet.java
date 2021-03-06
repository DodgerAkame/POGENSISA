package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

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

			String uri = req.getRequestURI();
			StringTokenizer st = new StringTokenizer(uri,"/");
			st.nextToken();
			req.setAttribute("IDForm",st.nextToken().toString());
			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
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
			String uri = req.getRequestURI();
			StringTokenizer st = new StringTokenizer(uri,"/");
			st.nextToken();
			String buffertxt = st.nextToken().trim();
			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
			Form form = new Form();
			Map<String, Reponse> userReponse = new HashMap<String, Reponse>();
			for (Form buffer : forms) {
				if (buffer.getId().toString().equals(buffertxt)) {
					form = buffer;
					break;
				}
			}
			

			for (int i = 0; i < form.getNbquestions(); i++) {
				List<Question> listeQs = form.getListe();

				for (int l = 0; l < listeQs.size(); l++) {
					Question qs = listeQs.get(l);
					StringBuffer sb = new StringBuffer();

					if (qs.getQuestion().equals("checkbox")) {
						String[] checked;
						checked = new String[qs.getNbreponses()];
						for (int z = 0; z < qs.getNbreponses(); z++) {
							checked[z] = "";
						}

						if (req.getParameterValues("checkboxes" + l) != null)
							checked = req.getParameterValues("checkboxes" + l);

						for (int j = 0; j < checked.length; j++) {
							sb.append(checked[j]);
							sb.append("|");
						}
					} else if (qs.getQuestion().equals("text")) {
						sb.append(req.getParameter("textreponse" + l));
						sb.append("|");
					} else {
						sb.append(req.getParameter("radios" + l));
						sb.append("|");
					}

					Reponse rep = new Reponse(sb.toString());
					userReponse.put(qs.getEnonce(), rep);

				}

			}

			User user = new User();
			user.setIdForm(form.getId()); // Stocker l'ID du formulaire
			user.setReponses(userReponse);

			ofy().save().entity(user).now();

			resp.sendRedirect("/results/" + form.getId());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

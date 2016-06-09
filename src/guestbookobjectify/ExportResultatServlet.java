package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

public class ExportResultatServlet extends HttpServlet {

	static {
		ObjectifyService.register(Form.class);
		ObjectifyService.register(User.class);
		ObjectifyService.register(Reponse.class);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.setContentType("text/csv");
			resp.setHeader("Content-Disposition", "attachment; filename=\"Resultats.csv\"");

			String uri = req.getRequestURI();
			StringTokenizer st = new StringTokenizer(uri, "/");
			st.nextToken();
			String url = st.nextToken().trim();

			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
			Form form = new Form();
			for (Form buffer : forms) {
				if (buffer.getId().toString().equals(url)) {
					form = buffer;
					break;
				}
			}

			OutputStream outputStream = resp.getOutputStream();
			StringBuffer sb = new StringBuffer();
			sb.append(form.getName());
			for (int i = 0; i < form.getNbquestions(); i++) {
				sb.append(";");
				sb.append(form.getListe().get(i).getEnonce());
			}
			sb.append("\r\n");
			sb.append("\r\n");

			List<User> users = (List<User>) ofy().load().type(User.class).filter("idForm", form.getId()).list();
			for (int j = 0; j < users.size(); j++) {
				sb.append("Réponse" + j + ":");

				for (int k = 0; k < form.getNbquestions(); k++) {
					sb.append(";");
					sb.append(users.get(j).getReponses().get(form.getListe().get(k).getEnonce()).getReponse());
				}

				sb.append("\r\n");
			}

			outputStream.write(sb.toString().getBytes());
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

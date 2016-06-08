package guestbookobjectify;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;
import static com.googlecode.objectify.ObjectifyService.ofy;

public class crudServlet extends HttpServlet {

	static {
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			this.getServletContext().getRequestDispatcher("/WEB-INF/crud.jsp").forward(req, resp);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {

		String buffer = req.getParameter("textImport");
		StringTokenizer retour = new StringTokenizer(buffer, "\r\n");

		while (retour.hasMoreTokens()) {
			String ligne = retour.nextToken().toString();
			StringTokenizer st = new StringTokenizer(ligne, ";");

			String enonce = st.nextToken().toString();
			String typeQuestion = st.nextToken().toString();
			String categorie = st.nextToken().toString();

			Question qs = new Question(enonce, typeQuestion, categorie);
			List<Reponse> reponses = new ArrayList<Reponse>();
			while (st.hasMoreTokens()) {
				Reponse rep = new Reponse(st.nextToken().toString());
				reponses.add(rep);
			}
			qs.setReponses(reponses);
			qs.setNbreponses(reponses.size());

			ofy().save().entity(qs);
		}
	}

}

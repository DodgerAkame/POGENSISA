package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

public class CruditeServlet extends HttpServlet {

	static {
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
		List<Question> qs = (List<Question>) ofy().load().type(Question.class).list();
		req.setAttribute("form", forms);
		req.setAttribute("question", qs);
		List<String> cat = new ArrayList<String>();
		cat.add("");
		for(Question q : qs){			
				if(cat.contains(q.getCategorie()) == false){
			cat.add(q.getCategorie());
			}
			
		}
		req.setAttribute("categorie", cat);
		try {
			this.getServletContext().getRequestDispatcher("/WEB-INF/creation.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {			
				String enonce = req.getParameter("titreQuestion");
				String typeQuestion = req.getParameter("typeQuestion");
				String nbrepontxt = req.getParameter("numberAnswer");
				String categorie = "";
					if (req.getParameter("cat") != null){
						categorie = req.getParameter("cat");
					}else {
						categorie = req.getParameter("select");
					}
				System.out.println(categorie);
				int nbreponse = Integer.parseInt(nbrepontxt);

				Question question = new Question(enonce, typeQuestion, categorie);
				question.setNbreponses(nbreponse);

				List<Reponse> reponses = new ArrayList<Reponse>();
				for (int j = 0; j < nbreponse; j++) {
					String reponse = req.getParameter("reponse" + j);
					Reponse rep = new Reponse(reponse);
					reponses.add(rep);
				}
				question.setReponses(reponses);
				ofy().save().entity(question);

			
			resp.sendRedirect("/");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void doDelete(HttpServletRequest req, HttpServletResponse resp) {
	}
	
	public void doTrace(HttpServletRequest req, HttpServletResponse resp) {
		
	}
}

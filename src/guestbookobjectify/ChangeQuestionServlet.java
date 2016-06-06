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

public class ChangeQuestionServlet extends HttpServlet {

	static {ObjectifyService.register(Form.class);
	ObjectifyService.register(Question.class);
	ObjectifyService.register(Reponse.class);
	ObjectifyService.register(Histo.class);	
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Histo> histos = (List<Histo>) ofy().load().type(Histo.class)
					.filter("rang", ofy().load().type(Histo.class).list().size()).list();
			List<Question> qs = (List<Question>) ofy().load().type(Question.class).list();
			Histo h = histos.get(histos.size() - 1);
			req.setAttribute("histo", h);
			List<String> cat = new ArrayList<String>();
			cat.add("default");
			for(Question q : qs){			
					if(cat.contains(q.getCategorie()) == false){
				cat.add(q.getCategorie());
				}
				
			}
			req.setAttribute("categorie", cat);
			this.getServletContext().getRequestDispatcher("/WEB-INF/changeQuestion.jsp").forward(req, resp);
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
		
			List<Form> forms = (List<Form>) ofy().load().type(Form.class)
					.filter("rank", ofy().load().type(Form.class).list().size()).list();
			List<Question> qs = (List<Question>) ofy().load().type(Question.class).list();
			Form form = forms.get(forms.size() - 1);
			Map<String, Question> liste = new HashMap<String, Question>();
			List<Question> questions = (List<Question>) ofy().load().type(Question.class).list();

			for (int i = 0; i < form.getNbquestions(); i++) {
				String qid = req.getParameter("Id"+i);
				String enonce = req.getParameter("titreQuestion" + i);
				String typeQuestion = req.getParameter("typeQuestion" + i);
				String nbrepontxt = req.getParameter("numberAnswer" + i);
				System.out.println(nbrepontxt);
				String categorie = "default";
				if (req.getParameter("cat"+i) != null){
					categorie = req.getParameter("cat"+i);
				}else {
					categorie = req.getParameter("select"+i);
				}
		

				int nbreponse = Integer.parseInt(nbrepontxt);

				long Id =Long.parseLong(qid);
			Question question = null;
			for(Question q : qs){
				
				if(q.getId() == Id){
					question = q;
				}
			}
				List<Reponse> reponses = new ArrayList<Reponse>();
				for (int j = 0; j < nbreponse; j++) {
					String reponse = req.getParameter(i + "reponse" + j);
					Reponse rep = new Reponse(reponse);
					reponses.add(rep);
				}
				
				question.setCategorie(categorie);
				question.setEnonce(enonce);
				question.setNbreponses(nbreponse);
				question.setQuestion(typeQuestion);
				question.setReponses(reponses);
				ofy().save().entity(question);

			}

			

			resp.sendRedirect("/update");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

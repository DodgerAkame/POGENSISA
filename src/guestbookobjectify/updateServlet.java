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

public class updateServlet extends HttpServlet {
	static {
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
		ObjectifyService.register(Checking.class);	
	}
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
			List<Question> qs = (List<Question>) ofy().load().type(Question.class).list();
			req.setAttribute("form", forms);
			req.setAttribute("question", qs);
			List<String> cat = new ArrayList<String>();
			//cat.add("default");
			for(Question q : qs){			
					if(cat.contains(q.getCategorie()) == false){
				cat.add(q.getCategorie());
				}
				
			}
			Map<String,List<Question>> q = new HashMap<String,List<Question>>();
			for(String i : cat){
				List<Question> question = new ArrayList<Question>();
				if(i!=null){
				 for(Question qi : qs){			
						if(i.equals(qi.getCategorie())){
							question.add(qi);
							}
				 }q.put(i, question);
			}}
			req.setAttribute("haha",q);
			req.setAttribute("categorie", cat);
			this.getServletContext().getRequestDispatcher("/WEB-INF/update.jsp").forward(req, resp);
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
		
			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
			List<Checking> listHisto = (List<Checking>) ofy().load().type(Checking.class).list();
			Checking h=new Checking("default",1);
				for(Checking f : listHisto){
					if(f.getName().equals("default"))
						h=f;
				}
			List<Question> qs = (List<Question>) ofy().load().type(Question.class).list();
			String[] checked = req.getParameterValues("checkboxes1");
			List<Question> question = new ArrayList<Question>();
			for(Question q : qs){
				String qenonce = q.getEnonce();
				long qid = q.getId();
				for(int j= 0; j<checked.length; j++){
					String c = checked[j] ;
					long check =Long.parseLong(c);
					if(qid == check){
							String id = Long.toString(q.getId());
							question.add(q);
							
						}						
					}
				}
			h.setQuestion(question);
			ofy().save().entity(h).now();
			resp.sendRedirect("/changeQuestion");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

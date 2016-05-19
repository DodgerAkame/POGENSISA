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

public class FormCreatorServlet extends HttpServlet {

	static{
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp){
		try {
			List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
			Map<String,Question> questions = new HashMap<String,Question>();
			for (int i  = 0; i < forms.size(); i++){
				questions.putAll(forms.get(i).getListe());
			}
			
			req.setAttribute("form", forms);
			this.getServletContext().getRequestDispatcher("/WEB-INF/displayForm.jsp").forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp){
		
	}
	
}

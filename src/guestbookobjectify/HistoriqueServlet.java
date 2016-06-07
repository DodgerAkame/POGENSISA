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

public class HistoriqueServlet extends HttpServlet {

	static {
		ObjectifyService.register(Form.class);
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
		ObjectifyService.register(Checking.class);
		
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		List<Form> forms = (List<Form>) ofy().load().type(Form.class).list();
		req.setAttribute("formhistorique", forms);
		try {
			this.getServletContext().getRequestDispatcher("/WEB-INF/historique.jsp").forward(req, resp);
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
			String[] checked = req.getParameterValues("radios");
			Checking h = new Checking();
			for(Form q : forms){
				String qenonce = q.getName();
				for(int j= 0; j<checked.length; j++){
					String check = checked[j];
						if(qenonce.equals(check)){
							String id = Long.toString(q.getId());
							String X = q.getName()+id;
							h.setName(X);
							h.setRang(listHisto.size()+1);
						}						
					}
				}
			ofy().save().entity(h).now();
			resp.sendRedirect("/panel2");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

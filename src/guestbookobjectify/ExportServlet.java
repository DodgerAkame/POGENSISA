package guestbookobjectify;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

public class ExportServlet extends HttpServlet {

	static {
		ObjectifyService.register(Question.class);
		ObjectifyService.register(Reponse.class);
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) {
		try {
			resp.setContentType("text/csv");
			resp.setHeader("Content-Disposition", "attachment; filename=\"POGENSISA Datastore.csv\"");

			OutputStream outputStream = resp.getOutputStream();
			StringBuffer sb = new StringBuffer();
			sb.append("Question;Type de Question;Catégorie de la question; Réponses;.......");
			sb.append("\r\n");
			
			List<Question> questions = (List<Question>) ofy().load().type(Question.class).list();
			
			for (int i = 0; i < questions.size(); i++){
				sb.append(questions.get(i).getEnonce() + ";");
				sb.append(questions.get(i).getQuestion() + ";");
				sb.append(questions.get(i).getCategorie());
				
				for (int j = 0 ; j < questions.get(i).getNbreponses(); j++){
					sb.append(";");
					sb.append(questions.get(i).getReponses().get(j).getReponse());
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

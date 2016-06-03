package guestbookobjectify;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Compoment {

	public Compoment(){}
	
	
	public String Panel(Form key, List<Question> qs){
		Form form = key;
		String S = form.getName();
		String C = "";
		String T = "Formulaire";
		
		for (Question q : qs){
			T =  q.getEnonce();
			if(q.getQuestion()== "checkbox"){
				int i = 1;
				List<Reponse> reponses = q.getReponses();
				for(Reponse r : reponses){
					
					C = C+WritecheckBox(r.getReponse(),i);
					i++;
				}
			}
			if(q.getQuestion()=="radio"){
				int i = 1;
				List<Reponse> reponses = q.getReponses();
				for(Reponse r : reponses){
					
					C = C+WriteRadio(r.getReponse(),i);
					i++;
				}
			}
			if(q.getQuestion()=="text"){
				List<Reponse> reponses = q.getReponses();
				for(Reponse r : reponses){
					C = C+textArea(r.getReponse());
				}
			}
			S = S+"<form class=\"form-horizontal\">"+"\n"+
					"<fieldset>"+"\n"+"<!-- Form Name -->"+"\n"+"<legend>"+T+"</legend>"+C+"</fieldset>"+"\n"+"</form>";				
		}
		return S;
	}
	public String Button(String key){
		String S = "<div class=\"form-group\">"+"\n"+
		  "<label class=\"col-md-4 control-label\" for=\"singlebutton\"></label>"+"\n"+
		  "<div class=\"col-md-4\">"+"\n"+
		  " <button id=\"singlebutton\" name=\"singlebutton\" class=\"btn btn-primary\">"+key+"</button>"+"\n"+
		  "</div>"+"\n"+
		"</div>"+"\n";
		return S;
	}
	public String textArea(String key){
		String S = "<div class=\"form-group\">"+"\n"+"<label class=\"col-md-4 control-label\" for=\"textarea\"></label>"+"\n"+
		  "<div class=\"col-md-4\">"+"\n"+                     
		    "<textarea class=\"form-control\" id=\"textarea\" name=\"reponse\">+"
		    + key+"</textarea>"+"\n"+
		 " </div>"+"\n"+
		"</div>"+"\n";
		return S;
	}
public String WriteRadioI(String key, int value){
	String v = Integer.toString(value);
		String S = "<div class=\"form-group\">"+"\n"+
		  "<label class=\"col-md-4 control-label\" for=\"radios\"></label>"+"\n"+
		  "<div class=\"col-md-4\">"+"\n"+
		  "<div class=\"radio\">"+"\n"+
		    "<label for=\"radios-inline\">"+"\n"+
				"<input name=\"radios\" id=\"radios-0\" value="+v+"checked=\"checked\" type=\"radio\">"+"\n"+
		      key +"\n"+
		   " </label>"+"\n"+
			"</div>"+"\n";
		return S;
	}
	public String WriteRadio(String key, int value){
		String v = Integer.toString(value);
		String S = "<div class=\"form-group\">"+"\n"+
		  "<label class=\"col-md-4 control-label\" for=\"radios\"></label>"+"\n"+
		  "<div class=\"col-md-4\">"+"\n"+
		  "<div class=\"radio\">"+"\n"+
		    "<label for=\"radios-0\">"+"\n"+
		      "<input name=\"radios\" id=\"radios-0\" value="+ v +"checked=\"checked\" type=\"radio\">"+"\n"+
		      key +"\n"+
		   " </label>"+"\n"+
			"</div>"+"\n";
		return S;
	}
	public String WritecheckBoxI(String Key, int value){
		String v = Integer.toString(value);
		String S = "<div class=\"form-group\">"
	+"\n"+
	"<label class=\"col-md-4 control-label\" for=\"checkboxes\"></label>"
	+"\n"+
    "<div class=\"col-md-4\">"+"\n"+
  "<div class=\"checkbox\">"+"\n"+
    "<label for=\"checkboxes-inline\">"+"\n"+
      "<input name=\"checkboxes\" id=\"checkboxes-0\" value="+v+" type=\"checkbox\">"
      +Key+"\n"+
    "</label>"+"\n"+"</div>"+"\n"+"</div>"+"\n"+"</div>";
		return S;
	}
	public String WritecheckBox(String Key, int value){
		String v = Integer.toString(value);
		String S = "<div class=\"form-group\">"
	+"\n"+
	"<label class=\"col-md-4 control-label\" for=\"checkboxes\"></label>"
	+"\n"+
    "<div class=\"col-md-4\">"+"\n"+
  "<div class=\"checkbox\">"+"\n"+
    "<label for=\"checkboxes-0\">"+"\n"+
      "<input name=\"checkboxes\" id=\"checkboxes-0\" value="+v+" type=\"checkbox\">"
      +Key+"\n"+
    "</label>"+"\n"+"</div>"+"\n"+"</div>"+"\n"+"</div>";
		return S;
	}
}

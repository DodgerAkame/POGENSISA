package guestbookobjectify;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Compoment {

	public Compoment(){}
	
	public String Field(List<Reponse> re, int j){
		String S ="";
		int i = 0;
		for(Reponse r : re){
			S = S+"<label><input type=\"text\" name=\""+j+"reponse"+i+"\" value=\""+r.getReponse()+"\"/></label><br>";
			i++;
		}
		return S;
		
	}
	
	public String PanelM(Map<String,List<Question>> f){
		String S ="";
		int index = 1;
		for (Map.Entry<String, List<Question>> entry : f.entrySet()) {
			List<Question> qs = entry.getValue();
			String C = "<fieldset> <legend>"+entry.getKey()+"</legend>";
			int i = 0;
			for(Question q : qs){
				String reponse = "";
				int x = 1;
				for(Reponse r : q.getReponses()){
					reponse= reponse+"&nbsp;&nbsp;R"+x+" : "+r.getReponse();
					x++;
				}
				C = C + WritecheckBox2("Enonce : "+q.getEnonce()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+reponse,q.getId(), i, index);
				i++;
			}
			S = S + C + "</fieldset>";
		}
		
		return S;
	}
	
	public String PanelF(List<Form> form){
		String S = "";
		List<Form> formu = form;
		int i = 0;
		for(Form f : formu){
				S = S+WriteRadio(f.getName(),i,i);
				i++;
		}
		return S;
	}
	
	public String PanelQ(List<Question> qs){
		
		String S = "";
		List<Question> question = qs;
		int i = 0;
		for(Question q : question){
				S = S+WritecheckBox(q.getEnonce(),i,1)+"   nombre de réponse :"+q.getNbreponses();
				i++;
		}
		return S;
	}
	
	public String Panel(Form key){
		Form form = key;
		String S = "<h1>"+form.getName()+"</h1>\n";
		String C = "";
		String T = "Formulaire";
		Map<String,Question> question = form.getMap();
		int indexqs = 0;
		
		for (Entry<String, Question> e : question.entrySet()){
			Question q = e.getValue();
			T =  q.getEnonce();
			
			if(q.getQuestion()== "checkbox"){
				int i = 1;
				List<Reponse> reponses = q.getReponses();
				for(Reponse r : reponses){
					
					C = C+WritecheckBox(r.getReponse(),i, indexqs);
					i++;
					
				}
			}
			if(q.getQuestion()=="radio"){
				int i = 1;
				List<Reponse> reponses = q.getReponses();
				for(Reponse r : reponses){
					
					C = C+WriteRadio(r.getReponse(),i, indexqs);
					i++;
				}
			}
			if(q.getQuestion()=="text"){
				List<Reponse> reponses = q.getReponses();
				for(Reponse r : reponses){
					C = C+textArea(r.getReponse(),indexqs);
				}
			}
			S = S+"<div class=\"form-horizontal\">"+"\n"+
					"<fieldset>"+"\n"+"<!-- Form Name -->"+"\n"+"<legend>"+T+"</legend>"+C+"</fieldset>"+"\n"+"</div>";
			C = "";	
			indexqs++;
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
			    "<textarea class=\"form-control\" id=\"textarea\" name=\"textreponse\">+"
			    + key+"</textarea>"+"\n"+
			 " </div>"+"\n"+
			"</div>"+"\n";
			return S;
		}
		
		public String textArea(String key, int index){
			//TODO
			String S = "<div class=\"form-group\">"+"\n"+"<label class=\"col-md-4 control-label\" for=\"textarea\"></label>"+"\n"+
			  "<div class=\"col-md-4\">"+"\n"+                     
			    "<textarea class=\"form-control\" id=\"textarea\" name=\"textreponse"+index+"\">+"
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

		public String WriteRadio(String key, int value, int index){
			String v = Integer.toString(value);
			String S = "<div class=\"form-group\">"+"\n"+
			  "<label class=\"col-md-4 control-label\" for=\"radios\"></label>"+"\n"+
			  "<div class=\"col-md-4\">"+"\n"+
			  "<div class=\"radio\">"+"\n"+
			    "<label for=\"radios-0\">"+"\n"+
			      "<input name=\"radios"+ index +"\" id=\"radios-0\" value=\""+ key +"\" checked=\"checked\" type=\"radio\">"+"\n"+
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
	      "<input name=\"checkboxes"+v+"\" id=\"checkboxes-0\" value=\""+Key+"\" type=\"checkbox\">"
	      +Key+"\n"+
	    "</label>"+"\n"+"</div>"+"\n"+"</div>"+"\n"+"</div>";
			return S;
		}
		public String WritecheckBox2(String Key,long id, int value, int index){
			String v = Integer.toString(value);
			String S = "<div class=\"form-group\">"
		+"\n"+
		"<label class=\"col-md-4 control-label\" for=\"checkboxes\"></label>"
		+"\n"+
	    "<div class=\"col-md-4\">"+"\n"+
	  "<div class=\"checkbox\">"+"\n"+
	    "<label for=\"checkboxes-0\">"+"\n"+
	      "<input name=\"checkboxes"+index+"\" id=\"checkboxes-0\" value=\""+id+"\" type=\"checkbox\">"
	      +Key+"\n"+
	    "</label>"+"\n"+"</div>"+"\n"+"</div>"+"\n"+"</div>";
			return S;
		}
		public String WritecheckBox(String Key, int value, int index){
			String S = "<div class=\"form-group\">"
		+"\n"+
		"<label class=\"col-md-4 control-label\" for=\"checkboxes\"></label>"
		+"\n"+
	    "<div class=\"col-md-4\">"+"\n"+
	  "<div class=\"checkbox\">"+"\n"+
	    "<label for=\"checkboxes-0\">"+"\n"+
	      "<input name=\"checkboxes"+index+"\" id=\"checkboxes-0\" value=\""+Key+"\" type=\"checkbox\">"
	      +Key+"\n"+
	    "</label>"+"\n"+"</div>"+"\n"+"</div>"+"\n"+"</div>";
			return S;
		}
		public String WriteSelect (List<String>cat ){
			String S = "<div class=\"form-group\">  <label class=\"col-md-4 control-label\" for=\"selectbasic\"></label>  <div class=\"col-md-4\">"
					+ "   <select id=\"select\" name=\"select\" class=\"form-control\" size=\"1\">";
			int i = 0;
			for(String c : cat){
				String X =  "<option value=\""+c+"\">"+c+"</option> ";
				S=S+X;
				i++;
			}
			S=S+"</select></div></div>";
			return S;
			
		}
		public String WriteSelect2 (List<String>cat, int i ){
			String S = "<div class=\"form-group\">  <label class=\"col-md-4 control-label\" for=\"selectbasic\"></label>  <div class=\"col-md-4\">"
					+ "   <select id=\"select\" name=\"select"+i+"\" class=\"form-control\" size=\"1\">";
			int j = 0;
			for(String c : cat){
				String X =  "<option value=\""+c+"\">"+c+"</option> ";
				S=S+X;
				j++;
			}
			S=S+"</select></div></div>";
			return S;
			
		}
	}
package guestbookobjectify;

public class Compoment {
	public void Compoment(){}
	
	
	public String Panel(String Key){
		return Key;
		
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
public String WriteRadioI(String key){
		
		String S = "<div class=\"form-group\">"+"\n"+
		  "<label class=\"col-md-4 control-label\" for=\"radios\"></label>"+"\n"+
		  "<div class=\"col-md-4\">"+"\n"+
		  "<div class=\"radio\">"+"\n"+
		    "<label for=\"radios-inline\">"+"\n"+
				"<input name=\"radios\" id=\"radios-0\" value=\"1\" checked=\"checked\" type=\"radio\">"+"\n"+
		      key +"\n"+
		   " </label>"+"\n"+
			"</div>"+"\n";
		return S;
	}
	public String WriteRadio(String key){
		
		String S = "<div class=\"form-group\">"+"\n"+
		  "<label class=\"col-md-4 control-label\" for=\"radios\"></label>"+"\n"+
		  "<div class=\"col-md-4\">"+"\n"+
		  "<div class=\"radio\">"+"\n"+
		    "<label for=\"radios-0\">"+"\n"+
		      "<input name=\"radios\" id=\"radios-0\" value=\"1\" checked=\"checked\" type=\"radio\">"+"\n"+
		      key +"\n"+
		   " </label>"+"\n"+
			"</div>"+"\n";
		return S;
	}
	public String WritecheckBoxI(String Key){
		String S = "<div class=\"form-group\">"
	+"\n"+
	"<label class=\"col-md-4 control-label\" for=\"checkboxes\"></label>"
	+"\n"+
    "<div class=\"col-md-4\">"+"\n"+
  "<div class=\"checkbox\">"+"\n"+
    "<label for=\"checkboxes-inline\">"+"\n"+
      "<input name=\"checkboxes\" id=\"checkboxes-0\" value=<%= r.getReponse() %> type=\"checkbox\">"
      +Key+"\n"+
    "</label>"+"\n"+"</div>"+"\n"+"</div>"+"\n"+"</div>";
		return S;
	}
	public String WritecheckBox(String Key){
		String S = "<div class=\"form-group\">"
	+"\n"+
	"<label class=\"col-md-4 control-label\" for=\"checkboxes\"></label>"
	+"\n"+
    "<div class=\"col-md-4\">"+"\n"+
  "<div class=\"checkbox\">"+"\n"+
    "<label for=\"checkboxes-0\">"+"\n"+
      "<input name=\"checkboxes\" id=\"checkboxes-0\" value=<%= r.getReponse() %> type=\"checkbox\">"
      +Key+"\n"+
    "</label>"+"\n"+"</div>"+"\n"+"</div>"+"\n"+"</div>";
		return S;
	}
}

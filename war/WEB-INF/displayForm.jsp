<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>

<%@ page import="guestbookobjectify.GuestbookObjectifyServlet"%>
<%@ page import="guestbookobjectify.*"%>


<!DOCTYPE html>

<html>
<head>
<title>Livre d'or</title>
<meta charset="utf-8" />
</head>

<%
	List<Form> forms = (List<Form>) request.getAttribute("form");
	for (Form form : forms) {
		Map<String, Question> buffer = new HashMap<String, Question>();
%>


<h1>
	<%=form.getName()%>
</h1>


<%
	for (int i = 0; i < form.getNbquestions(); i++) {
%>

<div name="question<%=i%>">
	<h2>
		<label>Enoncé de la question :<input type="text"
			name="titreQuestion<%=i%>" value="Enoncé" /></label>
	</h2>


	<div>
		<p>Type de réponse</p>
		<label>Checkbox<input type="radio" name="typeQuestion"
			value="checkbox"></label> <br> <label>Bouton Radio<input
			type="radio" name="typeQuestion" value="radio"></label> <br> <label>Champ
			de Texte<input type="radio" name="typeQuestion" value="text_area">
		</label>
	</div>


	<div>
		<p>Réponses</p>

		<label><input type="text" name="reponse0" /></label><br> <label><input
			type="text" name="reponse1" /></label><br>
		<div id="extra<%=i%>"></div>
		<label><input type="button" onclick="addField(<%=i%>);"
			value="Ajouter une réponse" /></label>
	</div>

</div>
<script type="text/javascript">

	<%List<Question> questions = new ArrayList<Question>();
					Iterator it = form.getListe().entrySet().iterator();
					while (it.hasNext()) {
						questions.add((Question) it.next());
					}%>
	
					var nb = 2;
					
	function addField(i) {
		
		var num = parseInt(i);
<%-- 		<%questions.get(i).setNbreponses(questions.get(i).getNbreponses() + 1);%> --%>
<%-- 		var nb = <%=questions.get(i).getNbreponses()%>; --%>

		var extra = document.createElement('label');
		extra.innerHTML = '<input type "text" name="reponse'+ nb +'"/><br>';
		document.getElementById('extra' + num).appendChild(extra);
	}
</script>

<%
	}
	}
%>

</body>
</html>
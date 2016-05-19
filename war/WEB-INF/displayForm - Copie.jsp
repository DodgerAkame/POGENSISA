<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>

<%@ page import="java.util.List"%>
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
	int nb = 0;
	for (Form form : forms) {
		Map<String, Question> buffer = new HashMap<String, Question>();
%>


<h1>
	<%=form.getName()%>
</h1>


<div id="question"></div>


<div id="pattern" style="display: none">
	<div id="questiongen">
		<h2>
			<label>Enoncé de la question :<input type="text"
				name="titreQuestion" value="titreQuestion<%=nb%>" /></label>
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

			<label><input type="text" name="reponse <%=0%>" /></label><br>
			<label><input type="text" name="reponse <%=1%>" /></label><br>
			<div id="extra<%=nb%>"></div>
			<label><input type="button" onclick="addField(<%=nb%>);"
				value="Ajouter une réponse" /></label>
		</div>
		<br>

		<%
			}
		%>
	</div>
</div>


<label><input type="button" value="Ajouter question"
	onclick="addQuestion();" /></label>

<script type="text/javascript">
	var lol = document.getElementById('questiongen');
	var mdr = <%=nb%>;
	
	
	function addField(i) {
		var num = parseInt(i);
		var extra = document.createElement('span');
		extra.innerHTML = '<input type "text" name="reponse "><br>';
	
		document.getElementById('extra' + num).appendChild(extra);
	
	}
	
	function addQuestion(){
		//var question = document.getElementById('questiongen');
		alert(lol.innerHTML);
		var ptdr = document.getElementById('question');
		
		ptdr.innerHTML = lol.innerHTML;
		ptdr.id = 'questiongen' + mdr;
		
		
		document.getElementby('question').appendChild(ptdr);
		
		<%=nb++%>
	}
	
	
</script>

</body>
</html>
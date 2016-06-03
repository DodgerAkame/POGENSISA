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
<body>
	<%
		List<Form> forms = (List<Form>) request.getAttribute("form");
		for (Form form : forms) {
	%>



	<h1>
		<%=form.getName()%>
	</h1>
	<%!ListeQuestion qs = new ListeQuestion();%>

	<%
		for (int i = 0; i < form.getNbquestions(); i++) {
				qs.addQuestion(i, new Question());
	%>
	<form method="post" action="">
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

				<label><input type="text" name="reponse0" /></label><br>
				<div id="extra<%=i%>"></div>
				<label><input type="button" onclick="addField(<%=i%>);"
					value="Ajouter une réponse" /></label>
			</div>



		</div>

		<a href="/panel"> <input type="submit" />
		</a>

	</form>

	<script type="text/javascript">

	function addField(i) {
		
		var num = parseInt(i);
		var nb = <%=qs.getQuestionIndex(i).getNbreponses()%>;
		
		var extra = document.createElement('label');
		extra.innerHTML = '<input type "text" name="reponse'+ nb +'"/><br>';
		document.getElementById('extra' + num).appendChild(extra);
		<%qs.getQuestionIndex(i).incrNbReponse();%>
		alert(<%=qs.getQuestionIndex(i).getNbreponses()%>);
		
	}
	
</script>


	<%
		}
		}
	%>

</body>
</html>
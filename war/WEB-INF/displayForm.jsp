<%@page import="java.util.StringTokenizer"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<%@ page import="static com.googlecode.objectify.ObjectifyService.ofy"%>

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
<title>Formulaire - création</title>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>

	<div id="headercontainer">
		<div id="header">
			<h1>POGENSISA</h1>
		</div>
	</div>

	<div id="content">
		<%
			List<Form> forms = (List<Form>) request.getAttribute("formfilter");
			Form form = forms.get(forms.size() - 1);
			List<Question> question = (List<Question>) request.getAttribute("question");
		%>

		<form method="post" action="">

			<h2>
				Titre du formulaire :<label><input type="text"
					name="formName" /></label>
			</h2>

			<div name="question0">
				<h3>
					<label>Enoncé de la question :<input type="text"
						name="titreQuestion0" value="Enoncé" /></label>
				</h3>
				<p>

					<label>Categorie de la question :<input type="text"
						name="categorie0" value="categorie" /></label>
				</p>


				<div>
					<p>Type de réponse</p>
					<label>Checkbox<input type="radio" name="typeQuestion0"
						value="checkbox" checked></label> <br> <label>Bouton
						Radio<input type="radio" name="typeQuestion0" value="radio">
					</label> <br> <label>Champ de Texte<input type="radio"
						name="typeQuestion0" value="text">
					</label>
				</div>


				<div>
					<p>Réponses</p>

					<label><input type="text" name="0reponse0" /></label><br>
					<div id="extra0"></div>
					<label><input type="button" onclick="addField(0);"
						value="Ajouter une réponse" /></label>
				</div>
				<label><input type="hidden" value="1" id="numberAnswer0"
					name="numberAnswer0"></label>
			</div>


			<div id="extraQuestion"></div>
			<label><input type="hidden" value="1" id="numberQuestion"
				name="numberQuestion"></label> <label><input type="button"
				value="Ajouter une question" onClick="addQuestion();"></label>

			<script type="text/javascript">
				function addField(i) {
					var num = parseInt(i);
					var nb = document.getElementById("numberAnswer" + num).value;

					var extra = document.createElement('label');
					extra.innerHTML = '<input type="text" name="'+ num +'reponse'+ nb +'"/><br>';
					document.getElementById('extra' + num).appendChild(extra);
					document.getElementById("numberAnswer" + num).value = parseInt(nb) + 1;
				}

				function addQuestion() {
					var nb = document.getElementById("numberQuestion").value;

					var extra = document.createElement('div');
					extra.setAttribute("name", "question" + nb);
					extra.innerHTML = '<h3><label>Enoncé de la question :<input type=\"text\"name=\"titreQuestion' + nb +'\" value=\"Enoncé\" /></label></h3><p><label>Categorie de la question :<input type=\"text\"name=\"categorie' + nb +'\" value=\"categorie\" /></label></p><div><p>Type de réponse</p><label>Checkbox<input type=\"radio\"name=\"typeQuestion' + nb +'\" value=\"checkbox\" checked></label> <br><label>Bouton Radio<input type=\"radio\"name=\"typeQuestion' + nb +'\" value=\"radio\"></label> <br> <label>Champ de Texte<input type=\"radio\"name=\"typeQuestion' + nb +'\" value=\"text\"></label></div><div><p>Réponses</p><label><input type=\"text\" name=\"' + nb +'reponse0\" /></label><br><div id=\"extra' + nb +'\"></div><label><input type=\"button\" onclick=\"addField('
							+ nb
							+ ');\"value=\"Ajouter une réponse\" /></label></div><label><input type=\"hidden\" value=\"1\"id=\"numberAnswer' + nb +'\" name=\"numberAnswer' + nb +'\"></label></div>';

					var extraQuestion = document
							.getElementById("extraQuestion");
					extraQuestion.appendChild(extra);

					document.getElementById("numberQuestion").value = parseInt(nb) + 1;

				}
			</script>

			<fieldset>

				<!-- Form Name -->
				<legend>Question déjà crée</legend>
				<%
					Compoment c = new Compoment();
				%>
				<%=c.PanelQ(question)%>


			</fieldset>
			<input type="submit" /> </a>
		</form>

	</div>

	<div id="footer">
		POGENSISA<br> Template CSS © <a
			href="http://www.oswd.org/design/preview/id/3495/">AJ Industries
			Australia Website Design</a>
	</div>


</body>
</html>
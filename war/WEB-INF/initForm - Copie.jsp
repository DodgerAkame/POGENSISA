<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<%@ page import="java.util.List"%>
<%@ page import="guestbookobjectify.GuestbookObjectifyServlet"%>
<%@ page import="guestbookobjectify.*"%>

<!DOCTYPE html>

<html>
<head>
<title>POGENSISA</title>
<meta charset="utf-8" />
</head>

<body>
	<form method="post" onSubmit="window.location.reload()">
		<p>
			<label><h1>Titre du formulaire</h1> <input type="text"
				name="nameform" /></label>
		</p>

		<p>
			<label>Combien de questions ?<input type="number"
				name="nbquestion" /></label>
		</p>

		<a href="/formcreator"> <input type="submit" name="action"
			value="Créer" />
		</a>
	</form>

	<br>
	<br>

	<a href="/creation">CRUD</a>

	<br>
	<br>


	<form method="post">
		<div class="form-horizontal">
		<fieldset>
			<legend>Historique</legend>
			<%
				List<Form> forms = (List<Form>) request.getAttribute("form");
				for (Form form : forms) {
			%>
			<p><%=form.getName()%></p>
			<p><%=form.getDate()%></p>
			<p>
				<%
					if (form.isOpened()) {
				%>Ouvert
				<%
					} else {
				%>Fermé
				<%
					}
				%>
			</p>

			<%
				if (form.isOpened()) {
			%>
			<input type="checkbox" name="Open" value="<%=form.getId()%>" checked />
			<%
				} else {
			%>
			<input type="checkbox" name="Open" value="<%=form.getId()%>" />
			<%
				}
			%>

			<a href="/results/<%=form.getId()%>"><button name="action"
					value="redirection/<%=form.getId()%>">Voir</button></a> <a
				href="/results/<%=form.getId()%>"><button name="action"
					value="reponse/<%=form.getId()%>">Répondre</button></a>

			<%
				}
			%>
			</fieldset>
		</div>
		<input type="submit" name="action" value="Mettre à jour" />
	</form>


</body>
</html>
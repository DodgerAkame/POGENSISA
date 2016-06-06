<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<%@ page import="java.util.List"%>
<%@ page import="guestbookobjectify.*"%>
<%@ page import="com.google.appengine.api.users.*"%>

<%
	UserService userService = UserServiceFactory.getUserService();
%>

<!DOCTYPE html>

<html>
<head>
<title>POGENSISA</title>
<meta charset="utf-8" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
</head>

<div id="headercontainer">
	<div id="header">
		<h1>POGENSISA</h1>
	</div>
</div>

<body>

	<div id="content">
		<%
			if (userService.getCurrentUser() == null) {
		%>
		<p>
			<a href="<%=userService.createLoginURL("/")%>">Se connecter</a>
		</p>
		<%
			} else {
		%>
		<p>
			Bonjour
			<%=userService.getCurrentUser().getNickname()%></p>

		<p>
			<a href="<%=userService.createLogoutURL("/")%>">Se déconnecter</a>
		</p>
		<%
			}
		%>

		<form method="post" onSubmit="window.location.reload()">
			<p>
				<label><h1>Titre du formulaire</h1> <input type="text"
					name="nameform" /></label>
			</p>

			<p>
				<label>Combien de questions ? <br> <input type="number"
					name="nbquestion" /></label>
			</p>

			<a href="/formcreator"> <input type="submit" name="action"
				value="Créer" class="btn btn-primary" />
			</a>
		</form>

		<br> <br> <a href="/crud">CRUD</a> <br> <br>


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
					<input type="checkbox" name="Open" value="<%=form.getId()%>"
						checked /> <a href="/results/<%=form.getId()%>"><button
							name="action" value="reponse/<%=form.getId()%>">Répondre</button></a>
					<%
						} else {
					%>
					<input type="checkbox" name="Open" value="<%=form.getId()%>" /> <a
						href="/results/<%=form.getId()%>"><button name="action"
							value="redirection/<%=form.getId()%>">Voir</button></a>
					<%
						}
					%>



					<%
						}
					%>
				</fieldset>
			</div>
			<input type="submit" name="action" value="Mettre à jour" />
		</form>
	</div>

	<div id="footer">
		POGENSISA<br> Template CSS © <a
			href="http://www.oswd.org/design/preview/id/3495/">AJ Industries
			Australia Website Design</a>
	</div>

</body>
</html>
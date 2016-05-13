<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<%@ page import="java.util.List"%>
<%@ page import="guestbookobjectify.GuestbookObjectifyServlet"%>
<%@ page import="guestbookobjectify.Formulaire" %>

<!DOCTYPE html>

<html>
<head>
<title>Livre d'or</title>
<meta charset="utf-8" />
</head>

<body>
	<h1>Vous avez aimé mon site ? Dites-le !</h1>
	<% 
	Formulaire form = new Formulaire();
	if(form.getName() == " haha")
		%>
		<% { %>
		<h2> <%= form.getName() %> est dans la base de donnée</h2>
		<% } %>
	<form method="post" action="" onSubmit="window.location.reload()">
		<p>
			<label>Votre nom : <input type="text" name="name" /></label>
		</p>
		<p>
			<input type="submit" />
		</p>
	</form>
</body>
</html>
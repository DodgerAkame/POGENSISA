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

<body><% String name; %>
	<h1>Vous avez aimé mon site ? Dites-le !</h1>
	
	<form method="post" action="" onSubmit="window.location.reload()">
		<p>
			<label>Votre nom : <input type="text" name="name" /></label>
			<% Formulaire form = new Formulaire(); %>
			<%= form.create_title("name") %>
		</p>
		<p>
			<input type="submit" />
		</p>
	</form>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<%@ page import="java.util.List"%>
<%@ page import="guestbookobjectify.GuestbookObjectifyServlet"%>
<%@ page import="guestbookobjectify.Message" %>

<!DOCTYPE html>

<html>
<head>
<title>Livre d'or</title>
<meta charset="utf-8" />
</head>

<body>
	<h1>Vous avez aimé mon site ? Dites-le !</h1>
	<form method="post" action="" onSubmit="window.location.reload()">
		<p>
			<label>Votre nom : <input type="text" name="name" /></label>
		</p>
		<p>
			<label>Votre message : <textarea name="message"
					style="width: 200px; height: 100px;"></textarea></label>
		</p>
		<p>
			<input type="submit" />
		</p>
	</form>

	<h1>Ils ont aimé :</h1>
	<p>
		<em>(et c'est stocké dans le Datastore !)</em>
	</p>
	<%
		List<Message> messages = (List<Message>) request.getAttribute("messages");
		for (Message message : messages) {
	%>
	<p>
		<strong><%=message.getName()%></strong> a écrit :

		<%=message.getMessage()%>
	</p>
	<%
		}
	%>
</body>
</html>
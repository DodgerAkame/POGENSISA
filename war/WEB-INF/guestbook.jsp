<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<%@ page import="java.util.List"%>
<%@ page import="guestbookobjectify.GuestbookObjectifyServlet"%>
<%@ page import="guestbookobjectify.Message"%>

<!DOCTYPE html>

<html>
<head>
<title>Livre d'or</title>
<meta charset="utf-8" />
</head>

<body>
	<form method="post" action="" onSubmit="window.location.reload()">
		<h2>Checkboxes</h2>
		<p>
			<label>Option 1 <input type="checkbox" name="option"
				value="Option 1"></label>
		</p>
		<p>
			<label>Option 2 <input type="checkbox" name="option"
				value="Option 2"></label>
		</p>
		<p>
			<label>Option 3 <input type="checkbox" name="option"
				value="Option 3"></label>
		</p>
		<p>
			<label>Option 4 <input type="checkbox" name="option"
				value="Option 4"></label>
		</p>
		<h2>Radio Buttons</h2>
		<p>
			<label>Bouton 1<input type="radio" name="button" checked
				value="Bouton 1" /></label>
		</p>
		<p>
			<label>Bouton 2<input type="radio" name="button"
				value="Bouton 2" /></label>
		</p>
		<p>
			<input type="submit" />
		</p>
	</form>
	
	<br>
	<br>

	<h1>Résultats:</h1>
	<%
		List<Message> messages = (List<Message>) request.getAttribute("messages");
		for (Message message : messages) {
	%>
	<p>
		<%-- 		<strong><%=message.getName()%></strong> a écrit : --%>

		<%-- 		<%=message.getMessage()%> --%>
		<strong>Options cochées</strong>
		<%
			for (int i = 0; i < message.getCheckboxes().size(); i++) {
		%>
	
	<p>
		<%=message.getCheckboxes().get(i)%>
	</p>
	<%
		}
	%>
	<%=message.isCheck()%>
	<%
		}
	%>
</body>
</html>
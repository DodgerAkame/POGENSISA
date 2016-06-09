<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.StringTokenizer"%>

<%@ page import="guestbookobjectify.CompomentServlet"%>
<%@ page import="guestbookobjectify.*"%>



<!DOCTYPE html>

<html>
<head>
<title>Formulaire</title>
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
		String uri = (String) request.getAttribute("IDForm");
		List<Form> forms = (List<Form>) request.getAttribute("form");
		Form lastElement = new Form();
		for (Form form : forms) {
			if (form.getId().toString().equalsIgnoreCase(uri)) {
				lastElement = form;
				break;
			}
		}
		Compoment c = new Compoment();

		if (lastElement.isOpened()) {
	%>
	<form method="post">

		<%=c.Panel(lastElement)%>

		<br>
		<br>
		<a href="/results/<%=lastElement.getId()%>"> <input type="submit" /></a>
	</form>
	<%
		} else {
	%>
	<p>Le questionnaire est fermé, les résultats sont disponibles à
		l'adresse suivante :</p>
	<br>
	<p>
		<a href="/results/<%=lastElement.getId()%>">Resultats du
			questionnaire</a>
	</p>
	<%
		}
	%>
</div>
	<div id="footer">
		POGENSISA<br> Template CSS © <a
			href="http://www.oswd.org/design/preview/id/3495/">AJ Industries
			Australia Website Design</a>
	</div>


</body>
</html>

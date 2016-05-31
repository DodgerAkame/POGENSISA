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
<title>Livre d'or</title>
<meta charset="utf-8" />
</head>
<body>


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
	%>
	<form method="post">

		<%=c.Panel(lastElement)%>

		<input type="submit" />
	</form>

</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<%@ page import="static com.googlecode.objectify.ObjectifyService.ofy" %>

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
		List<Form> forms = (List<Form>) request.getAttribute("formhistorique");

	%>
	<form method="post" action="">
		
<fieldset>

<!-- Form Name -->
<legend>Historique</legend>
<%
Compoment c = new Compoment(); %>
<%= c.PanelF(forms) %>


</fieldset>
<a href="/panel"> <input type="submit" />
		</a>
</form>
		


</body>
</html>
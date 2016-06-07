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
		List<Question> qs = (List<Question>) request.getAttribute("question");
		List<String> cat = (List<String>) request.getAttribute("categorie");
	%>
	<form method="post" action="">
		
<fieldset>

<!-- Form Name -->
<legend>List Question</legend>
<%
Compoment c = new Compoment(); 
%>
<%
Map<String,List<Question>> q = (Map<String,List<Question>>) request.getAttribute("haha") ;
%>
<%= c.PanelM(q) %>


</fieldset>
<%= c.Button("suprimer") %>
</form>
<script type="text/javascript">
function show(){
	var selectElmt = document.getElementById("select");
	var v = selectElmt.options[selectElmt.selectedIndex].value;
	document.getElementById(v).style.visibility="visible";

}

</script>
</body>
</html>
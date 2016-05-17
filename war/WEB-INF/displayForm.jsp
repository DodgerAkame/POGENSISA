<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<%@ page import="java.util.List"%>
<%@ page import="guestbookobjectify.GuestbookObjectifyServlet"%>
<%@ page import="guestbookobjectify.*"%>

<!DOCTYPE html>

<html>
<head>
<title>Livre d'or</title>
<meta charset="utf-8" />
</head>

<%
	List<Form> forms = (List<Form>) request.getAttribute("form");
	for (Form form : forms) {
		for (int i = 0; i < form.getNbquestions(); i++) {
%>
		<p>
			<label>Option <%=i%><input type="checkbox" name="option"
				value="Option<%=i%>"></label>
		</p>
<%
	}
	}
%>

</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<%@ page import="java.util.List"%>
<%@ page import="guestbookobjectify.GuestbookObjectifyServlet"%>
<%@ page import="guestbookobjectify.*"%>

<!DOCTYPE html>

<html>
<head>
<title>POGENSISA</title>
<meta charset="utf-8" />
</head>

<body>
	<form method="post" action="" onSubmit="window.location.reload()">
		<p>
			<label><h1>Titre du formulaire</h1>
				<input type="text" name="nameform" /></label>
		</p>

		<p>
			<label>Combien de questions ?<input type="number"
				name="nbquestion" /></label>
		</p>

		<a href="/formcreator">
			<input type="submit"/>
		</a>
	</form>

	<br>
	<br>

<a href="/creation">CRUD</a>

</body>
</html>
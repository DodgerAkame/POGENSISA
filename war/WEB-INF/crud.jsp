<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<%@ page import="static com.googlecode.objectify.ObjectifyService.ofy"%>

<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>

<%@ page import="guestbookobjectify.*"%>


<!DOCTYPE html>

<html>
<head>
<title>Gestion des questions</title>
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
		<a href="/creation"> Ajouter des questions </a> <a href="/delete">Supprimer des questions </a> <a
			href="/update">Mettre à jour les questions </a> <br> <br> <input type="file"
			id="fileinput" onchange='openFile(event)' />
		<form method="post">
			<div id="output"></div>
			<br>
			<br>
			<input name="option" type="submit" value="Importer" />
			<br>
			<br>
			<input name="option" type="submit" value="Exporter" />
		</form>

	</div>

	<div id="footer">
		POGENSISA<br> Template CSS © <a
			href="http://www.oswd.org/design/preview/id/3495/">AJ Industries
			Australia Website Design</a>
	</div>

	<script type="text/javascript">
		var openFile = function(event) {
			var input = event.target;

			var reader = new FileReader();
			reader.onload = function() {
				var text = reader.result;
				var node = document.getElementById('output');
				node.innerHTML = '<input type="hidden" name="textImport" value="' + text +'" /> ';
			};
			reader.readAsText(input.files[0]);
		};
		

		document.getElementById('fileinput').addEventListener('change',
				readSingleFile, false);
	</script>
</body>
</html>
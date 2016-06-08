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
<title>POGENSISA</title>
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
		<a href="/creation"> creation </a> <a href="/delete">delete </a> <a
			href="/update">update </a> <br> <br> <input type="file"
			id="fileinput" onchange='openFile(event)' />
		<form method="post">
			<div id="output"></div>
			<input type="submit" />
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
				//console.log(reader.result.substring(0, 200));
			};
			reader.readAsText(input.files[0]);
		};

		document.getElementById('fileinput').addEventListener('change',
				readSingleFile, false);
	</script>
</body>
</html>
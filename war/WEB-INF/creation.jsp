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
<%= c.WriteSelect(cat) %>
<%= c.Button("send") %>
</fieldset>
</form>

	<form method="post" action="">
		<div name="question">
			<h2>
				<label>Enoncé de la question :<input type="text"
					name="titreQuestion" value="Enoncé" /></label>
			</h2>
			<p>
				<label>Categorie de la question :
				<%= c.WriteSelect(cat) %> 
				
				<input type="button" onclick="addCat();" value="+" />
				<div id="cat"></div>
				 </label>
				 <%
   String qte="" ;
   if ( request.getParameter("select") != null )
   {
       qte=request.getParameter("select") ;
   } ;
%>
<input type="hidden" name="cookicat" value= <%= qte %> />
			</p>

			<div>
				<p>Type de réponse</p>
				<label>Checkbox<input type="radio" name="typeQuestion"
					value="checkbox" checked></label> <br> <label>Bouton Radio<input
					type="radio" name="typeQuestion" value="radio"></label> <br>
				<label>Champ de Texte<input type="radio"
					name="typeQuestion" value="text">
				</label>
			</div>


			<div>
				<p>Réponses</p>

				<label><input type="text" name="reponse0" /></label><br>
				<div id="extra"></div>
				<label><input type="button" onclick="addField();"
					value="Ajouter une réponse" /></label>
			</div>
			<label><input type="hidden" value="1" id="numberAnswer" name="numberAnswer"></label>



		</di1v>


<a href="/creation"> <input type="submit" />
		</a>
</form>


		<script type="text/javascript">
		
		
		
	function addField() {
		
<%-- 		var nb = <%=qs.getQuestionIndex(i).getNbreponses()%>; --%>
<%-- 		var nb = document.getElementById("numberAnswer").value; --%>
		
		
		var extra = document.createElement('label');
		extra.innerHTML = '<input type "text" name="reponse"/><br>';
		document.getElementById('extra').appendChild(extra);
		document.getElementById("numberAnswer").value = parseInt(nb) + 1;
		
	}
	function addCat(){
		var extra = document.createElement('label');
		extra.innerHTML = '<input type "text" name="cat"/><br>';
		document.getElementById('cat').appendChild(extra);
	}
	
</script>



</body>
</html>
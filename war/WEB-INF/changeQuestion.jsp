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
		Checking h = (Checking) request.getAttribute("histo");

	List<String> cat = (List<String>) request.getAttribute("categorie");
	%>
	<% Compoment compo = new Compoment();
				%>
	<%!ListeQuestion qs = new ListeQuestion();%>

	<%
	int x = h.getQuestion().size();
	System.out.println(x);
		for (int i = 0; i < x; i++) {
			qs.addQuestion(i, new Question());
			qs.getMap().get(i).setNbreponses(1);
			Question q = h.getQuestion().get(i);
	%>

	<form method="post" action="">
		<div name="question<%=i%>">
			<h2>
				<label>Enoncé de la question :<input type="text"
					name="titreQuestion<%=i%>" value=<%= q.getEnonce() %> /></label>
			</h2>
			<input type="hidden" name="Id<%= i %>" value=<%= q.getId() %> />
			<p>
				<label>Categorie de la question :
				<%= compo.WriteSelect2(cat,i) %> 
				<label><input type="text" name="cat<%= i %>" value=<%= q.getCategorie() %> /></label><br>
				<div id="cat"></div>
				 </label>
			</p>

			<div>
				<p>Type de réponse</p>
				<% String a ="";String b ="";String c ="";
				System.out.println(q.getQuestion());
				if (q.getQuestion().equals("checkbox")){
					a = "checked";
				};
				if (q.getQuestion().equals("radio")){
					b = "checked";
				};
				if (q.getQuestion().equals("text")){
					c = "checked";
				};
				
				%>
				<label>Checkbox<input type="radio" name="typeQuestion<%=i%>"
					value="checkbox" <%= a %>></label> <br> <label>Bouton Radio<input
					type="radio" name="typeQuestion<%=i%>" value="radio" <%= b %>></label> <br>
				<label>Champ de Texte<input type="radio"
					name="typeQuestion<%=i%>" value="text" <%= c %>>
				</label>
			</div>


			<div>
				<p>Réponses</p>
				
				<%= compo.Field(q.getReponses(),i) %>
				<!--  <label><input type="text" name="<%=i%>reponse0" value="haha" /></label><br>-->
				<div id="extra<%=i%>"></div>
				<label><input type="button" onclick="addField(<%=i%>);"
					value="Ajouter une réponse" /></label>
			</div>
			<label><input type="hidden" value="<%= q.getNbreponses() %>" id="numberAnswer<%=i%>" name="numberAnswer<%=i%>" /></label>



		</div>



		<script type="text/javascript">

	function addField(i) {
		
		var num = parseInt(i);
<%-- 		var nb = <%=qs.getQuestionIndex(i).getNbreponses()%>; --%>
		var nb = document.getElementById("numberAnswer" + num).value;
		
		
nu		var extra = document.createElement('label');
		extra.innerHTML = '<input type "text" name="'+ num +'reponse'+ nb +'"/><br>';
		document.getElementById('extra' + num).appendChild(extra);
		document.getElementById("numberAnswer" + num).value = parseInt(nb) + 1;
		
	}
	function addCat(i){
		var num = parseInt(i);
		var extra = document.createElement('label');
		extra.innerHTML = '<input type="text" name="cat'+i+'"/><br>';
		document.getElementById('cat').appendChild(extra);
	}
	
</script>


		<%
			}
		%>
<a href="/panel"> <input type="submit" />
		</a>
</form>
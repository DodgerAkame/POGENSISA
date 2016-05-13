<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="com.google.appengine.api.datastore.*"%>
<%@ page import="java.util.List"%>
<%@ page import="guestbookobjectify.GuestbookObjectifyServlet"%>
<%@ page import="guestbookobjectify.Formulaire" %>

<!DOCTYPE html>

<html>
<head>
<title>

<% Formulaire form = new Formulaire();
	String name = form.getName(); //ici il faut mettre la fonction pour récupéré le nom de notre form dans la base de donnée
%>
<%= name %>
</title>
<meta charset="utf-8" />

</head>

<body>
<%-- <h1><%= name %></h1> --%>

<%-- <%  --%>
// 	List<Question> questions = new ArrayList<Question>();
// 	for(Question question: questions)
<%-- %> --%>
<%-- <% { %> --%>
<!-- <form class="form-horizontal"> -->
<!-- <fieldset> -->

<!-- <!-- Form Name --> -->
<%-- <legend><%= question.getName() %></legend> --%>

<%-- <% if(question.CHECKBOXES == true) %> --%>
<%-- <% { %> --%>
<!-- <!-- Multiple Checkboxes --> -->
<!-- <div class="form-group"> -->
<!--   <label class="col-md-4 control-label" for="checkboxes"></label> -->
<!--   <div class="col-md-4"> -->
<!--   <div class="checkbox"> -->
<!--     <label for="checkboxes-0"> -->
<!--       <input name="checkboxes" id="checkboxes-0" value="1" type="checkbox"> -->
<!--       Option one -->
<!--     </label> -->
<!-- 	</div> -->
<!--   <div class="checkbox"> -->
<!--     <label for="checkboxes-1"> -->
<!--       <input name="checkboxes" id="checkboxes-1" value="2" type="checkbox"> -->
<!--       Option two -->
<!--     </label> -->
<!-- 	</div> -->
<!--   </div> -->
<!-- </div> -->
<%-- <% } %> --%>
<%-- <% if(question.CHECKBOXESINLINE == true) %> --%>
<%-- <% { %> --%>
<!-- <!-- Multiple Checkboxes (inline) --> -->
<!-- <div class="form-group"> -->
<!--   <label class="col-md-4 control-label" for="checkboxes"></label> -->
<!--   <div class="col-md-4"> -->
<!--     <label class="checkbox-inline" for="checkboxes-0"> -->
<!--       <input name="checkboxes" id="checkboxes-0" value="1" type="checkbox"> -->
<!--       1 -->
<!--     </label> -->
<!--     <label class="checkbox-inline" for="checkboxes-1"> -->
<!--       <input name="checkboxes" id="checkboxes-1" value="2" type="checkbox"> -->
<!--       2 -->
<!--     </label> -->
<!--     <label class="checkbox-inline" for="checkboxes-2"> -->
<!--       <input name="checkboxes" id="checkboxes-2" value="3" type="checkbox"> -->
<!--       3 -->
<!--     </label> -->
<!--     <label class="checkbox-inline" for="checkboxes-3"> -->
<!--       <input name="checkboxes" id="checkboxes-3" value="4" type="checkbox"> -->
<!--       4 -->
<!--     </label> -->
<!--   </div> -->
<!-- </div> -->
<%-- <% } %> --%>
<%-- <% if(question.RADIO == true) %> --%>
<%-- <% { %> --%>
<!-- <!-- Multiple Radios --> -->
<!-- <div class="form-group"> -->
<!--   <label class="col-md-4 control-label" for="radios"></label> -->
<!--   <div class="col-md-4"> -->
<!--   <div class="radio"> -->
<!--     <label for="radios-0"> -->
<!--       <input name="radios" id="radios-0" value="1" checked="checked" type="radio"> -->
<!--       Option one -->
<!--     </label> -->
<!-- 	</div> -->
<!--   <div class="radio"> -->
<!--     <label for="radios-1"> -->
<!--       <input name="radios" id="radios-1" value="2" type="radio"> -->
<!--       Option two -->
<!--     </label> -->
<!-- 	</div> -->
<!--   </div> -->
<!-- </div> -->
<%-- <% } %> --%>
<%-- <% if(question.RADIOINLINE == true) %> --%>
<%-- <% { %> --%>
<!-- <!-- Multiple Radios (inline) --> -->
<!-- <div class="form-group"> -->
<!--   <label class="col-md-4 control-label" for="radios"></label> -->
<!--   <div class="col-md-4">  -->
<!--     <label class="radio-inline" for="radios-0"> -->
<!--       <input name="radios" id="radios-0" value="1" checked="checked" type="radio"> -->
<!--       1 -->
<!--     </label>  -->
<!--     <label class="radio-inline" for="radios-1"> -->
<!--       <input name="radios" id="radios-1" value="2" type="radio"> -->
<!--       2 -->
<!--     </label>  -->
<!--     <label class="radio-inline" for="radios-2"> -->
<!--       <input name="radios" id="radios-2" value="3" type="radio"> -->
<!--       3 -->
<!--     </label>  -->
<!--     <label class="radio-inline" for="radios-3"> -->
<!--       <input name="radios" id="radios-3" value="4" type="radio"> -->
<!--       4 -->
<!--     </label> -->
<!--   </div> -->
<!-- </div> -->
<%-- <% } %> --%>
<%-- <% if(question.TEXTAREA == true) %> --%>
<%-- <% { %> --%>
<!-- <!-- Textarea --> -->
<!-- <div class="form-group"> -->
<!--   <label class="col-md-4 control-label" for="textarea"></label> -->
<!--   <div class="col-md-4">                      -->
<!--     <textarea class="form-control" id="textarea" name="textarea">default text</textarea> -->
<!--   </div> -->
<!-- </div> -->
<%-- <% } %> --%>
<!-- <!-- Button --> -->
<!-- <div class="form-group"> -->
<!--   <label class="col-md-4 control-label" for="singlebutton"></label> -->
<!--   <div class="col-md-4"> -->
<!--     <button id="singlebutton" name="singlebutton" class="btn btn-primary">Send</button> -->
<!--   </div> -->
<!-- </div> -->

<!-- </fieldset> -->
<!-- </form> -->
<%-- <% } %> --%>
</body>
</html>
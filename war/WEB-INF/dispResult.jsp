<%@page import="java.util.StringTokenizer"%>
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
<title>Résultats</title>
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
		<%
			String uri = (String) request.getAttribute("IDFormResult");
			Form form = (Form) request.getAttribute("formResult");
			List<User> users = (List<User>) request.getAttribute("users");
			form.setUsersAnswered(users.size());
		%>

		<h1><%=form.getName()%></h1>
		<p>
			Nombre d'utilisateurs ayant répondu :
			<%=form.getUsersAnswered()%>
			personnes
		</p>
		<%
			if (!form.isOpened()) {
				for (int i = 0; i < form.getNbquestions(); i++) {
					Question qs = form.getListe().get(i);
		%>

		<h2><%=qs.getEnonce()%></h2>
		<h4>
			<u>Type de la question</u> :
			<%=qs.getQuestion().toString()%></h4>


		<div name="reponses<%=i%>">
			<%
				if (qs.getQuestion().toString() != "text") {
							for (int j = 0; j < qs.getReponses().size(); j++) {
			%>
			<p><%=qs.getReponses().get(j).getReponse()%>
				&nbsp; &nbsp; &nbsp;
				<%
					for (User user : users) {

										Reponse rep = user.getReponses().get(qs.getEnonce());
										StringTokenizer st = new StringTokenizer(rep.getReponse(), "|");
										while (st.hasMoreTokens()) {
											String stbuff = st.nextToken().toString();

											if (stbuff.equals(qs.getReponses().get(j).getReponse()))
												qs.getReponses().get(j).incrEffectif();

										}

									}
				%><%=(qs.getReponses().get(j).getEffectif() / form.getUsersAnswered()) * 100%>
				%
				<%-- On affiche ici --%>
			</p>
			<br>
			<%
				}
						} else {
			%><button type="button"
				onClick="document.getElementById('text<%=i%>').style.display='inline-block';">Afficher
				les réponses</button>
			<button type="button"
				onClick="document.getElementById('text<%=i%>').style.display='none';">Cacher
				les réponses</button>
			<br>
			<div id="text<%=i%>" style="display: none">
				<%
					for (User user : users) {
				%>

				<p><%=user.getReponses().get(qs.getEnonce()).getReponse()%></p>
				<br>
				<%
					}
				%>
			</div>
			<%
				}
			%>

		</div>
		<br>

		<form method="post">
			<input type="submit" value="Exporter les résultats" />
		</form>

		<%
			}
			} else {
		%>
		<b><u>Le questionnaire est en cours, veuillez attendre la
				clôture du questionnaire</u></b>
		<%
			}
		%>


	</div>

	<div id="footer">
		POGENSISA<br> Template CSS © <a
			href="http://www.oswd.org/design/preview/id/3495/">AJ Industries
			Australia Website Design</a>
	</div>


</body>
</html>
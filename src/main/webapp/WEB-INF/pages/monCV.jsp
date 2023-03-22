<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hugo Naze</title>
</head>
<body>

<%@ include file="/WEB-INF/parts/header.jsp" %>

<main>
	<div class="nom-prenom">
		<h3>${requestScope.personne.prenom} ${requestScope.personne.nom}</h3>
	</div>
	
	<div class="statut">
		<h6>${requestScope.personne.statut}</h6>
	</div>
	
	<div class="description">
		<p>${requestScope.personne.description}</p>
	</div>
	
	<div class="titre-competences">
		<h4>COMPÉTENCES</h4>
	</div>
	
	<div class="competences">
				<c:forEach items="${requestScope.personne.competences}" var="competence">
		<div class="competence">
			<h5>${competence.appellation}</h5>
			<p>${competence.description}</p>
		</div>
				</c:forEach>
	</div>
	
	<div class="titre-soft-skills">
		<h4>SOFT SKILLS</h4>
	</div>
	
	<div class="soft-skills">
				<c:forEach items="${requestScope.personne.soft_skills}" var="soft-skill">
		<div class="soft-skill">
			
		</div>
				</c:forEach>
	</div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width = device-width, initial-scale=1">
<title>Se Connecter</title>
</head>
<body>
<%@ include file="/WEB-INF/parts/header.jsp" %>
	<main>
		<div class="form-connexion">
			<h1>Connexion</h1>
				<div class="exceptions">
					<p>${requestScope.exceptions.toString()}</p>			
				</div>
			<form action="<%= request.getContextPath() %>/connecter" method="post">
				<label for="identifiant">Pseudo : </label>
					<input type="text" name="identifiant" placeholder="Pseudo" id="identifiant" max="30"><br>
				<label for="mdp">Mot de passe : </label>
					<input type="password" name="mdp" placeholder="Mot de passe" id="mdp" max="40"><br>
					<input type="checkbox" name="souvenir" value="true" id="souvenir">
				<label for="souvenir">Se souvenir de moi</label><br>
					<input type="submit" value="Me connecter">	
			</form>
		</div>
		<div class="mdp-oublie">
			<p><a href="<%= request.getContextPath()%>/mdpOublie">Mot de passe / pseudo oublié(s)</a></p>
		</div>
					<c:if test="${!empty requestScope.mdpOublie}">
		<div class="form-mdp-oublie">
			<form action="<%=request.getContextPath()%>/mdpOublie" method="post">
				<label for="email-oublie">Indiquez votre email : </label>
					<input type="email" name="email-oublie" id="email-oublie" placeholder="Email" max="40" value="${requestScope.userOublie.email}" required>
				<label for="couleur-oublie">Quelle est votre couleur préférée ? </label>
					<input type="text" name="couleur-oublie" id="couleur-oublie" placeholder="Indigo du web" max="40" value="${requestScope.userOublie.couleur_preferee}" required>
					<input type="submit" value="Valider">
			</form>
		</div>
		<div class="exceptions">
			<p>${requestScope.exceptionsOublie.toString()}</p>
		</div>
					</c:if>
					<c:if test="${!empty requestScope.userRappel}">
		<div class="rappel-identifiants">
			<p>Votre pseudo : "${requestScope.userRappel.pseudo}"</p>
			<p>Votre mot de passe : "${requestScope.userRappel.mot_de_passe}"</p>
		</div>
					</c:if>
		<div class="s'inscrire">
			<h2><a href="<%= request.getContextPath() %>/inscription">S'inscrire</a></h2>
		</div>
	</main>

<%@ include file="/WEB-INF/parts/footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S'inscrire</title>
</head>
<body>
<%@ include file="/WEB-INF/parts/header.jsp" %>
<main>
	<h1>Formulaire d'inscription</h1>
	<div class="exceptions">
	<p>${requestScope.exceptions.toString()}</p>
	</div>
	<div class="form-inscription">
		<form action="<%= request.getContextPath() %>/inscription" method="post">
			<label for="pseudo">Pseudo : </label>
			<input type="text" name="pseudo" id="pseudo" placeholder="Indiquez le pseudo souhaité" required><br>
			<label for="email">Adresse email : </label>
			<input type="text" name="email" id="email" placeholder="Indiquez votre adresse email" required><br>
			<label for="mdp">Mot de passe : </label>
			<input type="password" name="mdp" id="mdp" placeholder="Indiquez votre mot de passe" required><br>
			<label for="confirm-mdp">Confirmation du mot de passe : </label>
			<input type="password" name="confirm-mdp" id="confirm-mdp" placeholder="Confirmez votre mot de passe" required><br>
			<label for="autorisation">Code d'autorisation d'inscription : </label>
			<input type="text" name="autorisation" id="autorisation" placeholder="Indiquez le code d'autorisation à l'inscription" required><br>
			<label for="couleur">Couleur préférée (à saisir en cas de mot de passe oublié) : </label>
			<input type="text" name="couleur" id="couleur" placeholder="cuisse de nymphe émue" required><br>
			<input type="submit" value="S'inscrire">
		</form>
	</div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
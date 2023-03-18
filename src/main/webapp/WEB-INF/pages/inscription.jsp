<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>S'inscrire</title>
</head>
<body>
	<nav>
		<ul>
			<li>Accueil</li>
			<li>CV</li>
			<li>Me contacter</li>
			<li>S'inscrire</li>
			<li>Se connecter</li>
		</ul>
	</nav>
<main>
	<h1>Formulaire d'inscription</h1>
	<div class="form-inscription">
		<form action="<%= request.getContextPath() %>/inscription" method="post">
			<label for="pseudo">Pseudo : </label>
			<input type="text" name="pseudo" id="pseudo" placeholder="Indiquez le pseudo souhaité" required>
			<label for="email">Adresse email : </label>
			<input type="text" name="email" id="email" placeholder="Indiquez votre adresse email" required>
			<label for="mdp">Mot de passe : </label>
			<input type="text" name="mdp" id="mdp" placeholder="Indiquez votre mot de passe" required>
			<label for="confirm-mdp">Confirmation du mot de passe : </label>
			<input type="text" name="confirm-mdp" id="confirm-mdp" placeholder="Confirmez votre mot de passe" required>
			<label for="autorisation">Code d'autorisation d'inscription : </label>
			<input type="text" name="autorisation" id="autorisation" placeholder="Indiquez le code d'autorisation à l'inscription">
			
		</form>
	</div>
</main>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
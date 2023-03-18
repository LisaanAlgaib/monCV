<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width = device-width, initial-scale=1">
<title>Se Connecter</title>
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
		<div class="form-connexion">
			<h1>Connexion</h1>
			<form action="<%= request.getContextPath() %>/connecter" method="post">
				<label for="identifiant">Pseudo : </label>
				<input type="text" name="identifiant" placeholder="Indiquez votre pseudo" id="identifiant">
				<label for="mdp">Mot de passe : </label>
				<input type="text" name="mdp" placeholder="Indiquez votre mot de passe" id="mdp">
				<input type="checkbox" name="souvenir" value="true" id="souvenir">
				<label for="souvenir">Se souvenir de moi</label>
				<input type="submit" value="Me connecter">	
			</form>
		</div>
		<div class="mdp-oublie">
			<p><a href="#">Mot de passe oublié</a></p>
		</div>
		<div class="s'inscrire">
			<h2><a href="<%= request.getContextPath() %>/inscription">S'inscrire</a></h2>
		</div>
	</main>

<%@ include file="/WEB-INF/parts/footer.jsp" %>
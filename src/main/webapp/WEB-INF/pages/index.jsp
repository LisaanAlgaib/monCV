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
<title>Mon CV</title>
</head>
<body>
	<nav>
		<ul>
			<li>Accueil</li>
			<li>CV</li>
			<li>Me contacter</li>
				<c:if test="${empty sessionScope.utilisateur}">
			<li>S'inscrire</li>
			<li>Se connecter</li>
				</c:if>
				<c:if test="${!empty sessionScope.utilisateur}">
			<li>Se déconnecter</li>
			<li>${sessionScope.utilisateur.pseudo}, Connecté(e)</li>
				</c:if>
		</ul>
	</nav>
	<header>
				<c:if test="${empty sessionScope.utilisateur}">
		<h1>Bonjour, inconnu(e), et bienvenue sur mon CV en ligne !</h1>
				</c:if>
				<c:if test="${!empty sessionScope.utilisateur}">
		<h1>Bonjour ${sessionScope.utilisateur.pseudo}, quel plaisir de vous (re)voir !</h1>
				</c:if>
	</header>
	<main>
		<div class="presentation-accueil">
				<c:if test="${empty sessionScope.utilisateur}">
			<p>Je m'appelle Hugo Naze et vous pourrez trouver sur ce site toutes les informations relatives à mon CV. Étant développeur informatique, celui-ci a pour vocation de fournir un aperçu de mes compétences techniques tout en fournissant les mêmes informations qu'un CV habituel. Cependant, seules les personnes connectées ont la capacité de voir toutes mes informations. Si vous n'avez pas de compte et que vous ne possédez pas le code secret nécessaire à l'inscription, je vous invite à (link) me contacter pour en obtenir un.</p> 
			<br>
			<p>Ce site a été développé en utilisant Eclipse, Java EE (serveur Tomcat V9), le modèle MVC (Modèle-Vue-Contrôleur), SQL Server, les servlets/JSP, les EL (Expressions Languages) ainsi que du CSS. Il se veut dynamique même si la majorité du site aurait pu être développé de manière statique, et ce, afin de donner un aperçu de mes compétences techniques. Le code source du site est accessible <a href="https://github.com/LisaanAlgaib/monCV"><b>ici</a></p>
			<br>
			<p>Bon voyage !</p>
				</c:if>
				<c:if test="${!empty sessionScope.utilisateur}">
			<p>Je m'appelle Hugo Naze et puisque vous êtes connecté(e), vous avez accès à toutes les informations que comporte mon CV ! Étant développeur informatique, ce site a pour vocation de fournir un aperçu de mes compétences techniques tout en fournissant les mêmes informations qu'un CV habituel.</p>
			<br>
			<p>Ce site a été développé en utilisant Eclipse, Java EE (serveur Tomcat V9), le modèle MVC (Modèle-Vue-Contrôleur), SQL Server, les servlets/JSP, les EL (Expressions Languages) ainsi que du CSS. Il se veut dynamique même si la majorité du site aurait pu être développé de manière statique, et ce, afin de donner un aperçu de mes compétences techniques. Le code source du site est accessible <a href="https://github.com/LisaanAlgaib/monCV"><b>ici</a></p>
			<br>
			<p>Bon voyage !</p>
				</c:if>
		</div>
	</main>
	
<%@ include file="/WEB-INF/parts/footer.jsp" %>
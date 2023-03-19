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


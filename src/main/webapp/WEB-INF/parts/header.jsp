<nav>
	<ul>
		<li><a href="<%= request.getContextPath()%>/accueil">Accueil</a></li>
		<li><a href="<%= request.getContextPath()%>/CV">CV</a></li>
		<li><a href="<%= request.getContextPath()%>/contacter">Me contacter</a></li>
			<c:if test="${empty sessionScope.utilisateur}">
		<li><a href="<%= request.getContextPath()%>/inscription">S'inscrire</a></li>
		<li><a href="<%= request.getContextPath()%>/connecter">Se connecter</a></li>
			</c:if>
			<c:if test="${!empty sessionScope.utilisateur}">
		<li><a href="<%= request.getContextPath()%>/deconnecter">Se déconnecter</a></li>
		<li>${sessionScope.utilisateur.pseudo}, Connecté(e)</li>
			</c:if>
	</ul>
</nav>


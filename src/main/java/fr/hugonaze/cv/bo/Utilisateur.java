package fr.hugonaze.cv.bo;

public class Utilisateur {

	private int no_utilisateur;
	private String pseudo;
	private String email;
	private String mot_de_passe;
	private String couleur_preferee;
	private int administrateur;
	
	public Utilisateur() {
		
	}
	
	/**
	 * Constructeur entier de la classe utilisateur, classe issue de l'inscription d'un utilisateur et permettant de se connecter au site
	 * @param pseudo
	 * @param email
	 * @param mot_de_passe
	 * @param couleur_preferee
	 * L'administrateur est mis par défaut sur 0 (false) de sorte que seul le créateur du site puisse accorder les droits d'administration
	 */
	public Utilisateur(String pseudo, String email, String mot_de_passe, String couleur_preferee) {
		setPseudo(pseudo);
		setEmail(email);
		setMot_de_passe(mot_de_passe);
		setCouleur_preferee(couleur_preferee);
		this.administrateur = 0;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMot_de_passe() {
		return mot_de_passe;
	}

	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}

	public String getCouleur_preferee() {
		return couleur_preferee;
	}

	public void setCouleur_preferee(String couleur_preferee) {
		this.couleur_preferee = couleur_preferee;
	}

	public int getAdministrateur() {
		return administrateur;
	}
			
}

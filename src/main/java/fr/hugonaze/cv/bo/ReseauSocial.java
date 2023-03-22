package fr.hugonaze.cv.bo;

public class ReseauSocial {

	private int no_reseau_social;
	private String nom_classe = "RÉSEAUX SOCIAUX";
	private String appellation;
	private String lien;
	private Personne detenteur;
	
	public ReseauSocial() {
		
	}
	
	/**
	 * Constructeur entier de la classe ReseauSocial
	 * @param no_reseau_social est le numéro unique du réseau social. Généré par IDENTITY en BDD
	 * @param appellation est le nom du réseau social en question
	 * @param lien est un lien vers le profil de la personne sur le réseau social en question
	 * @param detenteur est le détenteur / la détenteuse du compte associé au réseau social
	 */
	public ReseauSocial(int no_reseau_social, String appellation, String lien, Personne detenteur) {
		
		setNo_reseau_social(no_reseau_social);
		setAppellation(appellation);
		setLien(lien);
		setDetenteur(detenteur);
	}

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public Personne getDetenteur() {
		return detenteur;
	}

	public void setDetenteur(Personne detenteur) {
		this.detenteur = detenteur;
	}

	public int getNo_reseau_social() {
		return no_reseau_social;
	}

	public void setNo_reseau_social(int no_reseau_social) {
		this.no_reseau_social = no_reseau_social;
	}
	
}

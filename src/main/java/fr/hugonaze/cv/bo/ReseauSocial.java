package fr.hugonaze.cv.bo;

public class ReseauSocial {

	private String appellation;
	private String lien;
	
	public ReseauSocial() {
		
	}
	
	/**
	 * Constructeur entier de la classe ReseauSocial
	 * @param appellation est le nom du réseau social en question
	 * @param lien est un lien vers le profil de la personne sur le réseau social en question
	 */
	public ReseauSocial(String appellation, String lien) {
		setAppellation(appellation);
		setLien(lien);
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
	
	
}

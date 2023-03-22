package fr.hugonaze.cv.bo;

public class Interet {
	
	private int no_interet;
	private String nom_classe = "INTÉRÊTS";
	private String appellation;
	private String image;
	
	public Interet() {
		
	}
	
	/**
	 * Constructeur entier de la classe intérêt, pour les centres d'intérêts
	 * @param no_interet est le numéro unique de l'intérêt en question. Généré par IDENTITY en BDD
	 * @param appellation
	 * @param image
	 */
	public Interet(int no_interet, String appellation, String image) {
		
		setNo_interet(no_interet);
		setAppellation(appellation);
		setImage(image);
	}
	
	/**
	 * Constructeur de la classe intérêt sans le paramètre image
	 * @param appellation
	 */
	public Interet(String appellation) {
		
		setAppellation(appellation);
	}

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getNo_interet() {
		return no_interet;
	}

	public void setNo_interet(int no_interet) {
		this.no_interet = no_interet;
	}
	
}

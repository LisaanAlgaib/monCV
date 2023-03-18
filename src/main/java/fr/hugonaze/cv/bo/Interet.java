package fr.hugonaze.cv.bo;

public class Interet {
	
	private String appellation;
	private String image;
	
	public Interet() {
		
	}
	
	/**
	 * Constructeur entier de la classe intérêt, pour les centres d'intérêts
	 * @param appellation
	 * @param image
	 */
	public Interet(String appellation, String image) {
		
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
	
	
}

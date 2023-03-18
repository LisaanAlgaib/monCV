package fr.hugonaze.cv.bo;

public class SoftSkill {
	
	private String appellation;
	private String image;
	
	public SoftSkill() {
		
	}
	
	/**
	 * Constructeur entier de la classe SoftSkill
	 * @param appellation est le nom du softskill
	 * @param image c'est une icône illustrant le soft skill
	 */
	public SoftSkill(String appellation, String image) {
		
		setAppellation(appellation);
		setImage(image);
	}
	
	/**
	 * Constructeur de la classe SoftSkill sans le paramètre image
	 * @param appellation
	 */
	public SoftSkill(String appellation) {
		
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

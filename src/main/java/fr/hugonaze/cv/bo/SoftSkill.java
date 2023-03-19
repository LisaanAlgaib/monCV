package fr.hugonaze.cv.bo;

public class SoftSkill {
	
	private int no_soft_skill;
	private String appellation;
	private String image;
	
	public SoftSkill() {
		
	}
	
	/**
	 * Constructeur entier de la classe SoftSkill
	 * @param no_soft_skill est le numéro unique du soft skill. Généré par IDENTITY en BDD
	 * @param appellation est le nom du softskill
	 * @param image c'est une icône illustrant le soft skill
	 */
	public SoftSkill(int no_soft_skill, String appellation, String image) {
		
		setNo_soft_skill(no_soft_skill);
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

	public int getNo_soft_skill() {
		return no_soft_skill;
	}

	public void setNo_soft_skill(int no_soft_skill) {
		this.no_soft_skill = no_soft_skill;
	}
	
}

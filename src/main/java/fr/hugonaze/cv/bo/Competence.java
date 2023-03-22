package fr.hugonaze.cv.bo;

public class Competence {

	private int no_competence;
	private String nom_classe = "COMPÉTENCES";
	private String appellation;
	private String description;
	
	public Competence() {
		
	}
	
	public Competence(int no_competence, String appellation, String description) {
		setAppellation(appellation);
		setDescription(description);
		setNo_competence(no_competence);
	}
	
	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNo_competence() {
		return no_competence;
	}

	public void setNo_competence(int no_competence) {
		this.no_competence = no_competence;
	}
	
}

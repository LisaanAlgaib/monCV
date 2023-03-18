package fr.hugonaze.cv.bo;

public class Competence {

	private String appellation;
	private String description;
	
	public Competence() {
		
	}
	
	public Competence(String appellation, String description) {
		setAppellation(appellation);
		setDescription(description);
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
	
	
}

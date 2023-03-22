package fr.hugonaze.cv.bo;

import java.time.LocalDateTime;

public class ExperiencePro {

	private int no_experience_pro;
	private String nom_classe = "EXPÉRIENCES PROFESSIONNELLES";
	private String appellation;
	private String ville;
	private String entreprise;
	private LocalDateTime date_debut_experience;
	private LocalDateTime date_fin_experience;
	private String mission;
	private String[] missions;
	
	public ExperiencePro() {
		
	}
	
	/**
	 * Constructeur entier de la classe ExperiencePro
	 * @param no_experience_pro est le numéro unique de l'expérience pro. Généré par IDENTITY en BDD
	 * @param appellation
	 * @param ville
	 * @param entreprise
	 * @param date_debut_experience
	 * @param date_fin_experience
	 * @param missions
	 */
	public ExperiencePro(int no_experience_pro, String appellation, String ville, String entreprise, LocalDateTime date_debut_experience,
			LocalDateTime date_fin_experience, String[] missions) {
		
		setNo_experience_pro(no_experience_pro);
		setAppellation(appellation);
		setVille(ville);
		setEntreprise(entreprise);
		setDate_debut_experience(date_debut_experience);
		setDate_fin_experience(date_fin_experience);
		setMissions(missions);
	}
	
	/**
	 * Constructeur de la classe ExperiencePro sans missions
	 * @param appellation
	 * @param ville
	 * @param entreprise
	 * @param date_debut_experience
	 * @param date_fin_experience
	 */
	public ExperiencePro(String appellation, String ville, String entreprise, LocalDateTime date_debut_experience,
			LocalDateTime date_fin_experience) {
	
		setAppellation(appellation);
		setVille(ville);
		setEntreprise(entreprise);
		setDate_debut_experience(date_debut_experience);
		setDate_fin_experience(date_fin_experience);
	}

	public String getAppellation() {
		return appellation;
	}
	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	public LocalDateTime getDate_debut_experience() {
		return date_debut_experience;
	}
	public void setDate_debut_experience(LocalDateTime date_debut_experience) {
		this.date_debut_experience = date_debut_experience;
	}
	public LocalDateTime getDate_fin_experience() {
		return date_fin_experience;
	}
	public void setDate_fin_experience(LocalDateTime date_fin_experience) {
		this.date_fin_experience = date_fin_experience;
	}
	public String getMission() {
		return mission;
	}
	public void setMission(String mission) {
		this.mission = mission;
	}
	public String[] getMissions() {
		return missions;
	}
	public void setMissions(String[] missions) {
		this.missions = missions;
	}

	public int getNo_experience_pro() {
		return no_experience_pro;
	}

	public void setNo_experience_pro(int no_experience_pro) {
		this.no_experience_pro = no_experience_pro;
	}
	
}

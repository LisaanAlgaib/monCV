package fr.hugonaze.cv.bo;

import java.time.LocalDateTime;

public class Formation {

	private int no_formation;
	private String nom_classe = "FORMATIONS";
	private String appellation;
	private LocalDateTime date_debut;
	private LocalDateTime date_fin;
	private String organisme;
	private String description;
	private String ville;
	
	public Formation() {
		
	}
	
	/**
	 * Constructeur entier de la classe formation
	 * @param no_formation est le numéro unique de la formation. Généré par IDENTITY en BDD
	 * @param appellation
	 * @param date_debut
	 * @param date_fin
	 * @param organisme
	 * @param description
	 * @param ville
	 */
	public Formation(int no_formation, String appellation, LocalDateTime date_debut, LocalDateTime date_fin, String organisme,
			String description, String ville) {
		
		setNo_formation(no_formation);
		setAppellation(appellation);
		setDate_debut(date_debut);
		setDate_fin(date_fin);
		setOrganisme(organisme);
		setDescription(description);
		setVille(ville);
	}

	public String getAppellation() {
		return appellation;
	}

	public void setAppellation(String appellation) {
		this.appellation = appellation;
	}

	public LocalDateTime getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(LocalDateTime date_debut) {
		this.date_debut = date_debut;
	}

	public LocalDateTime getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(LocalDateTime date_fin) {
		this.date_fin = date_fin;
	}

	public String getOrganisme() {
		return organisme;
	}

	public void setOrganisme(String organisme) {
		this.organisme = organisme;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getNo_formation() {
		return no_formation;
	}

	public void setNo_formation(int no_formation) {
		this.no_formation = no_formation;
	}
		
}


package fr.hugonaze.cv.bo;

public class Personne {
	
	private int no_personne;
	private int no_telephone;
	private String email;
	private int code_postal;
	private String ville;
	private int age;
	private String nationalite;
	private String permis;
	private ReseauSocial[] reseaux_sociaux;
	private String image;
	private SoftSkill[] soft_skills;
	private Competence[] competences;
	private ExperiencePro[] experiences_pros;
	private Formation[] formations;
	private Interet[] interets;
	
	public Personne() {
		
	}
	
	/**
	 * Constructeur entier de la classe personne, classe qui vient remplir la description des informations personnelles de la personne présentée par le CV
	 * @param no_personne est le numéro unique de la personne du CV. Généré par IDENTITY en BDD
	 * @param no_telephone
	 * @param email
	 * @param code_postal
	 * @param ville
	 * @param age
	 * @param nationalite
	 * @param permis
	 * @param reseaux_sociaux est un tableau contenant tous les réseaux sociaux liés à la personne en question
	 * @param image est la photo de la personne sur qui porte le CV
	 * @param soft_skills est un tableau contenant tous les soft skills
	 * @param competences est un tableau contenant toutes les compétences
	 * @param experiences_pros est un tableau contenant toutes les expériences pros
	 * @param formations est un tableau contenant toutes les formations
	 * @param interets est un tableau contenant tous les intérêts
	 */
	public Personne(int no_personne, int no_telephone, String email, int code_postal, String ville, int age, String nationalite,
			String permis, ReseauSocial[] reseaux_sociaux, String image, SoftSkill[] soft_skills,
			Competence[] competences, ExperiencePro[] experiences_pros, Formation[] formations, Interet[] interets) {
		
		setNo_personne(no_personne);
		setNo_telephone(no_telephone);
		setEmail(email);
		setCode_postal(code_postal);
		setVille(ville);
		setAge(age);
		setNationalite(nationalite);
		setPermis(permis);
		setReseaux_sociaux(reseaux_sociaux);
		setImage(image);
		setSoft_skills(soft_skills);
		setCompetences(competences);
		setExperiences_pros(experiences_pros);
		setFormations(formations);
		setInterets(interets);
	}
	
	
	/**
	 * Constructeur de la classe personne sans le paramètre image, classe qui vient remplir la description des informations personnelles de la personne présentée par le CV
	 * @param no_telephone
	 * @param email
	 * @param code_postal
	 * @param ville
	 * @param age
	 * @param nationalite
	 * @param permis
	 * @param reseaux_sociaux
	 * @param soft_skills
	 * @param competences
	 * @param experiences_pros
	 * @param formations
	 * @param interets
	 */
	public Personne(int no_telephone, String email, int code_postal, String ville, int age, String nationalite,
			String permis, ReseauSocial[] reseaux_sociaux, SoftSkill[] soft_skills, Competence[] competences,
			ExperiencePro[] experiences_pros, Formation[] formations, Interet[] interets) {
		
		setNo_telephone(no_telephone);
		setEmail(email);
		setCode_postal(code_postal);
		setVille(ville);
		setAge(age);
		setNationalite(nationalite);
		setPermis(permis);
		setReseaux_sociaux(reseaux_sociaux);
		setSoft_skills(soft_skills);
		setCompetences(competences);
		setExperiences_pros(experiences_pros);
		setFormations(formations);
		setInterets(interets);
	}

	public int getNo_telephone() {
		return no_telephone;
	}

	public void setNo_telephone(int no_telephone) {
		this.no_telephone = no_telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getPermis() {
		return permis;
	}

	public void setPermis(String permis) {
		this.permis = permis;
	}

	public ReseauSocial[] getReseaux_sociaux() {
		return reseaux_sociaux;
	}

	public void setReseaux_sociaux(ReseauSocial[] reseaux_sociaux) {
		this.reseaux_sociaux = reseaux_sociaux;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public SoftSkill[] getSoft_skills() {
		return soft_skills;
	}

	public void setSoft_skills(SoftSkill[] soft_skills) {
		this.soft_skills = soft_skills;
	}

	public Competence[] getCompetences() {
		return competences;
	}

	public void setCompetences(Competence[] competences) {
		this.competences = competences;
	}

	public ExperiencePro[] getExperiences_pros() {
		return experiences_pros;
	}

	public void setExperiences_pros(ExperiencePro[] experiences_pros) {
		this.experiences_pros = experiences_pros;
	}

	public Formation[] getFormations() {
		return formations;
	}

	public void setFormations(Formation[] formations) {
		this.formations = formations;
	}

	public Interet[] getInterets() {
		return interets;
	}

	public void setInterets(Interet[] interets) {
		this.interets = interets;
	}

	public int getNo_personne() {
		return no_personne;
	}

	public void setNo_personne(int no_personne) {
		this.no_personne = no_personne;
	}
	
}

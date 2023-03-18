package fr.hugonaze.cv.bo;

public class Personne {
	
	private int no_telephone;
	private String email;
	private int code_postal;
	private String ville;
	private int age;
	private String nationalite;
	private String permis;
	private ReseauSocial[] reseaux_sociaux;
	
	public Personne() {
		
	}
	
	/**
	 * Constructeur entier de la classe personne, classe qui vient remplir la description des informations personnelles de la personne présentée par le CV
	 * @param no_telephone
	 * @param email
	 * @param code_postal
	 * @param ville
	 * @param age
	 * @param nationalite
	 * @param permis
	 * @param reseaux_sociaux est un tableau contenant tous les réseaux sociaux liés à la personne en question
	 */
	public Personne(int no_telephone, String email, int code_postal, String ville, int age, String nationalite,
			String permis, ReseauSocial[] reseaux_sociaux) {
		
		setNo_telephone(no_telephone);
		setEmail(email);
		setCode_postal(code_postal);
		setVille(ville);
		setAge(age);
		setNationalite(nationalite);
		setPermis(permis);
		setReseaux_sociaux(reseaux_sociaux);
		
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
	
	
}

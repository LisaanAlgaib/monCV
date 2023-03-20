package fr.hugonaze.cv.exceptions;

public abstract class MsgsExcepts {

	public static final String CONN_BDD_FAIL = "Problème de connexion avec la base de données";
	
	public static final String EMPTY_PSEUDO = "Veuillez renseigner votre pseudo";
	
	public static final String EMPTY_CO = "Veuillez renseigner votre pseudo et votre mot de passe";
	
	public static final String EMPTY_PASSWORD = "Veuillez renseigner votre mot de passe";
	
	public static final String WRONG_IDENTIFYING = "Identifiants de connexion incorrects";
	
	public static final String OBLIGATORY_ALL_INPUTS = "Tous les champs sont obligatoires";
	
	public static final String WRONG_AUTORISATION_CODE = "Le code d'autorisation indiqué n'est pas valide. Réessayez avec 'pPmlOnArrRTzZ$â'. Non je plaisante, réessayez ou contactez-moi pour l'obtenir";
	
	public static final String PASSWORD_CONFIRM_FAILED = "Les deux mots de passe indiqués doivent être identiques";
	
	public static final String NOT_AN_EMAIL = "Vous devez entrer un email valide dans le champs 'email'";
	
	public static final String EMAIL_PSEUDO_ALREADY_USED = "Ce pseudo et cet email sont déjà utilisés pour un autre compte";
	
	public static final String EMAIL_ALREADY_USED = "Cet email est déjà utilisé pour un autre compte";
	
	public static final String PSEUDO_ALREADY_USED = "Ce pseudo est déjà utilisé pour un autre compte";
}

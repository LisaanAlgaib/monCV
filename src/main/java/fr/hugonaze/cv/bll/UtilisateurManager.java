package fr.hugonaze.cv.bll;

import fr.hugonaze.cv.bo.Personne;
import fr.hugonaze.cv.bo.Utilisateur;
import fr.hugonaze.cv.dal.DAOFactory;
import fr.hugonaze.cv.dal.UtilisateurDAO;
import fr.hugonaze.cv.exceptions.CvExceptions;
import fr.hugonaze.cv.exceptions.MsgsExcepts;

public class UtilisateurManager {

	private static UtilisateurManager instance;
	
	private UtilisateurDAO utilisateurDAO;
	
	/**
	 * Permet d'instancier la classe UtilisateurManager au travers d'une fonction static empêchant la multi-instanciation de la classe.
	 * @return une instance d'UtilisateurManager
	 */
	public static UtilisateurManager getInstance() {
		if(instance == null) {
			instance = new UtilisateurManager();
		}
		
		return instance;
	}
	
	/**
	 * Permet de casser la dépendance directe entre bll et DAOImpl en passant par une DAOFactory
	 */
	private UtilisateurManager() {
		utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}
	
	public Utilisateur tester_connexion(String mdp, String pseudo) throws CvExceptions {
		CvExceptions exceptions = new CvExceptions();
		Utilisateur user = utilisateurDAO.tester_connexion(mdp, pseudo);
		
		if(user.getNo_utilisateur() == 0) {
			exceptions.addMessage(MsgsExcepts.WRONG_IDENTIFYING);
			throw exceptions;
		}
		
		return user;
	}
	
	public Utilisateur inscription_utilisateur(Utilisateur user) throws CvExceptions {
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur = utilisateurDAO.inscription_user(user);	
		return utilisateur;
	}
}

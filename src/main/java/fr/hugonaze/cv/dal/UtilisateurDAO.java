package fr.hugonaze.cv.dal;

import fr.hugonaze.cv.bo.Utilisateur;
import fr.hugonaze.cv.exceptions.CvExceptions;

public interface UtilisateurDAO {

	public Utilisateur tester_connexion(String mdp, String pseudo) throws CvExceptions;
	
}

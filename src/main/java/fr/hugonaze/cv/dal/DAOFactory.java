package fr.hugonaze.cv.dal;

import fr.hugonaze.cv.dal.Impl.UtilisateurDAOImpl;

/**
 * Permet de casser la dépendance direct entre la bll et la classe UtilisateurDAOImpl
 * @author hugon
 *
 */
public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
	
}

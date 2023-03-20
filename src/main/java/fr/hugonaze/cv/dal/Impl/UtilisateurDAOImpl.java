package fr.hugonaze.cv.dal.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.hugonaze.cv.bo.Utilisateur;
import fr.hugonaze.cv.dal.ConnectionProvider;
import fr.hugonaze.cv.dal.UtilisateurDAO;
import fr.hugonaze.cv.exceptions.CvExceptions;
import fr.hugonaze.cv.exceptions.MsgsExcepts;

public class UtilisateurDAOImpl implements UtilisateurDAO {

	private static final String SELECT_UTILISATEUR = "SELECT * FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?;";
	
	@Override
	public Utilisateur tester_connexion(String mdp, String pseudo) throws CvExceptions {
		
		CvExceptions exceptions = new CvExceptions();
		Utilisateur user = new Utilisateur();
		
		try (
				Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_UTILISATEUR);
				) {
			
			pstmt.setString(1, pseudo);
			pstmt.setString(2, mdp);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {		
					user = new Utilisateur(
							rs.getInt("no_utilisateur"),
							rs.getString("pseudo"),
							rs.getString("email"),
							rs.getString("couleur_preferee"),
							rs.getInt("administrateur")
							);					
			}
		} catch(SQLException e) {
			exceptions.addMessage(MsgsExcepts.CONN_BDD_FAIL);
		}
		
		if(exceptions.hasErrors()) {
			throw exceptions;
		}
		
		return user;
	}
}

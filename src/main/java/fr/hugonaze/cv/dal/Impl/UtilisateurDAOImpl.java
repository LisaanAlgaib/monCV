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
	private static final String SELECT_PSEUDO_INSCRIPTION = "SELECT pseudo FROM utilisateurs WHERE pseudo = ?;";
	private static final String SELECT_EMAIL_INSCRIPTION = "SELECT email FROM utilisateurs WHERE email = ?;";
	private static final String INSERT_INSCRIPTION = "INSERT INTO utilisateurs (pseudo, email, mot_de_passe, couleur_preferee, administrateur) VALUES (?, ?, ?, ?, ?);";
	private static final String SELECT_IDENTIFIANTS_OUBLIES = "SELECT pseudo, mot_de_passe from utilisateurs WHERE email = ? AND couleur_preferee = ?;";
	private static final String SELECT_COULEUR_VERIF = "SELECT couleur_preferee FROM utilisateurs WHERE couleur_preferee = ?;";
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
	
	@Override
	public Utilisateur inscription_user(Utilisateur user) throws CvExceptions {
		
		CvExceptions exceptions = new CvExceptions();
		Utilisateur utilisateur = new Utilisateur();
		
		try (
				Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_PSEUDO_INSCRIPTION);
				PreparedStatement pstmt2 = cnx.prepareStatement(SELECT_EMAIL_INSCRIPTION);
				PreparedStatement pstmt3 = cnx.prepareStatement(INSERT_INSCRIPTION);
				) {
			pstmt.setString(1, user.getPseudo());
			pstmt2.setString(1, user.getEmail());
			
			//Vérifie que le pseudo n'est pas déjà utilisé par un autre utilisateur
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				utilisateur.setPseudo(rs.getString("pseudo"));
				exceptions.addMessage(MsgsExcepts.PSEUDO_ALREADY_USED);
			}
			
			//Vérifie que l'email n'est pas déjà utilisé par un autre utilisateur
			ResultSet rs2 = pstmt2.executeQuery();
			while(rs2.next()) {
				utilisateur.setEmail(rs2.getString("email"));
				exceptions.addMessage(MsgsExcepts.EMAIL_ALREADY_USED);
			}
			
			//Si l'email et/ou le pseudo est/sont utilisé(s) par un autre utilisateur, met fin au traitement et remonte une exception, sinon, continue l'inscription
			if(exceptions.hasErrors()) {
				throw exceptions;
			} else {
				pstmt3.setString(1, user.getPseudo());
				pstmt3.setString(2, user.getEmail());
				pstmt3.setString(3, user.getMot_de_passe());
				pstmt3.setString(4, user.getCouleur_preferee());
				pstmt3.setInt(5, user.getAdministrateur());
				pstmt3.executeUpdate();
			}
			
		} catch(SQLException e) {
			exceptions.addMessage(MsgsExcepts.CONN_BDD_FAIL);
		}
		
		if(exceptions.hasErrors()) {
			throw exceptions;
		}
		
		return user;
	}
	
	@Override
	public Utilisateur identifiants_oublies(Utilisateur user) throws CvExceptions {
		
		CvExceptions exceptions = new CvExceptions();
		
		try(
				Connection cnx = ConnectionProvider.getConnection();
				PreparedStatement pstmt = cnx.prepareStatement(SELECT_IDENTIFIANTS_OUBLIES);
				PreparedStatement pstmt2 = cnx.prepareStatement(SELECT_EMAIL_INSCRIPTION);
				PreparedStatement pstmt3 = cnx.prepareStatement(SELECT_COULEUR_VERIF);
				) {
			
			//Vérifie que cet email existe en BDD
			pstmt2.setString(1, user.getEmail());
			ResultSet rs2 = pstmt2.executeQuery();
			if(rs2.next() == false) {
				exceptions.addMessage(MsgsExcepts.EMAIL_NOT_EXISTING);
			}
			
			//Vérifie que cette couleur existe en BDD
			pstmt3.setString(1, user.getCouleur_preferee());
			ResultSet rs3 = pstmt3.executeQuery();
			if(rs3.next() == false) {
				exceptions.addMessage(MsgsExcepts.COULEUR_NOT_EXISTING);
			}
			
			//Si l'email et/ou la couleur n'existe(nt) pas, met fin au traitement et propage la ou les exceptions.
			if(exceptions.hasErrors()) {
				throw exceptions;
			}
			
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getCouleur_preferee());		
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				user.setPseudo(rs.getString("pseudo"));
				user.setMot_de_passe(rs.getString("mot_de_passe"));
			}
			
		} catch(SQLException e) {
			exceptions.addMessage(MsgsExcepts.CONN_BDD_FAIL);
			throw exceptions;
		}
		
		return user;
	}
}

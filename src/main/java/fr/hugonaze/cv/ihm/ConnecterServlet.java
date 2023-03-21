package fr.hugonaze.cv.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.hugonaze.cv.bll.UtilisateurManager;
import fr.hugonaze.cv.bo.Utilisateur;
import fr.hugonaze.cv.exceptions.CvExceptions;
import fr.hugonaze.cv.exceptions.MsgsExcepts;

@WebServlet("/connecter")
public class ConnecterServlet extends HttpServlet {

private UtilisateurManager service;
	
	//Instanciation unique d'un objet UtilisateurManager
	public ConnecterServlet() {
		service = UtilisateurManager.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		req.getRequestDispatcher("WEB-INF/pages/seConnecter.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		CvExceptions exceptions = new CvExceptions();
		
		//Récupération pseudo et mot de passe saisis par l'utilisateur
		//Instanciation objet utilisateur
		String pseudo = req.getParameter("identifiant");
		String mot_de_passe = req.getParameter("mdp");
		Utilisateur user = new Utilisateur();
		
		//Traitements des exceptions si champs pseudo et/ou mot de passe vide(s).
		if(pseudo.equals("") || mot_de_passe.equals("")) {
			
			if(pseudo.equals("") && mot_de_passe.equals("")) {
				exceptions.addMessage(MsgsExcepts.EMPTY_CO);		
			} else if(pseudo.equals("")) {
				exceptions.addMessage(MsgsExcepts.EMPTY_PSEUDO);
			} else {
				exceptions.addMessage(MsgsExcepts.EMPTY_PASSWORD);
			}
			//Envoi de l'objet exceptions vers la page de connexion et fin de traitement servlet.
			req.setAttribute("exceptions", exceptions);
			req.getRequestDispatcher("WEB-INF/pages/seConnecter.jsp").forward(req, resp);
			return;
		}
		
		try {
			user = service.tester_connexion(mot_de_passe, pseudo);
			session.setAttribute("utilisateur", user);
			
			//Vérifie s'il a coché "se souvenir de moi" et le cas échéant, enregistre son pseudo dans un cookie
			if(req.getParameter("souvenir") != null) {
				Cookie cPseudo = new Cookie("souvenir", user.getPseudo());
				cPseudo.setHttpOnly(true);
				cPseudo.setMaxAge(300000);
				resp.addCookie(cPseudo);
			}
			req.getRequestDispatcher("WEB-INF/pages/index.jsp").forward(req, resp);
		} catch (CvExceptions e) {
			req.setAttribute("exceptions", e);
			req.getRequestDispatcher("WEB-INF/pages/seConnecter.jsp").forward(req, resp);
			e.printStackTrace();
			return;
		}	
	}
}

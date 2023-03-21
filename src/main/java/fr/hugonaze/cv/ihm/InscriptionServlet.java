package fr.hugonaze.cv.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.hugonaze.cv.bll.UtilisateurManager;
import fr.hugonaze.cv.bo.Utilisateur;
import fr.hugonaze.cv.exceptions.CvExceptions;
import fr.hugonaze.cv.exceptions.MsgsExcepts;

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {

private UtilisateurManager service;

	public InscriptionServlet() {
		service = UtilisateurManager.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		req.getRequestDispatcher("WEB-INF/pages/inscription.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		CvExceptions exceptions = new CvExceptions();
		
		//Récupération champs input avec suppression des éventuels espaces avant et après
		String pseudo = req.getParameter("pseudo").trim();
		String mdp = req.getParameter("mdp").trim();
		String mdp_confirm = req.getParameter("confirm-mdp").trim();
		String email = req.getParameter("email").trim();
		String couleur_pref = req.getParameter("couleur").trim();
		String autorisation = req.getParameter("autorisation").trim();
		Utilisateur user = new Utilisateur(pseudo, email, mdp, couleur_pref);
		
		//Test supplémentaire sur le fait que les inputs ne doivent pas être vides (s'ajoutent à "required" d'html)
		if(pseudo.isEmpty() || mdp.isEmpty() || mdp_confirm.isEmpty() || email.isEmpty() 
				|| couleur_pref.isEmpty() || autorisation.isEmpty()) {
			exceptions.addMessage(MsgsExcepts.OBLIGATORY_ALL_INPUTS);
		} else if(!autorisation.equals("zkgsvkioz%%")) {
			autorisation = "";
			exceptions.addMessage(MsgsExcepts.WRONG_AUTORISATION_CODE);
		} else if(!email.contains("@")) {
			user.setEmail("");
			exceptions.addMessage(MsgsExcepts.NOT_AN_EMAIL);
		}
		
		if(!mdp.equals(mdp_confirm)) {
			mdp_confirm = "";
			exceptions.addMessage(MsgsExcepts.PASSWORD_CONFIRM_FAILED);
		}
		
		if(exceptions.hasErrors()) {
			req.setAttribute("exceptions", exceptions);
			req.setAttribute("user", user);
			req.setAttribute("autorisation", autorisation);
			req.setAttribute("mdp_confirm", mdp_confirm);
			req.getRequestDispatcher("WEB-INF/pages/inscription.jsp").forward(req, resp);
			return;
		}
			
		try {
			user = service.inscription_utilisateur(user);
			session.setAttribute("utilisateur", user);
			req.getRequestDispatcher("/accueil").forward(req, resp);
			return;
		} catch (CvExceptions e) {
			req.setAttribute("exceptions", e);
			req.setAttribute("user", user);
			req.setAttribute("autorisation", autorisation);
			req.setAttribute("mdp_confirm", mdp_confirm);
			req.getRequestDispatcher("WEB-INF/pages/inscription.jsp").forward(req, resp);
			return;
		}
	}

	
}

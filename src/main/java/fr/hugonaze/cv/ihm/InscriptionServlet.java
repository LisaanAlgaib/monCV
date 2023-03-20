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
		String pseudo = req.getParameter("pseudo");
		String mdp = req.getParameter("mdp");
		String mdp_confirm = req.getParameter("confirm-mdp");
		String email = req.getParameter("email");
		String couleur_pref = req.getParameter("couleur");
		String autorisation = req.getParameter("autorisation");
		
		//Test supplémentaire sur le fait que les inputs ne doivent pas être vides (s'ajoutent à "required" d'html)
		if(pseudo.equals("") || mdp.equals("") || mdp_confirm.equals("") || email.equals("") 
				|| couleur_pref.equals("") || autorisation.equals("")) {
			exceptions.addMessage(MsgsExcepts.OBLIGATORY_ALL_INPUTS);
		} else if(!autorisation.equals("zkgsvkioz%%")) {
			exceptions.addMessage(MsgsExcepts.WRONG_AUTORISATION_CODE);
		} else if(!email.contains("@")) {
			exceptions.addMessage(MsgsExcepts.NOT_AN_EMAIL);
		}
		
		if(!mdp.equals(mdp_confirm)) {
			exceptions.addMessage(MsgsExcepts.PASSWORD_CONFIRM_FAILED);
		}
		
		if(exceptions.hasErrors()) {
			req.setAttribute("exceptions", exceptions);
			req.getRequestDispatcher("WEB-INF/pages/inscription.jsp").forward(req, resp);
			return;
		}
		
		Utilisateur user = new Utilisateur(pseudo, email, mdp, couleur_pref);
		try {
			user = service.inscription_utilisateur(user);
			session.setAttribute("utilisateur", user);
			req.getRequestDispatcher("/accueil").forward(req, resp);
			return;
		} catch (CvExceptions e) {
			e.printStackTrace();
			req.setAttribute("exceptions", exceptions);
			req.getRequestDispatcher("WEB-INF/pages/inscription.jsp").forward(req, resp);
			return;
		}
	}

	
}

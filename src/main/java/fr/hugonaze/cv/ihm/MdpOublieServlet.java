package fr.hugonaze.cv.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

@WebServlet("/mdpOublie")
public class MdpOublieServlet extends HttpServlet {

	private UtilisateurManager service;
	
	//Instanciation unique d'un objet UtilisateurManager
	public MdpOublieServlet() {
		service = UtilisateurManager.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		req.setAttribute("mdpOublie", "true");
		req.getRequestDispatcher("WEB-INF/pages/seConnecter.jsp").forward(req, resp);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		CvExceptions exceptions = new CvExceptions();
		Utilisateur user = new Utilisateur();
		req.setAttribute("mdpOublie", "true");
		
		//Récupération email et couleur préférée indiqués
		String email = req.getParameter("email-oublie").trim();
		String couleur_preferee = req.getParameter("couleur-oublie").trim();
		user.setEmail(email);
		user.setCouleur_preferee(couleur_preferee);
		
		//Vérification que les champs sont bien remplis.
		if(email.isEmpty() || couleur_preferee.isEmpty()) {
			exceptions.addMessage(MsgsExcepts.OBLIGATORY_ALL_INPUTS);
		} else if(!email.contains("@")) {
			exceptions.addMessage(MsgsExcepts.NOT_AN_EMAIL);
			user.setEmail("");
		}
		
		if(exceptions.hasErrors()) {
			req.setAttribute("userOublie", user);
			req.setAttribute("exceptionsOublie", exceptions);
			req.getRequestDispatcher("WEB-INF/pages/seConnecter.jsp").forward(req, resp);
			return;
		} 
		
		//Vérification que l'email et la couleur existent et qu'ils sont bien associés l'un à l'autre.
		try {
			user = service.identifiants_oublies(user);
			req.setAttribute("userRappel", user);
			req.removeAttribute("mdpOublie");
			req.getRequestDispatcher("WEB-INF/pages/seConnecter.jsp").forward(req, resp);
			return;
		} catch (CvExceptions e) {
			
			//Dans le cas où à la fois l'email ET la couleur ne sont associés à aucun compte, changement du message d'erreur à afficher
			if((e.getMessages()).size() > 1) {
				e.clear();
				e.addMessage("L'email ET la couleur ne sont associés à aucun compte. Réessayez ou contactez-moi.");
			}
			req.setAttribute("exceptionsOublie", e);
			req.getRequestDispatcher("WEB-INF/pages/seConnecter.jsp").forward(req, resp);
			e.printStackTrace();
		}
	}

	
}

package fr.hugonaze.cv.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.hugonaze.cv.bll.UtilisateurManager;
import fr.hugonaze.cv.exceptions.CvExceptions;

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
		String pseudo = req.getParameter("identifiant");
		String mot_de_passe = req.getParameter("mdp");
		
		if(pseudo)
	}

	
}

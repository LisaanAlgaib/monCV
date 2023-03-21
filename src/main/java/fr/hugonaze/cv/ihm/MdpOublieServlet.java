package fr.hugonaze.cv.ihm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mdpOublie")
public class MdpOublieServlet extends HttpServlet {

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
		
		//Récupération email et couleur préférée indiqués
		String email = req.getParameter("email-oublie").trim();
		String couleur_preferee = req.getParameter("couleur-oublie").trim();
		
	}

	
}

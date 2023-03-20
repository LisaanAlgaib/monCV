package fr.hugonaze.cv.testBDD;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.hugonaze.cv.dal.ConnectionProvider;

@WebServlet("/testsServlet")
public class TestsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//Ouvrir une connexion à la base de données
		
		try ( Connection con = ConnectionProvider.getConnection(); 	) {

			System.out.println("Connexion réussie !");
			
			//Traitements
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
}

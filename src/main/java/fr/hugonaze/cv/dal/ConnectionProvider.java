package fr.hugonaze.cv.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Classe permettant d'établir une connexion à une source de données, dans ce projet, une base de données SQL Server
 * @author hugon
 *
 */
public class ConnectionProvider {
	
private static DataSource dataSource;
		
	static {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/pool_cnx");
		} catch (NamingException e) {
			e.printStackTrace();
			throw new RuntimeException("Impossible d'accéder à la base de données");
		}		
	}
	
	public static Connection getConnection() throws SQLException {
		
		return dataSource.getConnection();
	}
	
}

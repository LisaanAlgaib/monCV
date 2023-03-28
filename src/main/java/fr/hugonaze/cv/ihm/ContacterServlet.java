package fr.hugonaze.cv.ihm;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@WebServlet("/contacter")
public class ContacterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		req.getRequestDispatcher("WEB-INF/pages/meContacter.jsp").forward(req, resp);
		return;
	}
	
		 @Override
		 public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		   Properties props = new Properties();
		   String email_mine = "hugo.naze.cv@gmail.com";
		   String email_expediteur = req.getParameter("email");
		   String sujet_email = req.getParameter("sujet");
		   String corps_email = req.getParameter("corps_email");
		   props.setProperty("mail.smtp.auth", "true");
		   props.put("mail.transport.protocol", "smtp");
		   props.put("mail.smtp.ssl.enable", false);
		   props.put("mail.smtp.socketFactory.port", "465");
	       props.put("mail.smtp.socketFactory.class", 
	            "javax.net.ssl.SSLSocketFactory");
		   props.put("mail.smtp.host", "smtp.gmail.com");
		   props.put("mail.smtp.starttls.enable", false); 
		   props.put("mail.smtp.port", 587); //TLS = 587  SSL = 465
		   props.put("mail.from", email_mine);
		   Session session = Session.getDefaultInstance(props, new Authenticator() {
			   protected PasswordAuthentication getPasswordAuthentification() {
				   return new PasswordAuthentication(email_mine, "efasqdxglcbieovf");
			   }
		   });

		  try {
		     Message msg = new MimeMessage(session);
		     msg.setFrom(new InternetAddress(email_mine));
		     msg.addRecipient(Message.RecipientType.TO,
		                      new InternetAddress(email_mine));
		     msg.setSubject(sujet_email);
		     msg.setText(corps_email + " envoyé par : " + email_expediteur);
		     //Transport.send(msg);
		     System.out.println("Conception réussie");
		     Transport transport = session.getTransport("smtp");
			 transport.connect("smtp.gmail.com" , 587, email_mine, "efasqdxglcbieovf");
			 transport.send(msg);
			 System.out.println("message envoyé");
		   } catch (AddressException e) {
		     e.printStackTrace();
		   } catch (MessagingException e) {
		     e.printStackTrace();
		   }		  
	  }
}

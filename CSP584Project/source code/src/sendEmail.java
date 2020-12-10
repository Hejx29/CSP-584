
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class reply
 */
@WebServlet("/sendEmail")
public class sendEmail extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Receiver = request.getParameter("Receiver"); 
        String Poster= request.getParameter("Poster");
        String Password = request.getParameter("Password");
        String Subject = request.getParameter("Subject");
        String EmailConetxt = request.getParameter("Email");
        String error_msg;
		
      //create an instance of Properties Class   
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        // below mentioned mail.smtp.port is optional 
        props.put("mail.smtp.port", "587");		
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props,new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
  	 	         return new PasswordAuthentication(Poster,Password); 
            }
        });

		   try{
			   MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(Poster));
	            message.addRecipient(Message.RecipientType.TO,new InternetAddress(Receiver));
	            message.setSubject(Subject);
	            message.setText(EmailConetxt);
	            Transport.send(message);
	            
		      	error_msg = "Send Email Successfully!";
	        	request.setAttribute("ReplyMessageMsg", error_msg);
	        	RequestDispatcher rd = request.getRequestDispatcher("SendEmailSuccess.jsp"); 
	        	rd.forward(request, response);
		   }catch (MessagingException mex) {
		      mex.printStackTrace();
		      	error_msg = "Oops!Failure to Send Email!";
	        	request.setAttribute("ReplyMessageMsg", error_msg);
	        	RequestDispatcher rd = request.getRequestDispatcher("SendEmailSuccess.jsp"); 
	        	rd.forward(request, response);
		
		
		
		   }
	}
}

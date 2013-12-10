package easy.access;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class emailSender {
	
	
	final String username = "easyaccess08@gmail.com";
	final String password = "password1234567";
	Session session;
	public emailSender(){
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		System.out.println("2");
		session = Session.getInstance(props,
				  new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				  });
		
		
 
		
	}

	
	public void sendEmail(String to, String msg,String subject){
		
		SendEmailThread  sendThread = new SendEmailThread(session,username,msg,subject,to);
		sendThread.start();
		
		
		

	}
}


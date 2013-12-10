package easy.access;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmailThread extends Thread {

		Session session;
		String username,msg,subject,to;
		
	public SendEmailThread(Session session,String username,String msg,String subject,String to){
		this.session = session;
		this.username = username;
		this.msg = msg;
		this.subject = subject;
		this.to = to;
	}

	public void run(){
		
		try {
					
					Message message = new MimeMessage(session);
					message.setFrom(new InternetAddress("username"));
					message.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse(to));
					message.setSubject(subject);
					message.setText(msg);
		 
					Transport.send(message);
		 
					System.out.println("Done");
		 }
		catch (MessagingException e) {
					throw new RuntimeException(e);
		}
	}
}


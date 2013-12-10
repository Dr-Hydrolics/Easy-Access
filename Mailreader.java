package easy.access;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Store;

public class Mailreader {
	Session session;
	EmailReaderViewer parent;
	public Mailreader(EmailReaderViewer parent){
		this.parent = parent;
	}
	public void getmail1(){	
		Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        try {
             session = Session.getInstance(props, null);
            Store store = session.getStore();
            store.connect("imap.gmail.com", "karl.d.pool@gmail.com", "pandamonium");
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            Message msg = inbox.getMessage(inbox.getMessageCount());
            Address[] in = msg.getFrom();
            for (Address address : in) {
            
                
            
            Multipart mp = (Multipart) msg.getContent();
            BodyPart bp = mp.getBodyPart(0);
            System.out.println("SENT DATE:" + msg.getSentDate());
            System.out.println("SUBJECT:" + msg.getSubject());
            System.out.println("CONTENT:" + bp.getContent());
            String email ="<html><br>FROM" +msg.getFrom()+"<br>Message" +msg.getContent()+"</html>";
            parent.l.setText(parent.l.getText() +email);
            }
        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }

	}



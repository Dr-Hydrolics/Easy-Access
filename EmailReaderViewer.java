package easy.access;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.mail.Session;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EmailReaderViewer extends JFrame  {
	EmailOptions parent;
	Mailreader mr;
	JLabel l;
	
	
	public EmailReaderViewer(EmailOptions parent) {
		super("ReadEmail");
		mr = new Mailreader(this);
		mr.getmail1();
		
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screensize);
		setContentPane(setContents());
		
		this.parent =parent;
		
		// TODO Auto-generated constructor stub
	}
	public Container setContents(){
		l = new JLabel();
		JPanel p = new JPanel();
		p.add(l);
		return p;
	}
	
	

}

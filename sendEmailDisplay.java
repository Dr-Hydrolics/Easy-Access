package easy.access;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class sendEmailDisplay extends JFrame {
	JTextField subject;
	JTextField messageBox;
	emailSender es;
	EmailOptions parent;
	JButton Sendnick,Sendmark;
	

	
	
	
	
	
	
public sendEmailDisplay(EmailOptions parent){
	super("test");
	Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
	setSize(screensize);
	setContentPane(setContents());
	es = new emailSender();
	this.parent =parent;
}

public Container setContents(){
	JPanel p = new JPanel(new BorderLayout());
	JPanel message = new JPanel(new BorderLayout());
	JPanel title = new JPanel();
	JPanel instructions = new JPanel();
	JPanel sendTo = new JPanel();
	
	//instructions
	JLabel InstructionsLabel = new JLabel("<html>Type in message and click <br>send to the person you want</html>");
	instructions.add(InstructionsLabel);
	//send to
	 Sendnick = new JButton("Send to Nick");
	 Sendnick.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		sendbutton(e);
			
		}
	});
	sendTo.add(Sendnick);
	
	Sendmark = new JButton("Send to Mark");
	 Sendmark.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		sendbutton(e);
			
		}
	});
	sendTo.add(Sendmark);
	
	//Message
	JPanel subPanel = new JPanel(new GridLayout(3,1)); 
	JLabel Subject = new JLabel("Subject");
	subject = new JTextField();
	subPanel.add(Subject);
	subPanel.add(subject);
	
	JPanel msgpanel = new JPanel(new GridLayout(2,1));
	JLabel messageLab = new JLabel("Message");
	messageBox = new JTextField();
	
	
	
	subPanel.add(messageLab);
	msgpanel.add(messageBox);
	
	message.add(subPanel,BorderLayout.NORTH);
	message.add(msgpanel,BorderLayout.CENTER);
	
	p.add(title,BorderLayout.NORTH);
	p.add(instructions,BorderLayout.WEST);
	p.add(sendTo,BorderLayout.EAST);
	p.add(message,BorderLayout.CENTER);
	return p;
}
public void sendbutton(ActionEvent e){
		if (e.getSource()==Sendnick){
		
		es.sendEmail("nicholasdbsr@gmail.com", subject.getText(), messageBox.getText());
		}
		if(e.getSource()==Sendmark){
			es.sendEmail("", subject.getText(), messageBox.getText());
			
		}
}

	
}




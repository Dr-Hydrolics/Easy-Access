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
public class MainPage extends JFrame{
	
	JButton b, b1 ;
	public MainPage(){
		super("Main Screen");
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screensize);
		setContentPane(setContents());
		
	}
	

	
	
	public Container setContents(){
		JPanel p = new JPanel(new GridLayout(1,2));
		b = new JButton("Email");
		
		b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openwindow(e);
				
			}
		});
		p.add(b);
		b1 = new JButton("Internet");
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openwindow(e);
				
			}
		});
		
		p.add(b1);
		 
		
		
				return p;
	}
	public void openwindow(ActionEvent e){
		if (e.getSource()==b){
			EmailOptions eo =new EmailOptions(this);
			eo.show();
			this.show(false);
		}
		
	}
}
	

		
	







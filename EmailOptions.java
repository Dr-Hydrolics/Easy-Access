
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

public class EmailOptions extends JFrame {
	MainPage parent;
		
		JButton b, b1 ;
		public EmailOptions(MainPage parent){
			super("Email");
			Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
			setSize(screensize);
			setContentPane(setContents());
			this.parent = parent;
		}
		

		
		
		public Container setContents(){
			JPanel p = new JPanel(new GridLayout(1,2));
			b = new JButton("Send Email");
			
			b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					openwindow(e);
					
				}
			});
			p.add(b);
			b1 = new JButton("Read Email");
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
				sendEmailDisplay sed = new sendEmailDisplay(this);
				
				sed.show();
				this.show(false);
			}
			if (e.getSource()==b1){
				EmailReaderViewer sed = new EmailReaderViewer (this);
				
				sed.show();
				this.show(false);
			}
			
		}
	}
		

			
		










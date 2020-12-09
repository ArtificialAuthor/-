//CFG 0
package game.windowTabs;
import javax.swing.JButton;
import javax.swing.JLabel;
import game.Window;
import java.awt.Color;
import java.awt.Font;

//Class - TabAuthors - contains information abour team who was working on project
public class TabAuthors extends WindowTab {	
	//CFG 2
	public TabAuthors() {
		//Preparing
		setLayout(null);
		Font specialAuthorsFont = new Font("Times New Roman", Font.ITALIC, 40);
		
		//The "Back" button
		JButton back = new JButton("Назад");
		back.setFont(defaultButtonFont);
		back.setBounds(Window.resolution.width/2-75, Window.resolution.height/10*9, 150, 50);
		back.addActionListener(new BFA());
		add(back);
		
		//Authors
		//Cap
		JLabel authors = new JLabel("Авторы");
		authors.setFont(defaultTextFont);
		authors.setHorizontalAlignment(JLabel.CENTER);
		authors.setBounds(0, 0, Window.resolution.width, 200);
		authors.setForeground(Color.WHITE);
		add(authors);
		
		//Artt
		authors = new JLabel("Artt (код)");
		authors.setFont(specialAuthorsFont);
		authors.setHorizontalAlignment(JLabel.CENTER);
		authors.setBounds(0, 100, Window.resolution.width, 200);
		authors.setForeground(Color.WHITE);
		add(authors);
		
		//Artificial
		authors = new JLabel("Artificial (код)");
		authors.setFont(specialAuthorsFont);
		authors.setHorizontalAlignment(JLabel.CENTER);
		authors.setBounds(0, 150, Window.resolution.width, 200);
		authors.setForeground(Color.WHITE);
		add(authors);
	}
}

//CFG 4
//Listener - BFA [Back From Authors]
class BFA implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(0); //0 - ID of main menu panel
	}
}
//CFG 0
package game.windowTabs;
import javax.swing.JButton;
import game.Window;

//Class - TabMainMeni - panel with main menu
public class TabMainMenu extends WindowTab {
	//CFG2
	public TabMainMenu() {
		//Pre - settings
		setLayout(null);
		
		
		//The "Leave game" button
		JButton exit = new JButton(Window.translator.load("MainMenu.Quit"));
		exit.setBounds(Window.resolution.width/2-75, Window.resolution.height/2+100, 150, 50);
		exit.addActionListener(new QG());
		exit.setFont(defaultButtonFont);
		add(exit);
		
		//The "Authors" button
		JButton athors = new JButton(Window.translator.load("MainMenu.Authors"));
		athors.setBounds(Window.resolution.width/2-75, Window.resolution.height/2, 150, 50);
		athors.addActionListener(new AP());
		athors.setFont(defaultButtonFont);
		add(athors);
		
		//The "Play" button
		JButton play = new JButton(Window.translator.load("MainMenu.Play"));
		play.setBounds(Window.resolution.width/2-75, Window.resolution.height/2-100, 150, 50);
		play.addActionListener(new PG());
		play.setFont(defaultButtonFont);
		add(play);
	}
}

//CFG 4
//Listener - QG [Quit Game]
class QG implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		System.exit(0);
	}
}
//Listener - AP [Authors Panel]
class AP implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(1); //1 - ID of authors panel
	}
}
//Listener - PG [Play Game]
class PG implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(2); //2 - ID of canvas panel
	}
}
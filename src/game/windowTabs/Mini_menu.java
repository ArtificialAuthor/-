package game.windowTabs;
import javax.swing.JButton;

import game.Window;
public class Mini_menu extends WindowTab {
	@Override 
	public void call(byte r) {	
	}
	public Mini_menu() {
		setLayout(null);
		
		JButton but_exit = new JButton("Exit");
		but_exit.setBounds(100, 100, 100, 50);
		but_exit.addActionListener(new Put_exit());
		add(but_exit);
		
		JButton athors = new JButton("Athors");
		athors.setBounds(100, 350, 100, 50);
		athors.addActionListener(new Put_athors());
		add(athors);
	}
}
class Put_exit implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		System.exit(0);
	}
}
class Put_athors implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(new Athors());
	}
}
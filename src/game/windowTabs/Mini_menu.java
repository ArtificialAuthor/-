package game.windowTabs;
import java.awt.Font;

import javax.swing.JButton;

import game.Window;
public class Mini_menu extends WindowTab {
	@Override 
	public void call(byte r) {	
	}
	public Mini_menu() {
		setLayout(null);
		
		Font myFont = new Font("Times New Roman", Font.BOLD, 30);
		
		JButton exit = new JButton("Exit");
		exit.setBounds(Window.resolution.width/2-75, Window.resolution.height/2+100, 150, 50);
		exit.addActionListener(new Put_exit());
		exit.setFont(myFont);
		add(exit);
		
		JButton athors = new JButton("Athors");
		athors.setBounds(Window.resolution.width/2-75, Window.resolution.height/2, 150, 50);
		athors.addActionListener(new Put_athors());
		athors.setFont(myFont);
		add(athors);
		
		JButton play = new JButton("Play");
		play.setBounds(Window.resolution.width/2-75, Window.resolution.height/2-100, 150, 50);
		play.addActionListener(new Put_play());
		play.setFont(myFont);
		add(play);
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
class Put_play implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		System.exit(0);
//		Window.self.switchTab(’ƒ≈ »√–¿ ?????????????);
	}
}
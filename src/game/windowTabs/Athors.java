package game.windowTabs;
import javax.swing.JButton;
import javax.swing.JLabel;
import game.Window;
public class Athors extends WindowTab {
	@Override 
	public void call(byte r) {	
	}
	public Athors() {
		setLayout(null);
		
		JButton but_exit = new JButton("Back");
		but_exit.setBounds(Window.resolution.width/2-50, Window.resolution.height/10*9, 100, 50);
		but_exit.addActionListener(new Put_back());
		add(but_exit);
		
		JLabel athors_text = new JLabel("Art, Колясик");
		athors_text.setBounds(Window.resolution.width/2-50, Window.resolution.height/2-25, 100, 50);
		add(athors_text);
	}
}
class Put_back implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(new Mini_menu());
	}
}
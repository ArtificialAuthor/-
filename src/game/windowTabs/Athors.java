package game.windowTabs;
import javax.swing.JButton;
import javax.swing.JLabel;
import game.Window;
import java.awt.Font;
public class Athors extends WindowTab {
	@Override 
	public void call(byte r) {	
	}
	public Athors() {
		setLayout(null);
		
		Font text = new Font("Times New Roman", Font.BOLD, 150);
		Font butt = new Font("Times New Roman", Font.BOLD, 30);
		JButton but_exit = new JButton("Back");
		but_exit.setFont(butt);
		but_exit.setBounds(Window.resolution.width/2-75, Window.resolution.height/10*9, 150, 50);
		but_exit.addActionListener(new Put_back());
		add(but_exit);
		
		JLabel athors_text = new JLabel("Art, Колясик");
		athors_text.setFont(text);
		athors_text.setBounds(Window.resolution.width/2-420, Window.resolution.height/2-200, 1000, 400);
		add(athors_text);
	}
}
class Put_back implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(new Mini_menu());
	}
}
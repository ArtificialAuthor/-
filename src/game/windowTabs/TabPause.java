//CFG 0
package game.windowTabs;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import game.Window;

//Class - TabPause - tab with pause menu that stops all threads except rendering one
public class TabPause extends WindowTab {
	//CFG2
	public TabPause(TabCanvas attach) {
		//Подготовка
		setLayout(null);
		setVisible(false);
		Font specialPauseFont = new Font("Times New Roman", Font.BOLD, 60);
		
		//Размеры окошечка
		setBounds(Window.resolution.width / 2 - Window.resolution.width/8, Window.resolution.height / 2 - Window.resolution.height / 4, Window.resolution.width / 4, Window.resolution.height / 2);
		
		//Шапка
		JLabel pause = new JLabel("Пауза");
		pause.setFont(specialPauseFont);
		pause.setHorizontalAlignment(JLabel.CENTER);
		pause.setBounds(0, 0,  Window.resolution.width / 4, Window.resolution.height / 6);
		add(pause);
		
		// Кнопка "Продолжить"
		JButton next = new JButton("Продолжить");
		next.setFont(defaultButtonFont);
		next.setBounds(Window.resolution.height/8-(Window.resolution.width / 32*5)/128*32, (Window.resolution.height / 2)/3+((Window.resolution.height / 2)/3)/2-15 , Window.resolution.width / 32*5, Window.resolution.height / 12);
		next.addActionListener(new CG(attach));
		add(next);
		
		// Кнопка "Выход в меню"
		JButton exit = new JButton("Выйти в меню");
		exit.setFont(defaultButtonFont);
		exit.setBounds(Window.resolution.height/8-(Window.resolution.width / 64*11)/128*51, (Window.resolution.height / 2)/3*2+((Window.resolution.height / 2)/3)/2-15 , Window.resolution.width / 64*12, Window.resolution.height / 12);
		exit.addActionListener(new EG());
		add(exit);
	}
}

//CFG4
//Listener - CG [Continue Game]
class CG implements java.awt.event.ActionListener {
	//CFG 1
	TabCanvas attached;
	
	//CFG 2
	public CG(TabCanvas attach) {
		attached = attach;
	}
	
	//CFG 3
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		attached.kc.action(0, false);
	}
}

//Listener - EG [Exit Game]
class EG implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(0); //0 - Id of main menu panel
	}
}
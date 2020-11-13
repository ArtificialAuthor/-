package game.windowTabs;
import javax.swing.JButton;
import javax.swing.JPanel;
import game.Window;
import java.awt.Font;

//Код - панель паузы
public class TabPause extends WindowTab {
	//CFG2
	public TabPause(TabCanvas connectedTo) {
		//Подготовка
		setLayout(null);
		setVisible(false);
		
		//Размеры окошечка
		setBounds(Window.resolution.width, Window.resolution.height, Window.resolution.width/4, Window.resolution.height/2);
		
		// Кнопка "Продолжить"
		JButton next = new JButton("Продолжить");
		next.setFont(defaultButtonFont);
		next.setBounds(Window.resolution.width/2, Window.resolution.height/3, Window.resolution.width/2, Window.resolution.height/3);
		next.addActionListener(new ListenСontinueFrom1());
		add(next);
		
		// Кнопка "Выход в меню"
		JButton exit = new JButton("Выход в меню");
		exit.setFont(defaultButtonFont);
		exit.setBounds(Window.resolution.width/2, Window.resolution.height/3*2, Window.resolution.width/2, Window.resolution.height/3);
		exit.addActionListener(new ListenExitFrom1());
		add(exit);
	}
	
}

//CFG4
//Слушатель кнопки "Продолжить"
class ListenСontinueFrom1 implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(2); //2 - ID панели с игрой
	}
}

//Слушатель кнопки "Выход в меню"
class ListenExitFrom1 implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(0); //0 - ID панели с гл. менюшкой
	}
}
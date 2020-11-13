package game.windowTabs;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import game.Window;

//Код - панель паузы
public class TabPause extends WindowTab {
	//CFG 1
	public TabCanvas connectedWith;
	
	//CFG2
	public TabPause(TabCanvas connectedTo) {
		//Подготовка
		connectedWith = connectedTo;
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
		next.addActionListener(new ListenСontinueFrom1(this));
		add(next);
		
		// Кнопка "Выход в меню"
		JButton exit = new JButton("Выйти в меню");
		exit.setFont(defaultButtonFont);
		exit.setBounds(Window.resolution.height/8-(Window.resolution.width / 64*11)/128*51, (Window.resolution.height / 2)/3*2+((Window.resolution.height / 2)/3)/2-15 , Window.resolution.width / 64*12, Window.resolution.height / 12);
		exit.addActionListener(new ListenExitFrom1());
		add(exit);
	}
}

//CFG4
//Слушатель кнопки "Продолжить"
class ListenСontinueFrom1 implements java.awt.event.ActionListener {
	//CFG 1
	TabPause connectedWith;
	
	//CFG 2
	public ListenСontinueFrom1(TabPause connectTo) {
		connectedWith = connectTo;
	}
	
	//CFG 3
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		connectedWith.connectedWith.physicsEngine.start();
		connectedWith.setVisible(false);
	}
}

//Слушатель кнопки "Выход в меню"
class ListenExitFrom1 implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(0); //0 - ID панели с гл. менюшкой
	}
}
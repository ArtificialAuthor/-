//Код Artt
//Зависимости
package game.windowTabs;
import javax.swing.JButton;
import game.Window;

//Класс - панель главного меню
public class TabMainMenu extends WindowTab {
	//CFG 3
	public TabMainMenu() {
		//Подготовка
		setLayout(null);
		
		//Кнопка "Выход"
		JButton exit = new JButton("Выход");
		exit.setBounds(Window.resolution.width/2-75, Window.resolution.height/2+100, 150, 50);
		exit.addActionListener(new listenExit());
		exit.setFont(defaultButtonFont);
		add(exit);
		
		//Кнопка "Авторы"
		JButton athors = new JButton("Авторы");
		athors.setBounds(Window.resolution.width/2-75, Window.resolution.height/2, 150, 50);
		athors.addActionListener(new listenAuthors());
		athors.setFont(defaultButtonFont);
		add(athors);
		
		//Кнопка "Играть"
		JButton play = new JButton("Играть");
		play.setBounds(Window.resolution.width/2-75, Window.resolution.height/2-100, 150, 50);
		play.addActionListener(new listenPlay());
		play.setFont(defaultButtonFont);
		add(play);
	}
}

//CFG 4
//Слушатель кнопки "Выход"
class listenExit implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		System.exit(0);
	}
}
//Слушатель кнопки "Авторы"
class listenAuthors implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(1); //1 - ID панели с Авторами
	}
}
//Слушатель кнопки "Играть"
class listenPlay implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(2); //2 - ID панели с игрой
	}
}
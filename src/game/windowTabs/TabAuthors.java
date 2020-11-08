//Код Artt
//Зависимости
package game.windowTabs;
import javax.swing.JButton;
import javax.swing.JLabel;
import game.Window;
import java.awt.Font;

//Код - панель с авторами
public class TabAuthors extends WindowTab {
	//CFG 2
	public TabAuthors() {
		//Подготовка
		setLayout(null);
		Font specialAuthorsFont = new Font("Times New Roman", Font.ITALIC, 40);
		
		//Кнопка "Назад"
		JButton back = new JButton("Back");
		back.setFont(defaultButtonFont);
		back.setBounds(Window.resolution.width/2-75, Window.resolution.height/10*9, 150, 50);
		back.addActionListener(new ListenBackFrom1());
		add(back);
		
		//Лавры
		//Шапка
		JLabel authors = new JLabel("Авторы");
		authors.setFont(defaultTextFont);
		authors.setHorizontalAlignment(JLabel.CENTER);
		authors.setBounds(0, 0, Window.resolution.width, 200);
		add(authors);
		
		//Artt
		authors = new JLabel("Artt (код)");
		authors.setFont(specialAuthorsFont);
		authors.setHorizontalAlignment(JLabel.CENTER);
		authors.setBounds(0, 100, Window.resolution.width, 200);
		add(authors);
		
		//Artificial
		authors = new JLabel("Artificial (код)");
		authors.setFont(specialAuthorsFont);
		authors.setHorizontalAlignment(JLabel.CENTER);
		authors.setBounds(0, 150, Window.resolution.width, 200);
		add(authors);
	}
}

//CFG 4
//Слушатель кнопки "Назад"
class ListenBackFrom1 implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(0); //0 - ID панели с гл. менюшкой
	}
}
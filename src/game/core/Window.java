//Зависимости
package game.core;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;

//Класс - окно
public final class Window extends JFrame{
	//CFG 1 Публичного порядка
	public static Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
	public static Window self;
	
	//CFG 2 порядка
	public Window() {
		//Преднастройка
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setFocusable(true);
		setUndecorated(true);
		setVisible(true);
		setPreferredSize(resolution);
		
		//Постнастройка
		pack();
		validate();
	}
	
	//Ключ зажигания
	public static void main(String args[]) {
		self = new Window();
	}
}
//Зависимости
package game;
import game.windowTabs.*;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Toolkit;

//Класс - окно, хост программы
public final class Window extends javax.swing.JFrame{
	//CFG 1
	public static Window self = new Window();
	public static Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
	public static ArrayList<WindowTab> contents = new ArrayList<WindowTab>();
	
	//CFG 2
	public Window() {
		//Параметризация
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		setPreferredSize(resolution);
	}
	
	//Ключ зажигания
	public static void main(String args[]) {}
}
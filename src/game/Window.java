//�����������
package game;
import game.windowTabs.*;
import java.awt.Dimension;
import java.awt.Toolkit;

//����� - ����, ���� ���������
public final class Window extends javax.swing.JFrame{
	//CFG 1
	public static Window self;
	public static Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
	public static WindowTab current;
	
	//CFG 2
	public Window() {
		//��������������
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		setPreferredSize(resolution);
	}
	
	//���� ���������
	public static void main(String args[]) {
		self = new Window();
		current = new Mini_menu();
		self.add(current);
		self.pack();
	}
	public void switchTab(WindowTab newTab) {
		remove(current);
		current = newTab;
		add(current);
		validate();
		repaint();
	}
}
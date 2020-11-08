//�����������
package game;
import game.windowTabs.*;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.Toolkit;

//����� - ����, ���� ���������
public final class Window extends javax.swing.JFrame{
	//CFG 1
	public static Window self;
	public static Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
	public static int current = 0; //ID ������� ������ ��. ����
	public static ArrayList<WindowTab> tabs = new ArrayList<WindowTab>(); //���� �� ����� ������������� �������� ��. ����
	
	//CFG 2
	public Window() {
		//��������������
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		setPreferredSize(resolution);
		
		//�������� �������
		tabs.add(new TabMainMenu()); //0
		tabs.add(new TabAuthors()); //1
	}
	
	//CFG 3
	//���� ���������
	public static void main(String args[]) {
		self = new Window();
		self.add(tabs.get(0));
		self.pack();
	}
	//������ ������ ����� ID
	public void switchTab(int newTab) {
		try {
			remove(tabs.get(current));
			current = newTab;
			add(tabs.get(current));
			validate();
			repaint();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
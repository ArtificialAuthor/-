package game.windowTabs;
import javax.swing.JButton;
import javax.swing.JPanel;
import game.Window;
import java.awt.Font;

//��� - ������ �����
public class TabPause extends WindowTab {
	//CFG2
	public TabPause(TabCanvas connectedTo) {
		//����������
		setLayout(null);
		setVisible(false);
		
		//������� ��������
		setBounds(Window.resolution.width, Window.resolution.height, Window.resolution.width/4, Window.resolution.height/2);
		
		// ������ "����������"
		JButton next = new JButton("����������");
		next.setFont(defaultButtonFont);
		next.setBounds(Window.resolution.width/2, Window.resolution.height/3, Window.resolution.width/2, Window.resolution.height/3);
		next.addActionListener(new Listen�ontinueFrom1());
		add(next);
		
		// ������ "����� � ����"
		JButton exit = new JButton("����� � ����");
		exit.setFont(defaultButtonFont);
		exit.setBounds(Window.resolution.width/2, Window.resolution.height/3*2, Window.resolution.width/2, Window.resolution.height/3);
		exit.addActionListener(new ListenExitFrom1());
		add(exit);
	}
	
}

//CFG4
//��������� ������ "����������"
class Listen�ontinueFrom1 implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(2); //2 - ID ������ � �����
	}
}

//��������� ������ "����� � ����"
class ListenExitFrom1 implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(0); //0 - ID ������ � ��. ��������
	}
}
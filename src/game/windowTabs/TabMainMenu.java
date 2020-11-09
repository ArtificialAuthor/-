//��� Artt
//�����������
package game.windowTabs;
import javax.swing.JButton;
import game.Window;

//����� - ������ �������� ����
public class TabMainMenu extends WindowTab {
	//CFG 3
	public TabMainMenu() {
		//����������
		setLayout(null);
		
		//������ "�����"
		JButton exit = new JButton("�����");
		exit.setBounds(Window.resolution.width/2-75, Window.resolution.height/2+100, 150, 50);
		exit.addActionListener(new listenExit());
		exit.setFont(defaultButtonFont);
		add(exit);
		
		//������ "������"
		JButton athors = new JButton("������");
		athors.setBounds(Window.resolution.width/2-75, Window.resolution.height/2, 150, 50);
		athors.addActionListener(new listenAuthors());
		athors.setFont(defaultButtonFont);
		add(athors);
		
		//������ "������"
		JButton play = new JButton("������");
		play.setBounds(Window.resolution.width/2-75, Window.resolution.height/2-100, 150, 50);
		play.addActionListener(new listenPlay());
		play.setFont(defaultButtonFont);
		add(play);
	}
}

//CFG 4
//��������� ������ "�����"
class listenExit implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		System.exit(0);
	}
}
//��������� ������ "������"
class listenAuthors implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(1); //1 - ID ������ � ��������
	}
}
//��������� ������ "������"
class listenPlay implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(2); //2 - ID ������ � �����
	}
}
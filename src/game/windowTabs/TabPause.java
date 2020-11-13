package game.windowTabs;
import javax.swing.JButton;
import game.Window;

//��� - ������ �����
public class TabPause extends WindowTab {
	//CFG 1
	public TabCanvas connectedWith;
	
	//CFG2
	public TabPause(TabCanvas connectedTo) {
		//����������
		connectedWith = connectedTo;
		setLayout(null);
		setVisible(false);
		
		//������� ��������
		setBounds(Window.resolution.width / 2 - Window.resolution.width/8, Window.resolution.height / 2 - Window.resolution.height / 4, Window.resolution.width / 4, Window.resolution.height / 2);
		
		// ������ "����������"
		JButton next = new JButton("����������");
		next.setFont(defaultButtonFont);
		next.setBounds(40, 40, Window.resolution.width / 4 - 80, Window.resolution.height / 4 - 80);
		next.addActionListener(new Listen�ontinueFrom1(this));
		add(next);
		
		// ������ "����� � ����"
		JButton exit = new JButton("����� � ����");
		exit.setFont(defaultButtonFont);
		exit.setBounds(40, Window.resolution.height / 4 + 80, Window.resolution.width / 4 - 80, Window.resolution.height / 4 - 80);
		exit.addActionListener(new ListenExitFrom1());
		add(exit);
	}
}

//CFG4
//��������� ������ "����������"
class Listen�ontinueFrom1 implements java.awt.event.ActionListener {
	//CFG 1
	TabPause connectedWith;
	
	//CFG 2
	public Listen�ontinueFrom1(TabPause connectTo) {
		connectedWith = connectTo;
	}
	
	//CFG 3
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		connectedWith.connectedWith.physicsEngine.start();
		connectedWith.setVisible(false);
	}
}

//��������� ������ "����� � ����"
class ListenExitFrom1 implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(0); //0 - ID ������ � ��. ��������
	}
}
//��� Artt
//�����������
package game.windowTabs;
import javax.swing.JButton;
import javax.swing.JLabel;
import game.Window;
import java.awt.Font;

//��� - ������ � ��������
public class TabAuthors extends WindowTab {
	//CFG 2
	public TabAuthors() {
		//����������
		setLayout(null);
		Font specialAuthorsFont = new Font("Times New Roman", Font.ITALIC, 40);
		
		//������ "�����"
		JButton back = new JButton("Back");
		back.setFont(defaultButtonFont);
		back.setBounds(Window.resolution.width/2-75, Window.resolution.height/10*9, 150, 50);
		back.addActionListener(new ListenBackFrom1());
		add(back);
		
		//�����
		//�����
		JLabel authors = new JLabel("������");
		authors.setFont(defaultTextFont);
		authors.setHorizontalAlignment(JLabel.CENTER);
		authors.setBounds(0, 0, Window.resolution.width, 200);
		add(authors);
		
		//Artt
		authors = new JLabel("Artt (���)");
		authors.setFont(specialAuthorsFont);
		authors.setHorizontalAlignment(JLabel.CENTER);
		authors.setBounds(0, 100, Window.resolution.width, 200);
		add(authors);
		
		//Artificial
		authors = new JLabel("Artificial (���)");
		authors.setFont(specialAuthorsFont);
		authors.setHorizontalAlignment(JLabel.CENTER);
		authors.setBounds(0, 150, Window.resolution.width, 200);
		add(authors);
		
		//HUKUTKA
		authors = new JLabel("HUKUTKA (�����)");
		authors.setFont(specialAuthorsFont);
		authors.setHorizontalAlignment(JLabel.CENTER);
		authors.setBounds(0, 200, Window.resolution.width, 200);
		add(authors);
	}
}

//CFG 4
//��������� ������ "�����"
class ListenBackFrom1 implements java.awt.event.ActionListener {
	@Override 
	public void actionPerformed(java.awt.event.ActionEvent e) {
		Window.self.switchTab(0); //0 - ID ������ � ��. ��������
	}
}
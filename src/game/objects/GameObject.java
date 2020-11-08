//��� Artificial
//�����������
package game.objects;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;

//����� - ������� ������
public class GameObject extends javax.swing.JPanel{
	//CFG 1
	public String name = "GameObject";
	public double position[] = {0, 0};
	public double size[] = {0, 0};
	ArrayList<Behavivour> behavivour = new ArrayList<Behavivour>();
	
	//CFG 2
	//����������� ��� �����
	public GameObject() {
		
	}
	//����������� � ������
	public GameObject(String setName) {
		name = setName;
	}
	
	//CFG 3
	//���������
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
	//������������ ����������
	public Behavivour getBehavivour(String behavivourID) throws Exception {
		for (Behavivour beh : behavivour) {
			if(beh.ID == behavivourID) {
				return beh;
			}
		}
		throw new Exception("� "+name+" ��� game.objects.behavivours."+behavivourID+"!");
	}
}
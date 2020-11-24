//��� Artificial
//CFG 0
package game.objects;
import game.Window;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

//����� - ������� ������
public class GameObject {
	//CFG 1
	public String name = "GameObject";
	public double position[] = {0, 0};
	public double size[] = {0, 0};
	public double rotation = 0;
	public BufferedImage texture;
	public Shape shape = Shape.cube();
	private ArrayList<Behavivour> behavivour = new ArrayList<Behavivour>();
	
	//CFG 2
	//��� �����
	public GameObject() {}
	//�������
	public GameObject(String setName) {
		name = setName;
	}
	
	//CFG 3
	//C������ ���������
	//��������� �������� �� ��������
	public void setTexture(String texturePath) {
		try {
			texture = ImageIO.read(Window.class.getResource("sprites/"+texturePath));
		} catch (Exception e) {}
	}
	//������� ���������
	//�������� ���������
	public void addBehavivour(Behavivour beh) {
		beh.attached = this;
		behavivour.add(beh);
	}
	//������� ���������
	//�������, ����� ������� ������ �� ���������
	public void remBehavivour(String removingBehavivourID) {
		for (Behavivour beh : behavivour) {
			if(beh.ID == removingBehavivourID) {
				behavivour.remove(beh);
			}
		}
	}
	//�������, ����� ���� ������ �� ���������
	public void remBehavivour(Behavivour removingBehavivour) {
		behavivour.remove(removingBehavivour);
	}
	//��������� ���������
	public Behavivour getBehavivour(String behavivourID) throws Exception {
		for (Behavivour beh : behavivour) {
			if(beh.ID == behavivourID) {
				return beh;
			}
		}
		throw new Exception("� "+name+" ��� ��������� "+behavivourID+"!");
	}
	//��������� ���������
	public boolean hasBehavivour(String behavivourID) {
		for (Behavivour beh : behavivour) {
			if(beh.ID == behavivourID) {
				return true;
			}
		}
		return false;
	}
}
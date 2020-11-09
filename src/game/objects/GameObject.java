//Код Artificial
//CFG 0
package game.objects;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

//Класс - игровой объект
public class GameObject extends javax.swing.JPanel{
	//CFG 1
	public String name = "GameObject";
	public double position[] = {0, 0};
	public double size[] = {0, 0};
	public double rotation = 0;
	public BufferedImage texture;
	ArrayList<Behavivour> behavivour = new ArrayList<Behavivour>();
	
	//CFG 2
	//Без имени
	public GameObject() {
		
	}
	//Именной
	public GameObject(String setName) {
		name = setName;
	}
	
	//CFG 3
	//Обрисовка
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.translate(getWidth()/2, getHeight()/2);
		g2.rotate(rotation);
		g2.translate(-getWidth()/2, -getHeight()/2);
		if (texture != null) {
			g2.drawImage(texture.getScaledInstance(getWidth(), getHeight(), texture.SCALE_FAST), 0, 0, null);
		} else {
			g2.setColor(Color.white);
			g2.fillRect(0, 0, getWidth(), getHeight());
		}
	}
	//Добавить поведение
	public void addBehavivour(Behavivour beh) {
		beh.attached = this;
		behavivour.add(beh);
	}
	//Выдернуть поведение
	public Behavivour getBehavivour(String behavivourID) throws Exception {
		for (Behavivour beh : behavivour) {
			if(beh.ID == behavivourID) {
				return beh;
			}
		}
		throw new Exception("пїЅ "+name+" пїЅпїЅпїЅ пїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅпїЅ "+behavivourID+"!");
	}
	//Проверить поведение
	public boolean hasBehavivour(String behavivourID) {
		for (Behavivour beh : behavivour) {
			if(beh.ID == behavivourID) {
				return true;
			}
		}
		return false;
	}	
}
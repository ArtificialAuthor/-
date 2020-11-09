//Код Artificial
//Зависимости
package game.objects;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Graphics2D;

//Класс - игровой объект
public class GameObject extends javax.swing.JPanel{
	//CFG 1
	public String name = "GameObject";
	public double position[] = {0, 0};
	public double size[] = {0, 0};
	public double rotation = 0;
	ArrayList<Behavivour> behavivour = new ArrayList<Behavivour>();
	
	//CFG 2
	//Конструктор без имени
	public GameObject() {
		
	}
	//Конструктор с именем
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
		g2.fillRect(0, 0, getWidth(), getHeight());
	}
	//Добавление компонента
	public void addBehavivour(Behavivour beh) {
		beh.attached = this;
		behavivour.add(beh);
	}
	//Выдергивание компонента
	public Behavivour getBehavivour(String behavivourID) throws Exception {
		for (Behavivour beh : behavivour) {
			if(beh.ID == behavivourID) {
				return beh;
			}
		}
		throw new Exception("У "+name+" нет поведения "+behavivourID+"!");
	}
	//Проверка компонента
	public boolean hasBehavivour(String behavivourID) {
		for (Behavivour beh : behavivour) {
			if(beh.ID == behavivourID) {
				return true;
			}
		}
		return false;
	}	
}
//Код Artificial
//CFG 0
package game.objects;
import game.Window;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

//Класс - игровой объект
public class GameObject{
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
	//CИСТЕМЫ ОБРИСОВКИ
	//Загрузить текстуру из спрайтов
	public void setTexture(String texturePath) {
		try {
			texture = ImageIO.read(Window.class.getResource("sprites/"+texturePath));
		} catch (Exception e) {}
	}
	//СИСТЕМЫ ПОВЕДЕНИЯ
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
//Код Artificial
//CFG 0
package game.objects;
import java.util.ArrayList;

//Класс - игровой объект
public class GameObject {
	//CFG 1
	public String name = "GameObject";
	public double position[] = {0, 0};
	public double size[] = {1, 1};
	public double rotation = 0;
	public Shape shape = Shape.cube();
	private ArrayList<Behavivour> behavivour = new ArrayList<Behavivour>();
	
	//CFG 2
	//Без имени
	public GameObject() {}
	//Именной
	public GameObject(String setName) {
		name = setName;
	}
	
	//CFG 3
	//CИСТЕМЫ ОБРИСОВКИ

	//СИСТЕМЫ ПОВЕДЕНИЯ
	//Добавить поведение
	public void addBehavivour(Behavivour beh) {
		beh.attached = this;
		behavivour.add(beh);
	}
	//Удалить поведение
	//Вариант, когда утеряна ссылка на поведение
	public void remBehavivour(String removingBehavivourID) {
		for (Behavivour beh : behavivour) {
			if(beh.ID == removingBehavivourID) {
				behavivour.remove(beh);
			}
		}
	}
	//Вариант, когда есть ссылка на поведение
	public void remBehavivour(Behavivour removingBehavivour) {
		behavivour.remove(removingBehavivour);
	}
	//Выдернуть поведение
	public Behavivour getBehavivour(String behavivourID) throws Exception {
		for (Behavivour beh : behavivour) {
			if(beh.ID == behavivourID) {
				return beh;
			}
		}
		throw new Exception("У "+name+" нет поведения "+behavivourID+"!");
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
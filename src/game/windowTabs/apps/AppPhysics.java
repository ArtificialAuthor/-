//Зависимости
package game.windowTabs.apps;
import java.util.ArrayList;
import game.windowTabs.WindowTab;
import game.objects.GameObject;
import game.objects.behavivours.*;

//Класс - игровая физика
public class AppPhysics implements Runnable {
	//CFG 1
	WindowTab attached;
	boolean active = false;
	int currentLng = 0;
	
	//!ВНИМАНИЕ!
	//ЛИСТЫ - КОНФИНГУРАТОРЫ, ПРОСЬБА НЕ ТРОГАТЬ!
	ArrayList<GameObject> scene = new ArrayList<GameObject>(); //Общий список объектов, которым требуется физический рендеринг
	ArrayList<PhysicalBody> PhysicalBodies = new ArrayList<PhysicalBody>();
	
	
	//CFG 2
	public AppPhysics(WindowTab attachWith) {
		attached = attachWith;
	}
	
	//CFG 3
	//Физический поток
	@Override
	public void run() {
		try {
			while (active) {
				Thread.sleep(10);
				//Проход через все тела
				for (int objThis = 0; objThis < currentLng; objThis++) {
					//Сначала PhysicalBody
					try {
						PhysicalBody itsPhysicalBody = (PhysicalBody) scene.get(objThis).getBehavivour("PhysicalBody");
						itsPhysicalBody.doPhysicalTick();
					} catch (Exception e) {}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//Запуск
	public void start() {
		active = true;
		new Thread(this).start();
	}
	//Завершение
	public void stop() {
		active = false;
	}
	//Добавить объект
	public void add(GameObject obj) {
		scene.add(obj);
		currentLng++;
	}
	//Удалить объект
	public void remove(GameObject obj) {
		scene.remove(obj);
		currentLng--;
	}
}
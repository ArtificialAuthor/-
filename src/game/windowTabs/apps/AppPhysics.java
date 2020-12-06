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
	
	//!ВНИМАНИЕ!
	//ЛИСТЫ - КОНФИНГУРАТОРЫ, ПРОСЬБА НЕ ТРОГАТЬ!
	ArrayList<PhysicalBody> PhysicalBodies = new ArrayList<PhysicalBody>();
	
	
	//CFG 2
	public AppPhysics(WindowTab attachWith) {
		attached = attachWith;
	}
	
	//CFG 3
	//Physics tick (1/10s.)
	@Override
	public void run() {
		try {
			while (active) {
				Thread.sleep(10);
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
}
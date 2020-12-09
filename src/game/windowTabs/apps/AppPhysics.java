//CFG 0
package game.windowTabs.apps;
import java.util.ArrayList;
import game.objects.GameObject;
import game.objects.behavivours.*;

//Class - AppPhysics - the game physics engine
public class AppPhysics implements Runnable {
	//CFG 1
	ArrayList<GameObject> scene;
	public boolean active = true;
	
	//!¬Õ»Ã¿Õ»≈!
	//À»—“€ -  ŒÕ‘»Õ√”–¿“Œ–€, œ–Œ—‹¡¿ Õ≈ “–Œ√¿“‹!
	ArrayList<PhysicalBody> PhysicalBodies = new ArrayList<PhysicalBody>();
	
	//CFG 2
	public AppPhysics(ArrayList<GameObject> scene) {
		this.scene = scene;
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
}
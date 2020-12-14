//CFG 0
package game.windowTabs.apps;
import java.util.ArrayList;
import game.objects.behavivours.*;

//Class - AppPhysics - the game physics engine
public class AppPhysics implements Runnable {
	//CFG 1
	static public boolean active = true;
	static public ArrayList<PhysicalBody> physicalBodies = new ArrayList<PhysicalBody>();
	
	//CFG 3
	//Physics tick (1/10s.)
	@Override
	public void run() {
		try {
			while (active) {
				Thread.sleep(100);
				for (PhysicalBody body : physicalBodies) {
					body.apply();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
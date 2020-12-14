//CFG 0
package game.objects.behavivours;
import game.windowTabs.apps.AppPhysics;

//Class - PhysicalBody - lets physics engine to know about object's physics relatives
public class PhysicalBody extends Behavivour{
	//CFG 1
	public double velocity[] = {0, 0};
	public double angularVelocity = 0;
	
	//CFG 2
	public PhysicalBody() {
		ID = "physicalBody";
		AppPhysics.physicalBodies.add(this);
	}
	
	//CFG 3
	//Physical mthod
	public void apply() {
		attached.position[0] += velocity[0];
		attached.position[1] += velocity[1];
		attached.rotation += angularVelocity;
	}
	//setJSON
	public void load(String field, String value) {
		if (field.contains("velocity")) {
			if (field.contains("angular")) {
				angularVelocity = Double.parseDouble(value);
			} else {
				String[] arr = value.split(",");
				velocity[0] = Double.parseDouble(arr[0]);
				velocity[1] = Double.parseDouble(arr[1]);
			}
		}
	}
}
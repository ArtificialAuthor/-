//CFG 0
package game.objects;
import java.util.ArrayList;
import game.objects.behavivours.Behavivour;

//Class - GameObject - holds main information about object & its behavivour
public class GameObject {
	//CFG 1
	public String name = "GameObject";
	public double position[] = {0, 0};
	public double size[] = {1, 1};
	public double rotation = 0;
	public Shape shape = Shape.cube();
	private ArrayList<Behavivour> behavivour = new ArrayList<Behavivour>();
	
	//CFG 2
	//Noname
	public GameObject() {}
	//Named
	public GameObject(String setName) {
		name = setName;
	}
	
	//CFG 3
	//LOADING SYSTEMS
	public boolean load(String field, String value) {
		if (field.contains("name")) {
			name = value;
			return true;
		} else if (field.contains("rotation")) {
			rotation = Double.parseDouble(value);
			return true;
		} else if (field.indexOf("size") != -1) {
			String[] arr = value.split(",");
			size[0] = Double.parseDouble(arr[0]);
			size[1] = Double.parseDouble(arr[1]);
			return true;
		} else if (field.contains("position")) {
			String[] arr = value.split(",");
			position[0] = Double.parseDouble(arr[0]);
			position[1] = Double.parseDouble(arr[1]);
			return true;
		}
		return false;
	}
	//BEHAVIVOUR SYSTEMS
	//Add behavivour
	public void addBehavivour(Behavivour beh) {
		beh.attached = this;
		behavivour.add(beh);
	}
	//Remove behavivour [No link]
	public void remBehavivour(String removingBehavivourID) {
		for (Behavivour beh : behavivour) {
			if(beh.ID == removingBehavivourID) {
				behavivour.remove(beh);
			}
		}
	}
	//Remove behavivour [Linked]
	public void remBehavivour(Behavivour removingBehavivour) {
		behavivour.remove(removingBehavivour);
	}
	//Get behavivour
	public Behavivour getBehavivour(String behavivourID) throws Exception {
		//By flag
		if (behavivourID == "latest") {
			return behavivour.get(behavivour.size()-1);
		}
		//By ID
		for (Behavivour beh : behavivour) {
			if(beh.ID == behavivourID) {
				return beh;
			}
		}
		throw new Exception(name+" hasn't "+behavivourID+" behavivour!");
	}
	//Check behavivour
	public boolean hasBehavivour(String behavivourID) {
		for (Behavivour beh : behavivour) {
			if(beh.ID == behavivourID) {
				return true;
			}
		}
		return false;
	}
}
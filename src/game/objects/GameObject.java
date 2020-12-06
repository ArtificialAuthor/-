//Code by Artificial
//CFG 0
package game.objects;
import java.util.ArrayList;

//Class - GameObject, holds main information about object & its behavivour
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
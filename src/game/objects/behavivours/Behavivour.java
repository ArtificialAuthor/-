//CFG 0
package game.objects.behavivours;
import game.objects.GameObject;

//Super Class - Behavivour
public abstract class Behavivour {
	//CFG 1
	public GameObject attached;
	public String ID;
	
	//CFG 3
	public abstract void load(String field, String value);
	public static Behavivour loadByID(String ID) throws Exception {
		if (ID.equals("physicalbody")) {
			return new PhysicalBody();
		}
		throw new Exception("Invalid behavivour ID: "+ID+". This save/scene won't load, sorry.");
	}
}
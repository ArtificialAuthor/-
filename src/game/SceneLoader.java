//CFG 0
package game;
import java.util.Scanner;
import java.util.ArrayList;
import game.objects.*;
import game.objects.behavivours.Behavivour;

//Class - SceneLoader - loads up scenes
public class SceneLoader {
	//CFG 3
	public static ArrayList<GameObject> getScene(int ID) {
		//Preparing
		ArrayList<GameObject> scene = new ArrayList<GameObject>();
		Scanner reading = new Scanner(SceneLoader.class.getResourceAsStream(ID+".scene"));
		//Read whole file through lines
		String line = "!";
		int edit = -1;
		while (line != "") {
			try {
				line = reading.nextLine().toLowerCase();
				if (!line.contains("//")) {
					//Ignore comments
					if (line.equals("object")) {
						//Paste object
						edit++;
						scene.add(new GameObject());
					} else if (line.contains("behavivour")) {
						//Paste behavivoir
						scene.get(edit).addBehavivour(Behavivour.loadByID(line.substring(line.indexOf("behavivour")+11)));
					} else {
						String[] arr = line.split(" ", 2);
						// >:D
						if (!scene.get(edit).load(arr[0], arr[1])) { //Try to load to Object
							scene.get(edit).getBehavivour("latest").load(arr[0], arr[1]); //If failed, then to its Behavivour
						}
					}
				}
			} catch (Exception e) {
				line = "";
			}
		}
		//Return
		return scene;
	}
}
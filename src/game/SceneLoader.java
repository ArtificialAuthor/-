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
					if (line.equals("object")) {
						edit++;
						scene.add(new GameObject());
					} else if (line.contains("name")) {
						scene.get(edit).name = line.substring(line.indexOf("name")+5);
					} else if (line.contains("rotation")) {
						scene.get(edit).rotation = Double.parseDouble(line.substring(line.indexOf("rotation")+9));
					} else if (line.indexOf("size") != -1) {
						String[] arr = line.substring(line.indexOf("size")+5).split(",");
						scene.get(edit).size[0] = Double.parseDouble(arr[0]);
						scene.get(edit).size[1] = Double.parseDouble(arr[1]);
					} else if (line.contains("position")) {
						String[] arr = line.substring(line.indexOf("position")+9).split(",");
						scene.get(edit).position[0] = Double.parseDouble(arr[0]);
						scene.get(edit).position[1] = Double.parseDouble(arr[1]);
					} else if (line.contains("behavivour")) {
						scene.get(edit).addBehavivour(Behavivour.loadByID(line.substring(line.indexOf("behavivour")+11)));
					} else {
						String[] arr = line.split(" ", 2);
						scene.get(edit).getBehavivour("latest").load(arr[0], arr[1]);
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
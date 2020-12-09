//CFG 0
package game;
import java.util.Scanner;

//Class - SceneLoader - loads up scenes
public class SceneLoader {
	//CFG 3
	public static void getScene(int scene) {
		//Assemble input stream from scene file
		Scanner reading = new Scanner(SceneLoader.class.getResourceAsStream(scene+".scene"));
		//Read whole file through lines
		String line = reading.nextLine().toLowerCase();
		while (line != "") {
			try {
				line = reading.nextLine();
			} catch (Exception e) {
				line = "";
			}
		}
	}
}
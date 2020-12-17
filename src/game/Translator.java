//CFG 0
package game;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;

//Class - Translator - allows fast translation through whole game (Don't forget about handling)
public class Translator {
	//CFG 1
	ArrayList<String> fields = new ArrayList<String>();
	ArrayList<String> values = new ArrayList<String>();
	
	//CFG 2
	public Translator(String lang) {
		//DEFAULT : ru.lang
		try {
			FileInputStream fs = new FileInputStream(Window.location+"/langs/"+lang+".lang");
			Scanner inTake = new Scanner(fs);
			//Reading
			String line = inTake.nextLine();
			while (!line.equals("!")) {
				String[] arr = line.split(":");
				fields.add(arr[0]);
				values.add(arr[1]);
				line = inTake.nextLine();
			}
			//Final
			inTake.close();
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//CFG 2
	//Set language to field
	public String load(String field) {
		try {
			for (int i = 0; i < fields.size(); i++) {
				if (field.equals(fields.get(i))) {
					return values.get(i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "<"+field+">";
	}
}
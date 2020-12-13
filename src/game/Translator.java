//CFG 0
package game;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

//Class - Translator - allows fast translation through whole game (Don't forget about handling)
public class Translator {
	//CFG 1
	ArrayList<String> fields = new ArrayList<String>();
	ArrayList<String> values = new ArrayList<String>();
	
	//CFG 2
	public Translator(String lang) {
		//DEFAULT : ru.lang
		try (BufferedReader inTake = new BufferedReader(new FileReader(new File(Window.location+"/langs/"+lang+".lang")))) { //>:D
			String cur = inTake.readLine();
			while (cur != null) {
				String[] arr = cur.split(":"); //Split it into field & value
				fields.add(arr[0]); //Write field to fields
				values.add(arr[1]); //Write value to values
				cur = inTake.readLine();
			}
			inTake.close();
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
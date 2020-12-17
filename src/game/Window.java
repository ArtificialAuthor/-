//CFG 0
package game;
import game.windowTabs.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileWriter;

//Class - Window - program host
public final class Window extends javax.swing.JFrame{
	//CFG 1
	public static Window self;
	public static Translator translator;
	public static Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
	public static int current = 0; //Current panel ID, must be 0 for displaying main menu
	public static ArrayList<WindowTab> tabs = new ArrayList<WindowTab>(); //List of all possible panels with IDs equals their index
	public static String location;
	
	//CFG 2
	public Window() {
		//Loading settings
		try {
			//Fine found, prepare
			FileInputStream fs = new FileInputStream(location+"/settings.cfg");
			Scanner sw = new Scanner(fs);
			//Load settings
			String load = "";
			while (!load.equals("!")) {
				load = sw.nextLine().toLowerCase();
				String arr[] = load.split(":");
				if (arr[0].equals("lang")) {
					translator = new Translator(arr[1]);
				}
			}
			//Close streams
			sw.close();
			fs.close();
		} catch (Exception e) {
			//File not found, create
			try {
				//Write to defaults
				FileWriter fw = new FileWriter(location+"/settings.cfg");
				fw.write("lang:en\n!");
				fw.flush();
				fw.close();
				//Roll to defaults
				translator = new Translator("en");
			} catch (Exception fwe) {}
		}
		
		//Pre - CFG
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setVisible(true);
		setPreferredSize(resolution);
		
		//Panel loading & IDs
		tabs.add(new TabMainMenu()); //0
		tabs.get(0).setFocusable(true);
		tabs.add(new TabAuthors()); //1
		tabs.get(1).setFocusable(true);
		tabs.add(new TabCanvas()); //2
		tabs.get(2).setFocusable(true);
	}
	
	//CFG 3
	//Launching from here
	public static void main(String args[]) {
		//Getting game location
		location = Window.class.getResource("Window.class").getPath();
		location = location.substring(0, location.length() - "/game/Window.class".length());
		int pLast = 1;
		int pFind = location.indexOf("/", pLast);
		while (pFind != -1) {
			pLast = pFind+1;
			pFind = location.indexOf("/", pLast);
		}
		location = location.substring(0, pLast);
		//Getting game cores
		self = new Window();
		self.add(tabs.get(0));
		self.pack();
	}
	//Set panel through ID
	public void switchTab(int newTab) {
		try {
			remove(tabs.get(current));
			current = newTab;
			add(tabs.get(current));
			validate();
			repaint();
			tabs.get(current).requestFocusInWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
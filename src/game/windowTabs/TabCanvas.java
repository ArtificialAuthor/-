//Code by Artificial
//CFG 0
package game.windowTabs;
import game.Window;
import game.windowTabs.apps.AppPhysics;
import game.objects.GameObject;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.lang.Math;

//Class - Canvas, holds objects and more.
public class TabCanvas extends WindowTab implements Runnable{
	//CFG 1
	//Camera
	int FPSLimit = 30;
	//Sources
	ArrayList<GameObject> scene = new ArrayList<GameObject>();
	AppPhysics physicsEngine = new AppPhysics(this);
	public TabPause tabPause = new TabPause(this);
	//Controls
	MSC msc = new MSC();
	KC kc = new KC();
	
	
	//CFG 2
	public TabCanvas() {
		//Filling scene
		GameObject kek = new GameObject();
		scene.add(kek);
		kek.position[0] = 0;
		kek.position[1] = 0;
		kek.size[0] = 100;
		kek.size[1] = 100;
		
		kek = new GameObject();
		scene.add(kek);
		kek.position[0] = 200;
		kek.position[1] = 0;
		kek.size[0] = 200;
		kek.size[1] = 100;
		
		//Launching cores
		physicsEngine.start();
		new Thread(this).start();
		addMouseWheelListener(msc);
		addKeyListener(kc);
	}
	
	//CFG 3
	//Rendering, PART I
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000/FPSLimit);
				repaint();
			}
		} catch (InterruptedException e) {}
	}
	//Rendering, PART II
	@Override
	public void paintComponent(Graphics g) {
		//Preparing canvas
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0,0,Window.resolution.width,Window.resolution.height);
		//Preparing camera
		if (kc.cLock != null) {
			kc.cPos[0] = kc.cPos[0];
			kc.cPos[1] = kc.cPos[1];
		}
		//Rendering objects
		for (GameObject obj : scene) {
			if (obj.shape != null) {
				//Prepare
				double[] rPos = {
					(obj.position[0] + kc.cPos[0]) * msc.cScale + Window.resolution.width/2,
					(obj.position[1] + kc.cPos[1]) * msc.cScale + Window.resolution.height/2,	
				};
				//Object has shape
				int[] pointX = new int[obj.shape.a.length];
				int[] pointY = new int[obj.shape.a.length];
				for (int dot=0; dot<obj.shape.a.length; dot++){
					pointX[dot] = (int)(rPos[0] + Math.cos(obj.shape.a[dot]+obj.rotation)*obj.shape.r[dot]*obj.size[0] * msc.cScale);
					pointY[dot] = (int)(rPos[1] + Math.sin(obj.shape.a[dot]+obj.rotation)*obj.shape.r[dot]*obj.size[1] * msc.cScale);
				}
				g2.fillPolygon(pointX, pointY, pointX.length);
			}
		}

	}
}

//CFG 4
//Class - Mouse Scroll Control [MSC, for short]
class MSC implements java.awt.event.MouseWheelListener {
	//CFG 1
	double cScale = 1;
	double cMinZoom = 0.01;
	double cMaxZoom = 10;
	
	//CFG 3
	public void mouseWheelMoved(java.awt.event.MouseWheelEvent e) {
		cScale += e.getUnitsToScroll() / 50d * cScale;
		if (cScale < cMinZoom) {
			cScale = cMinZoom;
		}
	}
}

//Class -Key Control [KC, for short] 
class KC implements java.awt.event.KeyListener {
	//CFG 1
	double[] cPos = {0, 0};
	GameObject cLock;
	boolean[] down = {
		false, //Forward
		false, //Backward
		false, //Left
		false  //Right
	};
	int[] keys = {
		87,
		83,
		65,
		68
	};
	
	//CFG 3
	public void keyPressed(java.awt.event.KeyEvent e) {
		int key = e.getKeyCode();
		for (int isThisKey = 0; isThisKey < keys.length; isThisKey++) {
			if (keys[isThisKey] == key) {
				down[isThisKey] = true;
				action(isThisKey);
				break;
			}
		}
	}
	public void keyReleased(java.awt.event.KeyEvent e) {
		int key = e.getKeyCode();
		for (int isThisKey = 0; isThisKey < keys.length; isThisKey++) {
			if (keys[isThisKey] == key) {
				down[isThisKey] = false;
				action(isThisKey);
				break;
			}
		}
	}
	//empty
	public void keyTyped(java.awt.event.KeyEvent e) {}
	void action(int code) {
		if (code == 0) {
			cPos[1] += 1;
		} else if (code == 1) {
			cPos[1] -= 1;
		} else if (code == 2) {
			cPos[0] += 1;
		} else if (code == 3) {
			cPos[0] -= 1;
		}
	}
}
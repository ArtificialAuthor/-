//CFG 0
package game.windowTabs;
import game.SceneLoader;
import game.Window;
import game.windowTabs.apps.AppPhysics;
import game.objects.GameObject;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

//Class - Canvas, holds objects and more.
public class TabCanvas extends WindowTab implements Runnable{
	//CFG 1
	//Camera
	int FPSLimit = 30;
	//Sources
	ArrayList<GameObject> scene;
	public TabPause tabPause = new TabPause(this);
	//Controls
	MSC msc = new MSC();
	KC kc = new KC(this);
	
	
	//CFG 2
	public TabCanvas() {
		//Pre - settings
		setLayout(null);
		add(tabPause);
		
		//Loading scene
		scene = SceneLoader.getScene(0);
		
		//Launching cores
		new Thread(new AppPhysics()).start();
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
					(-obj.position[1] + kc.cPos[1]) * msc.cScale + Window.resolution.height/2,	
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
	TabCanvas attached;
	double[] cPos = {0, 0};
	GameObject cLock;
	boolean[] hldStates = {
		false, //Forward
		false, //Backward
		false, //Left
		false  //Right
	};
	int[] hld = { //Key codes, that can be held
		87,
		83,
		65,
		68
	};
	int[] tpd = { //Key codes, that can't be held
		27
	};
	
	//CFG 2
	public KC(TabCanvas attach) {
		attached = attach;
	}
	
	//CFG 3
	//HLD down & TPD
	public void keyPressed(java.awt.event.KeyEvent e) {
		int key = e.getKeyCode();
		for (int isIt = 0; isIt < hld.length; isIt++) {
			if (hld[isIt] == key) {
				hldStates[isIt] = true;
				action(isIt, true);
				return;
			}
		}
		for (int isIt = 0; isIt < tpd.length; isIt++) {
			if (tpd[isIt] == key) {
				action(isIt, false);
				return;
			}
		}
	}
	//HLD up
	public void keyReleased(java.awt.event.KeyEvent e) {
		int key = e.getKeyCode();
		for (int isIt = 0; isIt < hld.length; isIt++) {
			if (hld[isIt] == key) {
				hldStates[isIt] = false;
				action(isIt, true);
				return;
			}
		}
	}
	//empty
	public void keyTyped(java.awt.event.KeyEvent e) {}
	//Action
	void action(int code, boolean type) {
		if (type) {
			//HLD type
			if (code == 0) {
				cPos[1] += 1; //W
			} else if (code == 1) {
				cPos[1] -= 1; //S
			} else if (code == 2) {
				cPos[0] += 1; //D
			} else if (code == 3) {
				cPos[0] -= 1; //A
			}
		} else {
			//TPD type
			if (code == 0) {
				//ESC
				attached.tabPause.setVisible(AppPhysics.active);
				AppPhysics.active = !AppPhysics.active;
			}
		}
	}
}
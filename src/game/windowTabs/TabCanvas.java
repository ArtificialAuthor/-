//Код Artificial
//CFG 0
package game.windowTabs;
import game.Window;
import game.windowTabs.apps.AppPhysics;
import game.objects.*;
import game.objects.behavivours.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.lang.Math;
import javax.imageio.ImageIO;

//Класс - холст для обрисовки объектов
public class TabCanvas extends WindowTab{
	//CFG 1
	double cameraPosition[] = {0, 0};
	double cameraViewScale = 1;
	GameObject cameraLocked = null;
	AppPhysics physicsEngine = new AppPhysics(this);
	ArrayList<GameObject> scene = new ArrayList<GameObject>();
	BufferedImage background;
	public TabPause tabPause = new TabPause(this);
	
	//CFG 2
	public TabCanvas() {
		//Подготовка
		GameObject kek = new GameObject();
		scene.add(kek);
		kek.position[0] = 400;
		kek.position[1] = 400;
		kek.size[0] = 100;
		kek.size[1] = 100;
		//Запуск
		physicsEngine.start();
		addMouseWheelListener(new ListenScaling(this));
		addKeyListener(new ListenKeys(this));
		ListenMouse controllingMouse = new ListenMouse(this);

		addMouseListener(controllingMouse);
	}
	
	//CFG 3
	//Обрисовка
	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.clearRect(0,0,Window.resolution.width,Window.resolution.height);
		for (GameObject obj : scene) {
//			obj.rotation += .01d;
			int[] pointX = new int[obj.shape.a.length];
			int[] pointY = new int[obj.shape.a.length];
			for (int dot=0; dot<obj.shape.a.length; dot++){
				pointX[dot] = (int)(obj.position[0] + Math.cos(obj.shape.a[dot]+obj.rotation)*obj.shape.r[dot]*obj.size[0]);
				pointY[dot] = (int)(obj.position[1] + Math.sin(obj.shape.a[dot]+obj.rotation)*obj.shape.r[dot]*obj.size[1]);
			}
			g2.fillPolygon(pointX, pointY, pointX.length);
		}

	}


//CFG 4
//Слушатель мыши
class ListenMouse implements java.awt.event.MouseListener, Runnable {
	//CFG 1
	TabCanvas connectedWith;
	PhysicalBody connectedControls;
	boolean active = false;
	
	//CFG 2
	public ListenMouse(TabCanvas connectTo) {
		connectedWith = connectTo;
	}
	
	//CFG 3
	//Поток
	@Override
	public void run() {
		try {
			while(active) {
				double vec[] = {
					Window.resolution.width / 2 - MouseInfo.getPointerInfo().getLocation().x,
					Window.resolution.height / 2 - MouseInfo.getPointerInfo().getLocation().y
 				};
				double lng = Math.pow(vec[0] * vec[0] + vec[1] * vec[1], .5d);
				connectedControls.velocity[0] += vec[0] / lng / 100;
				connectedControls.velocity[1] += vec[1] / lng / 100;
				Thread.sleep(11);
			}
		} catch (InterruptedException e) {}
	}
	//Передать управление
	public void setControls(PhysicalBody setControls) {
		connectedControls = setControls;
	}
	//Тело
	public void mouseReleased(java.awt.event.MouseEvent e) {
		active = false;
	}
	public void mousePressed(java.awt.event.MouseEvent e) {
		active = true;
		new Thread(this).start();
	}
	public void mouseClicked(java.awt.event.MouseEvent e) {}
	public void mouseExited(java.awt.event.MouseEvent e) {}
	public void mouseEntered(java.awt.event.MouseEvent e) {}
}
//Слушатель масштабирования
class ListenScaling implements java.awt.event.MouseWheelListener {
	//CFG 1
	TabCanvas connectedWith;
	
	//CFG 2
	public ListenScaling(TabCanvas connectTo) {
		connectedWith = connectTo;
	}
	
	//CFG 3
	public void mouseWheelMoved(java.awt.event.MouseWheelEvent e) {
		double dir = -e.getUnitsToScroll() / 100d;
		if (dir < 0 & connectedWith.cameraViewScale + dir > 0) {
			connectedWith.cameraViewScale += dir;
		} else if (dir > 0 & connectedWith.cameraViewScale + dir < 4) {
			connectedWith.cameraViewScale += dir;
		}
	}
}
//Слушатель управления клавиатурой
class ListenKeys implements java.awt.event.KeyListener {
	//CFG 1
	TabCanvas connectedWith;
	
	//CFG 2
	public ListenKeys(TabCanvas connectTo) {
		connectedWith = connectTo; 
	}
	
	//CFG 3
	//Тело
	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		int code = e.getKeyCode();
		if (code == 27) {
			connectedWith.physicsEngine.stop();
			connectedWith.tabPause.setVisible(true);
		}
	}
	@Override
	public void keyReleased(java.awt.event.KeyEvent e) {}
	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {}
}
}
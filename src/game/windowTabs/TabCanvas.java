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
	int[] xPaint = {200,300,400,500};
	int[] yPoint = {300,250,350,550};
	int countPoint = 4;
	
	//CFG 2
	public TabCanvas() {
		//Подготовка
		GameObject kek = new GameObject();
		scene.add(kek);
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
		g2.drawImage(background, 0, 0, Window.resolution.width, Window.resolution.height, null);
		g2.fillPolygon(xPaint, yPoint, countPoint);
		//Задать координаты
		if (cameraLocked != null) {
			cameraPosition[0] = cameraLocked.position[0];
			cameraPosition[1] = cameraLocked.position[1];
		}
		//Рендеринг
		for (GameObject obj : scene) {
			int x = (int)((cameraPosition[0] - obj.position[0] - obj.size[0]/2) * cameraViewScale + Window.resolution.width / 2);
			int y = (int)((cameraPosition[1] - obj.position[1] - obj.size[1]/2) * cameraViewScale + Window.resolution.height / 2);
			if (
				//Фильтрация рендеринга
				x >= -obj.size[0] * cameraViewScale &
				y >= -obj.size[1] * cameraViewScale &
				x - obj.size[0] * cameraViewScale <= Window.resolution.width / 2 &
				y - obj.size[1] * cameraViewScale <= Window.resolution.height / 2
			) {
				int swapX = (int)((cameraPosition[0] - obj.position[0]) * cameraViewScale + Window.resolution.width / 2);
				int swapY = (int)((cameraPosition[1] - obj.position[1]) * cameraViewScale + Window.resolution.height / 2);
				g2.rotate(obj.rotation,
					swapX,
					swapY
				);
				if (obj.texture != null) {
					//У объекта есть текстура
					g2.drawImage(
						obj.texture,
						x,
						y,
						(int)(obj.size[1] * cameraViewScale),
						(int)(obj.size[0] * cameraViewScale),
						null
					);
				} else {
					//У объекта нет текстура
					g2.fillPolygon(obj.shape.dots[0], obj.shape.dots[1], obj.shape.dots.length);
				}
				g2.rotate(-obj.rotation,
					swapX,
					swapY
				);
			}
		}
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
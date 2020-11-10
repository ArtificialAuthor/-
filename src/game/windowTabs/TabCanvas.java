//Код Artificial
//CFG 0
package game.windowTabs;
import game.Window;
import game.windowTabs.apps.AppPhysics;
import game.objects.*;
import game.objects.behavivours.*;
import java.awt.Graphics;
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
	
	//CFG 2
	public TabCanvas() {
		//Подготовка
		setLayout(null);
		try {
			background = ImageIO.read(Window.class.getResource("sprites/background.png"));
		} catch (Exception e) {};
		
		//Объекты на сцене
		GameObject earth = new GameObject("earth");
		earth.size[0] = 640;
		earth.size[1] = 640;
		earth.setTexture("earth.png");
		scene.add(earth);
		
		GameObject player = new GameObject("player");
		PhysicalBody playerBody = new PhysicalBody();
		player.addBehavivour(playerBody);
		player.size[0] = 20;
		player.size[1] = 20;
		scene.add(player);
		physicsEngine.add(player);
		cameraLocked = player;
		
		//Запуск
		physicsEngine.start();
		addMouseWheelListener(new ListenScaling(this));
		ListenKeys controls = new ListenKeys(this);
		controls.setControls(playerBody);
		addKeyListener(controls);
	}
	
	//CFG 3
	//Обрисовка
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, Window.resolution.width, Window.resolution.height, null);
		//Задать координаты
		if (cameraLocked != null) {
			cameraPosition[0] = cameraLocked.position[0];
			cameraPosition[1] = cameraLocked.position[1];
		}
		//Рендеринг
		for (GameObject obj : scene) {
			if (
				//Фильтрация рендеринга
				(cameraPosition[0] - obj.position[0] + obj.size[0]/2) * cameraViewScale + Window.resolution.width / 2 >= 0 &
				(cameraPosition[1] - obj.position[1] + obj.size[1]/2) * cameraViewScale + Window.resolution.height / 2 >= 0 &
				(cameraPosition[0] - obj.position[0] - obj.size[0]) * cameraViewScale <= Window.resolution.width / 2 &
				(cameraPosition[1] - obj.position[1] - obj.size[1]) * cameraViewScale <= Window.resolution.height / 2
			) {
				if (obj.texture != null) {
					//У объекта есть текстура
					g.drawImage(
						obj.texture,
						(int)((cameraPosition[0] - obj.position[0] - obj.size[0]/2) * cameraViewScale + Window.resolution.width / 2),
						(int)((cameraPosition[1] - obj.position[1] - obj.size[1]/2) * cameraViewScale + Window.resolution.height / 2),
						(int)(obj.size[1] * cameraViewScale),
						(int)(obj.size[0] * cameraViewScale),
						null
					);
				} else {
					//У объекта нет текстура
					g.fillRect(
						(int)((cameraPosition[0] - obj.position[0] - obj.size[0]/2) * cameraViewScale + Window.resolution.width / 2),
						(int)((cameraPosition[1] - obj.position[1] - obj.size[1]/2) * cameraViewScale + Window.resolution.height / 2),
						(int)(obj.size[1] * cameraViewScale),
						(int)(obj.size[0] * cameraViewScale)
					);
				}
			}
		}
	}
}

//CFG 4
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
		connectedWith.cameraViewScale -= e.getUnitsToScroll() / 100d;
	}
}
//Лушатель управления
class ListenKeys implements java.awt.event.KeyListener {
	//CFG 1
	TabCanvas connectedWith;
	PhysicalBody relatedControls;
	
	//CFG 2
	public ListenKeys(TabCanvas connectTo) {
		connectedWith = connectTo; 
	}
	
	//CFG 3
	//Задать управляемый объект
	public void setControls(PhysicalBody setControls) {
		relatedControls = setControls;
	}
	//Тело
	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		int code = e.getKeyCode();
		if (code == 27) {
			connectedWith.physicsEngine.stop();
			Window.self.switchTab(0);
		} else {
			if (relatedControls != null) {
				if (code == 38){ //Вверх
					relatedControls.velocity[1] += 1/2d;
				} else if(code == 40) { //Вниз
					relatedControls.velocity[1] += -1/2d;
				} else if(code == 37) { //Влево
					relatedControls.velocity[0] += 1/2d;
				} else if(code == 39) { //Вправо
					relatedControls.velocity[0] += -1/2d;
				}
			}
		}
	}
	@Override
	public void keyReleased(java.awt.event.KeyEvent e) {
		
	}
	@Override
	public void keyTyped(java.awt.event.KeyEvent e) {
		
	}
}
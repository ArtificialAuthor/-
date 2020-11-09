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
		GameObject earth = new GameObject();
		earth.size[0] = 640;
		earth.size[1] = 640;
		try {earth.texture = ImageIO.read(Window.class.getResource("sprites/earth.png"));} catch (Exception e) {};
		System.out.println(earth.texture);
		add(earth);
		scene.add(earth);
		
		GameObject player = new GameObject("player");
		PhysicalBody playerBody = new PhysicalBody();
		playerBody.velocity[1] = -0.5d;
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
		g.drawImage(background.getScaledInstance(getWidth(), getHeight(), background.SCALE_FAST), 0, 0, null);
		//Прорисовка того, что в центре экрана
		try {
			cameraLocked.setBounds(
				(int)(Window.resolution.width - cameraLocked.size[0] * cameraViewScale) /2,
				(int)(Window.resolution.height - cameraLocked.size[1] * cameraViewScale) /2,
				(int)(cameraLocked.size[0] * cameraViewScale),
				(int)(cameraLocked.size[1] * cameraViewScale)
			);
			cameraPosition[0] = cameraLocked.position[0];
			cameraPosition[1] = cameraLocked.position[1];
		} catch (Exception e) {}
		//Прорисовка остального
		for (GameObject obj : scene) { 
			if (obj != cameraLocked) {
				obj.setBounds(
					(int)((obj.position[0] + cameraPosition[0] - obj.size[0]/2) * cameraViewScale + Window.resolution.width/2),
					(int)((obj.position[1] + cameraPosition[1] - obj.size[1]/2) * cameraViewScale + Window.resolution.height/2),
					(int)(obj.size[0] * cameraViewScale),
					(int)(obj.size[1] * cameraViewScale)
				);
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
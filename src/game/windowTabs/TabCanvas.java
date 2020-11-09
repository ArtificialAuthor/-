//��� Artificial
//�����������
package game.windowTabs;
import game.Window;
import game.windowTabs.apps.AppPhysics;
import game.objects.*;
import game.objects.behavivours.*;
import java.awt.Graphics;
import java.util.ArrayList;

//����� - ������� 
public class TabCanvas extends WindowTab{
	//CFG 1
	double cameraPosition[] = {0, 0};
	double cameraViewScale = 1;
	GameObject cameraLocked = null;
	AppPhysics physicsEngine = new AppPhysics(this);
	ArrayList<GameObject> scene = new ArrayList<GameObject>();
	
	//CFG 2
	public TabCanvas() {
		setLayout(null);
		
		//�����, ����� �������
		GameObject player = new GameObject("player");
		PhysicalBody playerBody = new PhysicalBody();
		playerBody.velocity[1] = -0.5d;
		player.addBehavivour(playerBody);
		player.size[0] = 20;
		player.size[1] = 20;
		scene.add(player);
		physicsEngine.add(player);
		cameraLocked = player;
		
		GameObject otherObj = new GameObject();
		otherObj.size[0] = 100;
		otherObj.size[1] = 100;
		otherObj.position[0] = 400;
		otherObj.position[1] = 400;
		add(otherObj);
		scene.add(otherObj);
		
		otherObj = new GameObject();
		otherObj.size[0] = 100;
		otherObj.size[1] = 100;
		otherObj.position[0] = -250;
		otherObj.position[1] = 450;
		add(otherObj);
		scene.add(otherObj);
		
		//�����������
		physicsEngine.start();
		addMouseWheelListener(new ListenScaling(this));
	}
	
	//CFG 3
	//���������
	@Override
	public void paintComponent(Graphics g) {
		g.clearRect(0, 0, Window.resolution.width, Window.resolution.height);
		//���������� ������� ������, �� ������� ������ ������
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
		//���������� ���������
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
//��������� ���������������
class ListenScaling implements java.awt.event.MouseWheelListener {
	//CFG 1
	TabCanvas connectedWith;
	
	//CFG 2
	public ListenScaling(TabCanvas connectTo) {
		connectedWith = connectTo;
	}
	
	//CFG 3
	//���� ���� ���������
	public void mouseWheelMoved(java.awt.event.MouseWheelEvent e) {
		connectedWith.cameraViewScale -= e.getUnitsToScroll() / 100d;
	}
}
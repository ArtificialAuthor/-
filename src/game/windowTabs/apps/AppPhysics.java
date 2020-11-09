//�����������
package game.windowTabs.apps;
import java.util.ArrayList;
import game.objects.GameObject;
import game.objects.behavivours.*;

//����� - ������� ������
public class AppPhysics implements Runnable {
	//CFG 1
	public boolean active = false;
	ArrayList<GameObject> scene = new ArrayList<GameObject>();
	int currentLng = 0;
	
	//CFG 3
	//���������� �����
	@Override
	public void run() {
		try {
			while (active) {
				Thread.sleep(10);
				//������ ����� ��� ����
				for (int objThis = 0; objThis < currentLng; objThis++) {
					//������� PhysicalBody
					try {
						PhysicalBody itsPhysicalBody = (PhysicalBody) scene.get(objThis).getBehavivour("PhysicalBody");
						itsPhysicalBody.doPhysicalTick();
					} catch (Exception e) {}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//�������� ������
	public void add(GameObject obj) {
		scene.add(obj);
		currentLng++;
	}
	//������� ������
	public void remove(GameObject obj) {
		scene.remove(obj);
		currentLng--;
	}
}
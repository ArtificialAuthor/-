//��� Artificial
//�����������
package game.objects.behavivours;

//����� - ��������� ����������� ����
public class PhysicalBody extends game.objects.Behavivour{
	//CFG 1
	public double velocity[] = {0, 0};
	public double angularVelocity = 0;
	
	//CFG 2
	public PhysicalBody() {
		ID = "PhysicalBody";
	}
	
	//CFG 3
	//������� ������
	public void doPhysicalTick() {
		attached.position[0] += velocity[0];
		attached.position[1] += velocity[1];
		attached.rotation += angularVelocity;
	}
}
//class�� interface�� ����� �� implements�� ����ؾ� �Ѵ�.
//implements�� Ŭ������ implements�� ������ �� ����ؾ� �Ѵ�.
public class Cadillac implements InterFace{
	public void Start() {
		System.out.println("Cadillac is starting now.");
	}
	
	public void Stop() {
		System.out.println("Cadillac is Stop now");
	}
	
	public void SetSpeed(int pSpeed) {
		System.out.println("Cadillac is changing speed to " + pSpeed + "miles/hour now");
	}
	
	public void Turn(int pDegree) {
		System.out.println("Cadillac is Turning " + pDegree + " degree now");
	}
}

//class�� interface�� ����� �� implements�� ����ؾ� �Ѵ�.
//implements�� Ŭ������ implements�� ������ �� ����ؾ� �Ѵ�.
public class BMW implements InterFace{
	public void Start() {
		System.out.println("BMW is starting now.");
	}
	
	public void Stop() {
		System.out.println("BMW is Stop now");
	}
	
	public void SetSpeed(int pSpeed) {
		System.out.println("BMW is changing speed to " + pSpeed + "miles/hour now");
	}
	
	public void Turn(int pDegree) {
		System.out.println("BMW is Turning " + pDegree + " degree now");
	}
}

//�������̽��� �̹� �����ϴ� Ŭ������ ���ؼ� implement Ű���带 ����Ͽ� �����ȴ�.
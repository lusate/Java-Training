//class가 interface를 사용할 땐 implements를 사용해야 한다.
//implements한 클래스는 implements의 내용을 다 사용해야 한다.
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

//class가 interface를 사용할 땐 implements를 사용해야 한다.
//implements한 클래스는 implements의 내용을 다 사용해야 한다.
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

//인터페이스는 이미 존재하는 클래스에 의해서 implement 키워드를 사용하여 구현된다.
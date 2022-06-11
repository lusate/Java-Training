
public interface InterFace {
	void Start(); //몸체가 없다
	void Stop();
	void SetSpeed(int pSpeed);
	void Turn(int pDegree);
}

/*
 인터페이스(Interface)
 서로 다른 장치들이 연결되어 데이터르 주고받는 규칙/규격을 의미한다.
 자바에서는 클래스 단위로 프로그램을 작성하므로 인터페이스를 클래스와 클래스 사이의 상호 작용의
 규칙/규격이라고 할 수 있다.
 인터페이스를 정의할 때는 interface 키워드를 사용한다.
 *멤버 변수는 선언될 수 없고 멤버 함수는 이름과 매개 변수만 존재하고, 몸체는 없다.
 인터페이스는 이미 존재하는 클래스에 의해서 implement 키워드를 사용하여 구현된다.
 어떤 클래스가 인터페이스를 사용하려면 인터페이스에 포함되어 있는 모든 인터페이스 메소드들을 구현해야 한다. 
 
 interface 인터페이스_이름{
 	void start();
 	void stop();
 }
 */
import java.util.*;
public class OLED extends Television{
	private int USB;
	private int HDMI;
	private boolean XBOX;
	
	//생성자 1번 - 매개변수 없는 생성자
	public OLED() {
		super(); //부모 클래스인 Television 클래스의 생성자 1번 사용
		//즉 super(); 이걸 통해서 부모 클래스의 매개변수 없는 생성자 1번이 작동한다.
		USB=2; 
		HDMI=3;
		XBOX=true;
	}
	//생성자 2번 - 매개변수가 있는 생성자
	public OLED(int pChannel, int pVolume, boolean pOnoff,//부모 클래스 TV의 매개변수들
			int pUSB, int pHDMI, boolean pXBOX) {//자식 클래스인 OLED의 매개변수 해서 총 6개
			super(pChannel, pVolume, pOnoff);//TV 생성자에서 생성자 #2 에서의 매개변수들을 호출함
			//super()는 부모 클래스의 생성자를 이용해서 초기화 하는데 사용한다. 
			USB = pUSB;
			HDMI = pHDMI;
			XBOX = pXBOX;
		}
	//USB, HDMI, XBOX 에 대해 멤버 함수 거쳐서 가도록 get, set 함수 만들어줌
	int getUSB() {
		return USB;
	}
	void setUSB(int pUSB) {//USB의 유효 범위 [0...5]
		if((pUSB >= 0) && (pUSB <= 5)) {
			USB = pUSB;
			System.out.println("USB has been changed to " + USB);
		}
		else System.out.println("USB can not be changed to " + pUSB + " because of out of range[0...5]");
	}
	int getHDMI() {
		return HDMI;
	}
	void setHDMI(int pHDMI) {
		if((pHDMI >= 0) && (pHDMI <= 10)) {
			HDMI = pHDMI;
			System.out.println("HDMI has been changed to " + HDMI);
		}
		else System.out.println("HDMI can not be changed to " + pHDMI + " because of out of range[0...10]");
	}
	boolean getXBOX() {
		return XBOX;
	}
	void setXBOX(boolean pXBOX) {
		XBOX = pXBOX;
		if(pXBOX == true) System.out.println("There exists XBOX port");
		else System.out.println("There is no XBOX port");
	}
	
	void PrintClassName() {
		System.out.println("Class Name = OLED");
	}
}
//
//메소드 오버라이딩 (Method Overriding)
//부모 클래스의 메소드 중에서 필요한 것을 자식 클래스에서 다시 정의하는 것이다.
//이 때, 메소드의 이름, 매개변수 개수, 자료형, 반환형은 동일해야하며, 단지 메소드
//내부의 내용만 달라야 한다.
//
//super를 사용하여 부모 클래스의 생성자를 접근
//super는 상속 관계에서 부모 클래스의 필드나 메소드를 참조하기 위해서 사용한다.
//특히, 부모 클래스의 생성자를 명시적으로 호출하기 위해서 사용한다. *
//즉 자식 ㅡㄹ래스가 부모 클래스로부터 상속받은 멤버를 참조할 때 사용하는 참조 변수이다. 부모 클래스와 자식 클래스의 멤버 이름이 같을 경우 super 사용

//상속과 생성자의 호출 순서
//부모 클래스의 생성자가 먼저 호출되고, 자식 클래스의 생성자가 나중에 호출된다.
//
//super을 사용하여 자식 클래스에서 명시적으로 부모 클래스의 생성자를 호출한다.
//
//오버로딩 : 같은 이름의 메서드 여러 개를 가지면서 매개변수의 유형과 개수가 다르도록 하는 기술
//기존에 없던 새로운 메서드를 정의하는 것이다.
import java.util.*;
public class OLED extends TV {//TV가 부모 OLED가 자식
	private int USB;	//USB 포트 갯수
	private int HDMI;	//HDMI 포트 갯수
	private boolean XBOX;//XBOX 단자 설치 여부
	
	//생성자 #1 - 매개변수가 없는 생성자
	public OLED() {
		super();	//부모인 TV 클래스의 생성자 #1인 TV가 호출된다.
		
		USB = 2;
		HDMI = 3;
		XBOX = true;
	}
	
	public OLED(int pChannel, int pVolume, boolean pOnOff,//부모 클래스 TV의 매개변수들
		int pUSB, int pHDMI, boolean pXBOX) {//자식 클래스인 OLED의 매개변수
		super(pChannel, pVolume, pOnOff);//TV 생성자에서 생성자 #2 에서의 매개변수들을 호출함
		
		USB = pUSB;
		HDMI = pHDMI;
		XBOX = pXBOX;
	}
	
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
	}//오버라이딩 덮어쓰기
	
}

/*
상속 (Inheritance)
상속은 기존에 존재하는 클래스로부터 데이터와 기능들을 물려받은 후에
자신이 필요한 데이터와 기능들을 추가하는 방법이다.

특정 클래스를 상속하려면
class 자식_클래스_이름 extends 부모_클래스_이름{

}
과 같이 자신의 클래스 이름 뒤에 extends 써주고 부모 클래스 이름을 적는다.

상속되는 것들
부모 클래스의 필드와 메소드가 자식 클래스로 상속된다.

자식 클래스는 부모 클래스의 필드와 메소드를 자유롭게 사용할 수 있다.

자식 클래스는 필요에 따라 자신만의 필드와 메소드를 추가할 수 있으며, 
부모 클래스에 이미 존재하는 메소드를 새롭게 정의하여 사용할 수 있다.

메소드 오버라이딩 (Method Overriding)
부모 클래스의 메소드 중에서 필요한 것을 자식 클래스에서 다시 정의하는 것이다.
이 때, 메소드의 이름, 매개변수 개수, 자료형, 반환형은 동일해야하며, 단지 메소드
내부의 내용만 달라야 한다.

super를 사용하여 부모 클래스의 생성자를 접근
super는 상속 관계에서 부모 클래스의 필드나 메소드를 참조하기 위해서 사용한다.
특히, 부모 클래스의 생성자를 명시적으로 호출하기 위해서 사용한다. *

상속과 생성자의 호출 순서
부모 클래스의 생성자가 먼저 호출되고, 자식 클래스의 생성자가 나중에 호출된다.

super을 사용하여 자식 클래스에서 명시적으로 부모 클래스의 생성자를 호출한다.

오버로딩 : 같은 이름의 메서드 여러 개를 가지면서 매개변수의 유형과 개수가 다르도록 하는 기술
기존에 없던 새로운 메서드를 정의하는 것이다.
*/
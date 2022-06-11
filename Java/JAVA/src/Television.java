import java.util.*;
public class Television implements Cloneable {
	protected int channel;	
	protected int volume;	
	protected boolean onoff;  

	//멤버 변수 channel의 값을 외부로 내보내주는 일을 한다.
	int getChannel() {	//channel에 대한 메서드 반환하는 channel 자료형이 				  정수형이므로 함수도 자료형이 정수형
		return channel;
	} //channel의 값을 그대로 내보내므로 매개변수가 필요없다.

	//외부로부터 값을 받아서 멤버변수 channel1에다 저장한다.
	//허용가능 범위는 [0..50]
	void setChannel(int pChannel){//(return) 돌려줄게 없으므로 void, 외부로부터 값을 받아와서 그 값을 넣어줘야하므로 매개변수가 필요하다.
		//정상적인 허용범위 [0...50] 안에 들어있는 경우, 변경한다

		if((pChannel>=0) && (pChannel <= 50)) {
		channel = pChannel;	//pChannel 값을 channel에 세팅해준다.
		System.out.println("Channel has been changed to " + channel);
		}
	}
	
	//멤버변수 volume의 값을 외부로 내보내주는 역할을 한다.
	int getVolume() {
		return volume;
	}
	//외부로부터 값을 받아서 멤버변수 volume에다 저장한다.
	//허용가능 범위는  [0...100]
	void setVolume (int pVolume){
		if((pVolume <= 100) && (pVolume >= 0)) {
		volume = pVolume;	//외부에서 넣어주는 값으로 세팅
		System.out.println("Volume has been changed to " + volume);
		}
	}
	//멤버변수 onoff의 값을 외부로 내보내주는 일을 한다
	boolean getOnoff() {
		return onoff;
	}
	//외부로부터 값을 받아서 멤버변수 onoff에다 저장한다.
	void setOnoff(boolean ponoff) {
		onoff = ponoff;
		if(ponoff == true) System.out.println("OnOff has been changed to On");
		else System.out.println("OnOff has been changed to Off");
	}
	//복사생성자 문제를 해결하기 위한 clone() 멤버함수
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}

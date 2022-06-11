package sefd;

public class TV implements Cloneable {
	private int channel;
	private int volume;
	private boolean onoff;
	
	//생성자 #1 : 매개변수가 없는 생성자
	//생성자의 이름은 클래스의 이름과 같다.
	TV(){//생성자가 매개변수를 가지지 않는 경우 생성자 안에서 필드의 값 지정
		channel = 10;
		volume = 20;
		onoff = true;
	}/*위 아래 다 매개변수가 없다면 둘 중 어떤것을 실행해야 하는지 알 수가 없으므로
		44분
	*/
	
	//생성자 #2 : 매개변수가 있는 생성자
	TV(int pChannel, int pVolume, boolean pOnOff){
		channel = pChannel;
		volume = pVolume;
		onoff = pOnOff;
	}
	
	//멤버변수 channel의 값을 외부로 내보내주는 일을 한다.
	int GetChannel() {
		return channel;
	}

	void SetChannel(int pChannel){//(return) 돌려줄게 없으므로 void, 외부로부터 값을 받아와서 그 값을 넣어줘야하므로 매개변수가 필요하다.
		//정상적인 허용범위 [0...50] 안에 들어있는 경우, 변경한다

		if((pChannel>=0) && (pChannel <= 50)) {
		channel = pChannel;	//pChannel 값을 channel에 세팅해준다.
		System.out.println("Channel has been changed to " + channel);
		}
		else {
			System.out.println("Channel can not be changed to " + pChannel + "because of out of range[0...50]");
		}
	}
	
	//멤버변수 volume의 값을 외부로 내보내주는 역할을 한다.
	int GetVolume() {
		return volume;
	}
	//외부로부터 값을 받아서 멤버변수 volume에다 저장한다.
	//허용가능 범위는  [0...100]
	void SetVolume (int pVolume){
		if((pVolume <= 100) && (pVolume >= 0)) {
		volume = pVolume;	//외부에서 넣어주는 값으로 세팅
		System.out.println("Volume has been changed to " + volume);
		}
		else {
			System.out.println("Volume can not be changed to " + pVolume + "because of range of [0...100]");
		}
	}
	//멤버변수 onoff의 값을 외부로 내보내주는 일을 한다
	boolean GetOnOff() {
		return onoff;
	}
	//외부로부터 값을 받아서 멤버변수 onoff에다 저장한다.
	void SetOnOff(boolean pOnOff) {
			onoff = pOnOff;
			if(pOnOff == true) System.out.println("OnOff has been changed to On");
			else System.out.println("OnOff has been changed to Off");
	}
	void IncreaseNumber(TV x){
			x.channel = x.channel + 1;
	}//값이 온거
	void IncreaseVolume(TV tv) {
		tv.volume = tv.volume+1;
	}//객체가 온거
	

	
	
	TV WhoseVolumeIsLargerThanOrEqualTo(TV tv1, TV tv2){
		TV tv3;
		
		if(tv1.GetVolume() > tv2.GetVolume()) tv3 = tv1;
		else tv3 = tv2;
		
		return tv3;	//메소드 안에서 return 문을 사용하여 객체를 반환한다.
	}
}

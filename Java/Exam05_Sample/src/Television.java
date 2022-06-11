
public class Television implements Cloneable{
	protected int channel;	//protected로 선언 해줘야 부모클래스를 사용할 수 있다.
	protected int volume;	
	protected boolean onoff;
	
	Television(){//매개변수가 없는 생성자 1번
		channel=10;
		volume=20;
		onoff=false;
	}
	
	Television(int pChannel, int pVolume, boolean pOnoff){
		channel=pChannel;
		volume=pVolume;
		onoff=pOnoff;
	}
	 
	int getChannel() {
		return channel;
	}

	void setChannel(int pChannel) {
		if((pChannel>=0)&&(pChannel<=50)) {
			channel = pChannel;
			System.out.println("Channel has been changed to " + pChannel);
		}
		else {
			System.out.println("Channel can not be changed to " + pChannel + " because of out of range [0...50]");
		}
	}

	int getVolume() {
		return volume;
	}

	void setVolume(int pVolume) {
		if((pVolume>=0)&&(pVolume<=100)) {
			volume = pVolume;
			System.out.println("Channel has been changed to " + pVolume);
		}
		else {
			System.out.println("Volume can not be changed to " + pVolume + " because of out of range [0...100]");
		}
	}

	boolean getOnoff() {
		return onoff;
	}

	void setOnoff(boolean pOnoff) {
		onoff = pOnoff;
	}
	
	void IncreaseNumber(int x) {
		x = x + 1;
	}//값을 보낸 경우
	
	void IncreaseChannel(Television y) {
		y.channel = y.channel + 1;
	}

	Television WhoseVolumeIsLargerOrEqualTo(Television x, Television y) {// 객체를 보내는 방법
		Television z;
		if(x.getVolume() >= y.getVolume()) {
			z = x;
		}
		else z = y; //객체를 넣어줌
		return z;
	}
	
	void PrintClassName(){
		System.out.println("Class Name = Television");
	}
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	//객체는 포인터라는 주소개념인데 저렇게 하면 메모리에 같은 공간을 가리키게 된다 따라서 LG도 자동으로 수정되므로 잘못 된 것이다
}

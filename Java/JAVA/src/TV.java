public class TV implements Cloneable{
	int channel;
	int volume;
	boolean onoff;
	
	//생성자 #1 : 매개변수가 없는 생성자
	TV(){
		channel = 10;
		volume = 20;
		onoff = true;
	}
	
	//생성자 #2 : 매개변수가 있는 생성자
		TV(int pChannel, int pVolume, boolean pOnOff){
			channel = pChannel;
			volume = pVolume;
			onoff = pOnOff;
		}
	
	int getchannel() {
		return channel;
	}
	
	void setChannel(int pChannel) {
		if((pChannel>=0) && (pChannel<=50)) {
			channel = pChannel;
			System.out.println("Channel has been changed to " + channel);
		}
		else {
			System.out.println("Channel can not be changed to " + pChannel + "because of out of range[0...50]");
		}
	}
	
	int getVolume() {
		return volume;
	}
	
	void setVolume(int pVolume) {
		if((pVolume <= 100) && (pVolume>=0)) {
			volume = pVolume;
			System.out.println("Volume has been changed to " + volume);
		}
		else {
			System.out.println("Volume can not be changed to " + pVolume + "because of range of [0..100]");
		}
	}
	
	boolean getOnoff() {
		return onoff;
	}
	void setOnoff(boolean ponoff) {
		onoff = ponoff;
		if(ponoff == true) System.out.println("OnOff has been changed to On");
		else System.out.println("OnOff has been changed to Off");
	}
	
	void PrintClassName(){
		System.out.println("Class Name = TV");
	}
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
/*
clone() : 어떤 객체가 있을 때 그 객체와 똑같은 객체를 복제해주는 기능이 clone 메소드의 역할
EX)
class Student implements Cloneable{
	Student라고 하는 클래스가 복제 가능한 클래스라는 것을 알려주기 위한 구분자의 역할을 한다.
}

throws CloneNotSupportedException : 복사생성자의 문제를 위한 예외 처리를 하기 위한 것
*/
public class TV implements Cloneable{
	int channel;
	int volume;
	boolean onoff;
	
	//������ #1 : �Ű������� ���� ������
	TV(){
		channel = 10;
		volume = 20;
		onoff = true;
	}
	
	//������ #2 : �Ű������� �ִ� ������
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
clone() : � ��ü�� ���� �� �� ��ü�� �Ȱ��� ��ü�� �������ִ� ����� clone �޼ҵ��� ����
EX)
class Student implements Cloneable{
	Student��� �ϴ� Ŭ������ ���� ������ Ŭ������� ���� �˷��ֱ� ���� �������� ������ �Ѵ�.
}

throws CloneNotSupportedException : ����������� ������ ���� ���� ó���� �ϱ� ���� ��
*/
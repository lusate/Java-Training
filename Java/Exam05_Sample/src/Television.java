
public class Television implements Cloneable{
	protected int channel;	//protected�� ���� ����� �θ�Ŭ������ ����� �� �ִ�.
	protected int volume;	
	protected boolean onoff;
	
	Television(){//�Ű������� ���� ������ 1��
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
	}//���� ���� ���
	
	void IncreaseChannel(Television y) {
		y.channel = y.channel + 1;
	}

	Television WhoseVolumeIsLargerOrEqualTo(Television x, Television y) {// ��ü�� ������ ���
		Television z;
		if(x.getVolume() >= y.getVolume()) {
			z = x;
		}
		else z = y; //��ü�� �־���
		return z;
	}
	
	void PrintClassName(){
		System.out.println("Class Name = Television");
	}
	
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	//��ü�� �����Ͷ�� �ּҰ����ε� ������ �ϸ� �޸𸮿� ���� ������ ����Ű�� �ȴ� ���� LG�� �ڵ����� �����ǹǷ� �߸� �� ���̴�
}

package sefd;

public class TV implements Cloneable {
	private int channel;
	private int volume;
	private boolean onoff;
	
	//������ #1 : �Ű������� ���� ������
	//�������� �̸��� Ŭ������ �̸��� ����.
	TV(){//�����ڰ� �Ű������� ������ �ʴ� ��� ������ �ȿ��� �ʵ��� �� ����
		channel = 10;
		volume = 20;
		onoff = true;
	}/*�� �Ʒ� �� �Ű������� ���ٸ� �� �� ����� �����ؾ� �ϴ��� �� ���� �����Ƿ�
		44��
	*/
	
	//������ #2 : �Ű������� �ִ� ������
	TV(int pChannel, int pVolume, boolean pOnOff){
		channel = pChannel;
		volume = pVolume;
		onoff = pOnOff;
	}
	
	//������� channel�� ���� �ܺη� �������ִ� ���� �Ѵ�.
	int GetChannel() {
		return channel;
	}

	void SetChannel(int pChannel){//(return) �����ٰ� �����Ƿ� void, �ܺηκ��� ���� �޾ƿͼ� �� ���� �־�����ϹǷ� �Ű������� �ʿ��ϴ�.
		//�������� ������ [0...50] �ȿ� ����ִ� ���, �����Ѵ�

		if((pChannel>=0) && (pChannel <= 50)) {
		channel = pChannel;	//pChannel ���� channel�� �������ش�.
		System.out.println("Channel has been changed to " + channel);
		}
		else {
			System.out.println("Channel can not be changed to " + pChannel + "because of out of range[0...50]");
		}
	}
	
	//������� volume�� ���� �ܺη� �������ִ� ������ �Ѵ�.
	int GetVolume() {
		return volume;
	}
	//�ܺηκ��� ���� �޾Ƽ� ������� volume���� �����Ѵ�.
	//��밡�� ������  [0...100]
	void SetVolume (int pVolume){
		if((pVolume <= 100) && (pVolume >= 0)) {
		volume = pVolume;	//�ܺο��� �־��ִ� ������ ����
		System.out.println("Volume has been changed to " + volume);
		}
		else {
			System.out.println("Volume can not be changed to " + pVolume + "because of range of [0...100]");
		}
	}
	//������� onoff�� ���� �ܺη� �������ִ� ���� �Ѵ�
	boolean GetOnOff() {
		return onoff;
	}
	//�ܺηκ��� ���� �޾Ƽ� ������� onoff���� �����Ѵ�.
	void SetOnOff(boolean pOnOff) {
			onoff = pOnOff;
			if(pOnOff == true) System.out.println("OnOff has been changed to On");
			else System.out.println("OnOff has been changed to Off");
	}
	void IncreaseNumber(TV x){
			x.channel = x.channel + 1;
	}//���� �°�
	void IncreaseVolume(TV tv) {
		tv.volume = tv.volume+1;
	}//��ü�� �°�
	

	
	
	TV WhoseVolumeIsLargerThanOrEqualTo(TV tv1, TV tv2){
		TV tv3;
		
		if(tv1.GetVolume() > tv2.GetVolume()) tv3 = tv1;
		else tv3 = tv2;
		
		return tv3;	//�޼ҵ� �ȿ��� return ���� ����Ͽ� ��ü�� ��ȯ�Ѵ�.
	}
}

public class TV implements Cloneable {
	int channel;	//ä�� ��ȣ
	int volume;	//���� ũ��
	boolean onoff;  //���� ����

	//��� ���� channel�� ���� �ܺη� �������ִ� ���� �Ѵ�.
	int GetChannel() {	//channel�� ���� �޼��� ��ȯ�ϴ� channel �ڷ����� 				  �������̹Ƿ� �Լ��� �ڷ����� ������
		return channel;
	} //channel�� ���� �״�� �������Ƿ� �Ű������� �ʿ����.

	//�ܺηκ��� ���� �޾Ƽ� ������� channel1���� �����Ѵ�.
	//��밡�� ������ [0..50]
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
	boolean GetOnoff() {
		return onoff;
	}
	//�ܺηκ��� ���� �޾Ƽ� ������� onoff���� �����Ѵ�.
	void setOnoff(boolean pOnoff) {
		onoff = pOnoff;
		if(pOnoff == true) System.out.println("OnOff has been changed to On");
		else System.out.println("OnOff has been changed to Off");
	}
	
}

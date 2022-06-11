import java.util.*;
public class Television implements Cloneable {
	protected int channel;	
	protected int volume;	
	protected boolean onoff;  

	//��� ���� channel�� ���� �ܺη� �������ִ� ���� �Ѵ�.
	int getChannel() {	//channel�� ���� �޼��� ��ȯ�ϴ� channel �ڷ����� 				  �������̹Ƿ� �Լ��� �ڷ����� ������
		return channel;
	} //channel�� ���� �״�� �������Ƿ� �Ű������� �ʿ����.

	//�ܺηκ��� ���� �޾Ƽ� ������� channel1���� �����Ѵ�.
	//��밡�� ������ [0..50]
	void setChannel(int pChannel){//(return) �����ٰ� �����Ƿ� void, �ܺηκ��� ���� �޾ƿͼ� �� ���� �־�����ϹǷ� �Ű������� �ʿ��ϴ�.
		//�������� ������ [0...50] �ȿ� ����ִ� ���, �����Ѵ�

		if((pChannel>=0) && (pChannel <= 50)) {
		channel = pChannel;	//pChannel ���� channel�� �������ش�.
		System.out.println("Channel has been changed to " + channel);
		}
	}
	
	//������� volume�� ���� �ܺη� �������ִ� ������ �Ѵ�.
	int getVolume() {
		return volume;
	}
	//�ܺηκ��� ���� �޾Ƽ� ������� volume���� �����Ѵ�.
	//��밡�� ������  [0...100]
	void setVolume (int pVolume){
		if((pVolume <= 100) && (pVolume >= 0)) {
		volume = pVolume;	//�ܺο��� �־��ִ� ������ ����
		System.out.println("Volume has been changed to " + volume);
		}
	}
	//������� onoff�� ���� �ܺη� �������ִ� ���� �Ѵ�
	boolean getOnoff() {
		return onoff;
	}
	//�ܺηκ��� ���� �޾Ƽ� ������� onoff���� �����Ѵ�.
	void setOnoff(boolean ponoff) {
		onoff = ponoff;
		if(ponoff == true) System.out.println("OnOff has been changed to On");
		else System.out.println("OnOff has been changed to Off");
	}
	//��������� ������ �ذ��ϱ� ���� clone() ����Լ�
	protected Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}

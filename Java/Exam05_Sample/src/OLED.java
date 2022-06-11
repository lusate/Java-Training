import java.util.*;
public class OLED extends Television{
	private int USB;
	private int HDMI;
	private boolean XBOX;
	
	//������ 1�� - �Ű����� ���� ������
	public OLED() {
		super(); //�θ� Ŭ������ Television Ŭ������ ������ 1�� ���
		//�� super(); �̰� ���ؼ� �θ� Ŭ������ �Ű����� ���� ������ 1���� �۵��Ѵ�.
		USB=2; 
		HDMI=3;
		XBOX=true;
	}
	//������ 2�� - �Ű������� �ִ� ������
	public OLED(int pChannel, int pVolume, boolean pOnoff,//�θ� Ŭ���� TV�� �Ű�������
			int pUSB, int pHDMI, boolean pXBOX) {//�ڽ� Ŭ������ OLED�� �Ű����� �ؼ� �� 6��
			super(pChannel, pVolume, pOnoff);//TV �����ڿ��� ������ #2 ������ �Ű��������� ȣ����
			//super()�� �θ� Ŭ������ �����ڸ� �̿��ؼ� �ʱ�ȭ �ϴµ� ����Ѵ�. 
			USB = pUSB;
			HDMI = pHDMI;
			XBOX = pXBOX;
		}
	//USB, HDMI, XBOX �� ���� ��� �Լ� ���ļ� ������ get, set �Լ� �������
	int getUSB() {
		return USB;
	}
	void setUSB(int pUSB) {//USB�� ��ȿ ���� [0...5]
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
	}
}
//
//�޼ҵ� �������̵� (Method Overriding)
//�θ� Ŭ������ �޼ҵ� �߿��� �ʿ��� ���� �ڽ� Ŭ�������� �ٽ� �����ϴ� ���̴�.
//�� ��, �޼ҵ��� �̸�, �Ű����� ����, �ڷ���, ��ȯ���� �����ؾ��ϸ�, ���� �޼ҵ�
//������ ���븸 �޶�� �Ѵ�.
//
//super�� ����Ͽ� �θ� Ŭ������ �����ڸ� ����
//super�� ��� ���迡�� �θ� Ŭ������ �ʵ峪 �޼ҵ带 �����ϱ� ���ؼ� ����Ѵ�.
//Ư��, �θ� Ŭ������ �����ڸ� ��������� ȣ���ϱ� ���ؼ� ����Ѵ�. *
//�� �ڽ� �Ѥ������� �θ� Ŭ�����κ��� ��ӹ��� ����� ������ �� ����ϴ� ���� �����̴�. �θ� Ŭ������ �ڽ� Ŭ������ ��� �̸��� ���� ��� super ���

//��Ӱ� �������� ȣ�� ����
//�θ� Ŭ������ �����ڰ� ���� ȣ��ǰ�, �ڽ� Ŭ������ �����ڰ� ���߿� ȣ��ȴ�.
//
//super�� ����Ͽ� �ڽ� Ŭ�������� ��������� �θ� Ŭ������ �����ڸ� ȣ���Ѵ�.
//
//�����ε� : ���� �̸��� �޼��� ���� ���� �����鼭 �Ű������� ������ ������ �ٸ����� �ϴ� ���
//������ ���� ���ο� �޼��带 �����ϴ� ���̴�.
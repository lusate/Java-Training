import java.util.*;
public class OLED extends TV {//TV�� �θ� OLED�� �ڽ�
	private int USB;	//USB ��Ʈ ����
	private int HDMI;	//HDMI ��Ʈ ����
	private boolean XBOX;//XBOX ���� ��ġ ����
	
	//������ #1 - �Ű������� ���� ������
	public OLED() {
		super();	//�θ��� TV Ŭ������ ������ #1�� TV�� ȣ��ȴ�.
		
		USB = 2;
		HDMI = 3;
		XBOX = true;
	}
	
	public OLED(int pChannel, int pVolume, boolean pOnOff,//�θ� Ŭ���� TV�� �Ű�������
		int pUSB, int pHDMI, boolean pXBOX) {//�ڽ� Ŭ������ OLED�� �Ű�����
		super(pChannel, pVolume, pOnOff);//TV �����ڿ��� ������ #2 ������ �Ű��������� ȣ����
		
		USB = pUSB;
		HDMI = pHDMI;
		XBOX = pXBOX;
	}
	
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
	}//�������̵� �����
	
}

/*
��� (Inheritance)
����� ������ �����ϴ� Ŭ�����κ��� �����Ϳ� ��ɵ��� �������� �Ŀ�
�ڽ��� �ʿ��� �����Ϳ� ��ɵ��� �߰��ϴ� ����̴�.

Ư�� Ŭ������ ����Ϸ���
class �ڽ�_Ŭ����_�̸� extends �θ�_Ŭ����_�̸�{

}
�� ���� �ڽ��� Ŭ���� �̸� �ڿ� extends ���ְ� �θ� Ŭ���� �̸��� ���´�.

��ӵǴ� �͵�
�θ� Ŭ������ �ʵ�� �޼ҵ尡 �ڽ� Ŭ������ ��ӵȴ�.

�ڽ� Ŭ������ �θ� Ŭ������ �ʵ�� �޼ҵ带 �����Ӱ� ����� �� �ִ�.

�ڽ� Ŭ������ �ʿ信 ���� �ڽŸ��� �ʵ�� �޼ҵ带 �߰��� �� ������, 
�θ� Ŭ������ �̹� �����ϴ� �޼ҵ带 ���Ӱ� �����Ͽ� ����� �� �ִ�.

�޼ҵ� �������̵� (Method Overriding)
�θ� Ŭ������ �޼ҵ� �߿��� �ʿ��� ���� �ڽ� Ŭ�������� �ٽ� �����ϴ� ���̴�.
�� ��, �޼ҵ��� �̸�, �Ű����� ����, �ڷ���, ��ȯ���� �����ؾ��ϸ�, ���� �޼ҵ�
������ ���븸 �޶�� �Ѵ�.

super�� ����Ͽ� �θ� Ŭ������ �����ڸ� ����
super�� ��� ���迡�� �θ� Ŭ������ �ʵ峪 �޼ҵ带 �����ϱ� ���ؼ� ����Ѵ�.
Ư��, �θ� Ŭ������ �����ڸ� ��������� ȣ���ϱ� ���ؼ� ����Ѵ�. *

��Ӱ� �������� ȣ�� ����
�θ� Ŭ������ �����ڰ� ���� ȣ��ǰ�, �ڽ� Ŭ������ �����ڰ� ���߿� ȣ��ȴ�.

super�� ����Ͽ� �ڽ� Ŭ�������� ��������� �θ� Ŭ������ �����ڸ� ȣ���Ѵ�.

�����ε� : ���� �̸��� �޼��� ���� ���� �����鼭 �Ű������� ������ ������ �ٸ����� �ϴ� ���
������ ���� ���ο� �޼��带 �����ϴ� ���̴�.
*/
package sefd;
import java.util.*;
public class M_C_Example {
	public static void main(String[] args) throws CloneNotSupportedException{
		Scanner input = new Scanner(System.in);
		
		TV SStv = new TV();	// ������ #1 ���
		TV LGtv = new TV(15,25,false);	//������ #2 ���
		
		int x = 10;
		
		System.out.println("SStv:");
		System.out.println("Channel Number = " + SStv.GetChannel());
		System.out.println("Volume = " + + SStv.GetVolume());
		if(SStv.GetOnOff() == true) System.out.println("Power is on now");
		if(SStv.GetOnOff() == false) System.out.println("Power is off now");
		System.out.println();
		
		System.out.println("LGtv:");
		System.out.println("Channel Number = " + LGtv.GetChannel());
		System.out.println("Volume = " + + LGtv.GetVolume());
		if(LGtv.GetOnOff() == true) System.out.println("Power is on now");
		if(LGtv.GetOnOff() == false) System.out.println("Power is off now");
		System.out.println();
		System.out.println();
		System.out.println("------------------------------------");
		
		
		System.out.println("Before calling the function, x = " + LGtv.GetChannel());
		SStv.IncreaseNumber(LGtv);
		System.out.println("After calling the function, x = " + LGtv.GetChannel());
		System.out.println();
		
		//call by reference ���·� �Լ��� ȣ���� ���
		//��ü�� ���޵ǹǷ� ������ �ȴ�
		System.out.println("Before SStv volume = " + SStv.GetVolume());
		SStv.IncreaseVolume(SStv);
		System.out.println("After SStv volume = " + SStv.GetVolume());
		
	}
}
//���� ������ : Ŭ������ ��ü�� ������ �� �̹� �����ϴ� ���� Ŭ������ �ٸ� ��ü�� �״��
//			�����ϱ� ���� �ʿ���

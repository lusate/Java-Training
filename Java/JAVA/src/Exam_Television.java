import java.util.*;
public class Exam_Television {

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner input = new Scanner(System.in);
		
		Television SStv = new Television(); 
		
		SStv.channel = 10;
		SStv.volume = 20;
		SStv.onoff = false;
		
		
		System.out.println("SStv: ");
		System.out.println("Channel Number = " + SStv.channel);
		//System.out.println("Volume = " + SStv.volume);
		System.out.println("Volume = " + SStv.getVolume());
		//if(SStv.onoff == true)
		if(SStv.getOnoff() == true)
		System.out.println("Power is on now");
		//if(SStv.onoff == false)
		if(SStv.getOnoff() == false)
		System.out.println("Power off on now");
		System.out.println();
		//Television LGtv = SStv; //�̰� ����
				Television LGtv = (Television) SStv.clone();

		System.out.println("LGtv: ");
		//System.out.println("Channel Number = " + LGtv.channel);
		System.out.println("Channel Number = " + LGtv.getChannel());
		//System.out.println("Volume = " + LGtv.volume);
		System.out.println("Volume = " + LGtv.getVolume());
		//if(SStv.onoff == true)
		if(LGtv.getOnoff() == true)
		System.out.println("Power is on now");
		//if(SStv.onoff == false)
		if(LGtv.getOnoff() == false)
		System.out.println("Power off on now");
		System.out.println();

		
		//6���� SStv �Ŀ� SStv�� ��� ���� ������ �����ؾ� �ϴ� ��찡 �߻��ߴ�.

		SStv.channel = 110;
		SStv.volume = 120;
		SStv.onoff = true;
 
		System.out.println("Modification After 6 months ... ");
		System.out.println("SStv: ");
		System.out.println("Channel Number = " + SStv.channel);
		//System.out.println("Volume = " + SStv.volume);
		System.out.println("Volume = " + SStv.getVolume());
		//if(SStv.onoff == true)
		if(SStv.getOnoff() == true)
		System.out.println("Power is on now");
		//if(SStv.onoff == false)
		if(SStv.getOnoff() == false)
		System.out.println("Power off on now");
		System.out.println();


		//�� 6���� ����
		System.out.println("Channel Number = " + SStv.channel);
		System.out.println("Volume = " + SStv.getVolume());
		if(SStv.getOnoff() == true)
		System.out.println("Power is on now");
		if(SStv.getOnoff() == false)
		System.out.println("Power is off now");
		System.out.println();
	}

}
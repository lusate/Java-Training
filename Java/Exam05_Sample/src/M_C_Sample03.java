import java.util.Scanner;
public class M_C_Sample03 {

	public static void main(String[] args) throws CloneNotSupportedException{
		Scanner input = new Scanner(System.in);
		
		Television SStv = new Television();  //�Ű����� ���� ������
		Television LGtv = new Television(15,25,true);	//�Ű� ���� �ִ� ������
		int x = 100;
		Television z;
		
		System.out.println("SStv : ");
		System.out.println("Channel = " + SStv.getChannel());
		System.out.println("Volume = " + SStv.getVolume());
		
		System.out.println();
		
		System.out.println("Channel = " + LGtv.getChannel());
		System.out.println("Volume = " + LGtv.getVolume());
		
		System.out.println();
		System.out.println("x1 = " + x);
		SStv.IncreaseNumber(x);
		System.out.println("x2 = " + x); //call by value
		//�̶��� x�� ������� 101�� ���� �ʴ´�. 
		
		System.out.println();
		System.out.println("LGtv: Channel2 = " + LGtv.getChannel());
		LGtv.IncreaseChannel(LGtv);	//call by reference (�ּҷ� ����)
		System.out.println("LGtv: Channel2 = " + LGtv.getChannel());
		
		z = SStv.WhoseVolumeIsLargerOrEqualTo(SStv, LGtv);
		
		if(z==SStv) {
			System.out.println("Volume of SStv is larger or equal to LGtv");
		}
		if(z==LGtv) {
			System.out.println("Volume of LGtv is larger or equal to SStv");
		}
	}
}

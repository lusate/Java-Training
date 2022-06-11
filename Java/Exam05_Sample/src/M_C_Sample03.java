import java.util.Scanner;
public class M_C_Sample03 {

	public static void main(String[] args) throws CloneNotSupportedException{
		Scanner input = new Scanner(System.in);
		
		Television SStv = new Television();  //매개변수 없는 생성자
		Television LGtv = new Television(15,25,true);	//매개 변수 있는 생성자
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
		//이때는 x의 결과값이 101이 되지 않는다. 
		
		System.out.println();
		System.out.println("LGtv: Channel2 = " + LGtv.getChannel());
		LGtv.IncreaseChannel(LGtv);	//call by reference (주소로 보냄)
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

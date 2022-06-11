package sefd;
import java.util.*;
public class M_C_Example {
	public static void main(String[] args) throws CloneNotSupportedException{
		Scanner input = new Scanner(System.in);
		
		TV SStv = new TV();	// 생성자 #1 사용
		TV LGtv = new TV(15,25,false);	//생성자 #2 사용
		
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
		
		//call by reference 형태로 함수를 호출한 경우
		//객체가 전달되므로 수정이 된다
		System.out.println("Before SStv volume = " + SStv.GetVolume());
		SStv.IncreaseVolume(SStv);
		System.out.println("After SStv volume = " + SStv.GetVolume());
		
	}
}
//복사 생성자 : 클래스의 객체를 생성할 때 이미 존재하는 동일 클래스의 다른 객체를 그대로
//			복사하기 위해 필요함

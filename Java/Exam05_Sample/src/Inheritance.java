import java.util.Scanner;
public class Inheritance {

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner input = new Scanner(System.in);
		
		Television SStv = new Television(); 
		Television LGtv = new Television(10, 25, false);
		
		OLED HDtv = new OLED();//매개변수 없으므로 생성자 #1을 호출
		OLED SKtv = new OLED(17, 27, false, 4, 5, true);
		
		System.out.println("HDtv : ");
		System.out.println("Channel Number = " + HDtv.getChannel());
		System.out.println("Channel Volume = " + HDtv.getVolume());
		System.out.println("Number of USB = " + HDtv.getUSB());
		System.out.println("Number of HDMI port = " + HDtv.getHDMI());
		HDtv.PrintClassName();//오버라이딩 덮어쓰기
		
		System.out.println("SKtv : ");
		System.out.println("Channel Number = " + SKtv.getChannel());
		System.out.println("Channel Volume = " + SKtv.getVolume());
		SKtv.setUSB(-2);
		System.out.println("Number of USB = " + SKtv.getUSB());
		SKtv.setHDMI(-5);
		System.out.println("Number of HDMI port = " + SKtv.getHDMI());
		SKtv.PrintClassName();
		
		System.out.println();
		System.out.println("SStv : ");
		SStv.PrintClassName();
		
		System.out.println("LGtv : ");
		LGtv.PrintClassName();
		
		System.out.println();
		System.out.println("----------------------------------------------");
		
		System.out.println(HDtv.getOnoff());
		System.out.println(SKtv.getOnoff());
		System.out.println(SStv.getOnoff());
		System.out.println(LGtv.getOnoff());
	}
}

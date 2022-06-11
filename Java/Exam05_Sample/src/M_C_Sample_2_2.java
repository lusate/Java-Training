import java.util.Scanner; 
public class M_C_Sample_2_2 {
 
	public static void main(String[] args) throws CloneNotSupportedException{
		
		Scanner input = new Scanner(System.in);
		
		Television SStv = new Television();
		Television LGtv = new Television(15,25,false);
		
		OLED HDtv = new OLED();
		OLED SKtv = new OLED(17,27,false,4,5,true);
		//�θ� �ִ� Ŭ���� channel, volume, onoff, �ڽ� Ŭ���� USB, HDMI, XBOX
		
		System.out.println("HDtv: ");
		System.out.println("Channel = " + HDtv.getChannel());
		System.out.println("Volume = " + HDtv.getVolume());
		System.out.println("Number of USB Port = " + HDtv.getUSB());
		System.out.println("Number of HDMI Port = " + HDtv.getHDMI());
		
		System.out.println("SKtv: ");
		System.out.println("Channel = " + SKtv.getChannel());
		System.out.println("Volume = " + SKtv.getVolume());
		System.out.println("Number of USB Port = " + SKtv.getUSB());
		System.out.println("Number of HDMI Port = " + SKtv.getHDMI());
		
		System.out.println();
		System.out.print("SStv : ");
		SStv.PrintClassName();
		
		System.out.println();
		System.out.print("LGtv : ");
		LGtv.PrintClassName();
		
		System.out.println();
		System.out.print("HDtv : ");
		HDtv.PrintClassName();
		
		System.out.println();
		System.out.print("SKtv : ");
		SKtv.PrintClassName();
		//HD �� SK�� Television�� �ƴ� ���� OLED�� ���� �Լ� ����� �ش�.
 	} 
 }

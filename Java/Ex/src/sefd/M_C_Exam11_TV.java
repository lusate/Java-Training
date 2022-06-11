package sefd;
import java.util.*;
public class M_C_Exam11_TV {
	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner input = new Scanner(System.in);
		
	TV SStv = new TV();//생성자 1번 사용
	TV LGtv = new TV(15, 30, false);//생성자 2번 사용
	
	
	System.out.println("SStv Volume = " + SStv.GetVolume());
	System.out.println("LGtv Volume = " + LGtv.GetVolume());
	
	TV Rtv = SStv.WhoseVolumeIsLargerThanOrEqualTo(SStv, LGtv);
	
	if(Rtv == SStv) System.out.println("Volume of SStv is larger than or equal to Volume of LGtv");
	if(Rtv == LGtv) System.out.println("Volume of LGtv is larger than or equal to Volume of SStv");
	}
}
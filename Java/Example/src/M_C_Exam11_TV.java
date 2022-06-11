import java.util.*;
public class M_C_Exam11_TV {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner input = new Scanner(System.in);
		
	TV SStv = new TV();//생성자 1번 사용
	
	System.out.println("SStv: ");
	System.out.println("Channel Number = " + SStv.GetChannel());
	System.out.println("Volume = " + SStv.GetVolume());
	if(SStv.GetOnoff() == true) System.out.println("Power is on now");
	if(SStv.GetOnoff() == false) System.out.println("Power is off now");
	System.out.println();
	}
}
	/*
	//call by value 형태로 호출한 경우
	//값이 전달되므로 수정이 되지 않는다.
	System.out.println("Before calling the function, x = " + x);
	SStv.IncreaseNumber(x);
	System.out.println("After calling the function, x = " + x);
	System.out.println();
	
	//call by reference 형태로 함수를 호출한 경우
	//객체가 전달되므로 수정이 된다
	System.out.println("Before SStv volume = " + SStv)
	SStv.IncreaseNumber(SStv)
	System.out.println("After SStv volume = " + SStv);
	
}*/
//값을 보낼 때와 객체를 보내는 것의 차이

/*
메소드로 데이터를 전달하고 반환하기
메소드를 호출할 때 메소드에 데이터를 전달하는 방법으로는 2가지가 있다

1) 값을 보내는 방법 (Call by value)
전달하는 인수가 일반 변수인 경우에는 인수의 값이 복사되어 전달된다.
그러나 매개변수의 값이 변경되어도 원래 인수의 값에는 영향을 주지 않는다.

2) 객체를 보내는 방법(Call by reference) *포인터 개념
전달하는 인수가 객체인 경우에는 객체의 주소값이 복사되어 전달된다.
그래서 매개변수의 값이 변경되면 원래 인수가 가리키는 객체의 값에 영향을 준다.

메소드에서 객체를 반환하는 방법
메소드는 객체를 반환할 수 있다.
클래스에서 메소드를 선언할 때 반환하고자 하는 객체의 클래스를 메소드의 자료형으로 선언하고
메소드 안에서 return 문을 사용하여 객체를 반환한다.
*/
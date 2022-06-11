import java.util.*;
public class Practice3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("숫자 입력 : ");
		String num = input.nextLine();
		
		for(int i = 1; i < num.length(); i++) {
			if(i == 1) {
				System.out.print("1");
			}
			System.out.print("0");
		}
		
		System.out.println("의 자리 수");
	}

}

/*
숫자를 입력받으면 그에해당하는 자릿수를 출력하는 코드를 작성하라.

입력 : 156 출력 : 100의자리수

입력 : 18961 출력 : 10000의자릿수
*/
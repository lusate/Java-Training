import java.util.*;

public class M_Exam05_Sample04 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		int [] x = new int[5]; //크기가 5인 정수형 배열을 선언
		int i;
		int sum;
		float average;
		
		System.out.print("Integer 5 : ");
		sum =0;
		for(i=0;i<5;i++) {
			x[i] = input.nextInt();
		}
		
		for(i=0;i<5;i++) {
			sum = sum + x[i];
		}
		
		average = (float)sum / 5;
		
		System.out.println("Sum = " + sum);
		System.out.println("Average = " + average);
	}
}

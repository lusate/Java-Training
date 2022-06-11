import java.util.*;
public class M_Exam05_Sample {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int num1, num2;
		int sum;
		float average;
		
		System.out.print("Input the first integer number: ");
		num1 = input.nextInt();
		System.out.print("Input the second integer number: ");
		num2 = input.nextInt();
		
		sum = num1 + num2;	//합을 계산한다.
		average = (float)sum / 2;  //평균을 계산한다.
		
		System.out.println(num1 + " + " + num2 + " = " + sum);
		System.out.println("(" + (num1 + " + " + num2) + ")" + "/" + 2 + " = " + average);
		
		/*int x;
		float y;
		double z;
		
		System.out.print("Input an integer number: ");
		x = input.nextInt();
		y = input.nextFloat();
		z = input.nextDouble();
		
		System.out.println("Input number = " + x);
		System.out.println("Input number = " + y);
		System.out.println("Input number = " + z);
		*/
	}

}

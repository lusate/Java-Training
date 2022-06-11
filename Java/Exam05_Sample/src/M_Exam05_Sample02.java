import java.util.*;
public class M_Exam05_Sample02 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int num1, num2;
		
		System.out.println("Input the first integer number: ");
		num1 = input.nextInt();
		
		System.out.println("Input the second integer number: ");
		num2 = input.nextInt();
		
		if(num1 > num2) System.out.println("The first input number " + num1 + 
				" is greater than the second number " + num2);
		
		if(num1 == num2) System.out.println("The first input number " + num1 + 
				" is equal than the second number " + num2);
		
		if(num1 < num2) System.out.println("The first input number " + num1 + 
				" is less than the second number " + num2);
		
		/*if (num1 % 2 == 0) 
			System.out.println("The first input number is even number.");
		else System.out.println("The first input number is odd number.");*/
	}

}

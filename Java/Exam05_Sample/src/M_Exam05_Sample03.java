import java.util.*;
public class M_Exam05_Sample03 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int sum = 0;	//��
		int i = 1;	//�ݺ����� ��Ʈ�� ����
		int num;	//���� �Է��� ����
		
		System.out.println("Input an integer number: ");
		num = input.nextInt();
		
		if(num < 1) {
			for(i = 1; i >= num; i--) {
				sum = sum + i;
			}
			System.out.println("Sum from 1 to " + num + " = " + sum);
		}
		
		if(num >= 1) {
			for(i=1; i<=num; i++) {
				sum = sum + i;
		}
		
		System.out.println("Sum from 1 to " + num + " = " + sum);
		}
	}

}

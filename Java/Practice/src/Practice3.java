import java.util.*;
public class Practice3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("���� �Է� : ");
		String num = input.nextLine();
		
		for(int i = 1; i < num.length(); i++) {
			if(i == 1) {
				System.out.print("1");
			}
			System.out.print("0");
		}
		
		System.out.println("�� �ڸ� ��");
	}

}

/*
���ڸ� �Է¹����� �׿��ش��ϴ� �ڸ����� ����ϴ� �ڵ带 �ۼ��϶�.

�Է� : 156 ��� : 100���ڸ���

�Է� : 18961 ��� : 10000���ڸ���
*/
import java.util.*;
public class Practice5 {
	public static void main(String[] args) {
		int[] array1 = {7, 9, 14};
		int[] array2 = {24, 31, 35, 49};
		int[] array3 = {17, 37, 37, 47, 57};
		
		center(array1);
		center(array2);
		center(array3);
	}
	
	public static void center(int array[]) {
		if(array.length % 2 == 1) {
			System.out.println(array[array.length / 2]);
		}
		if(array.length % 2 == 0) {
			System.out.println((array[array.length / 2 - 1] + 
					array[array.length / 2]) / 2);
			//����� �ִ� �� 2�� ���� �� 2�� ����
		}
	}
}

/*
����Ʈ�� �ִ� ���ڵ��� �߾Ӱ��� ���ϴ� ���α׷��� ������.

[7, 9, 14] = 9
[24, 31, 35, 49] = 33
[17, 37, 37, 47, 57] = 37

�߾Ӱ� : �ڷḦ ���� ���������� ũ������� ������ �� �߾ӿ� ��ġ�� ��
�� �ڷ��� ������ Ȧ���̸� ��� ��ġ�� ���� �߾Ӱ��̴�.
�� �ڷ��� ������ ¦���̸� ��� ��ġ�� �� ���� ����� �߾Ӱ��̴�.
*/
import java.util.*;
public class Practice2 {

	public static void main(String[] args) {
		int second = 0;
		int minute = 0;
		int hour = 0;
		
		for(int i = 0; i < 60; i++) {//��
			if(i % 10 == 3) {
				second = i;
				System.out.println(second);
			}
		}
		for(int j = 0; j < 60; j++) {
			if(j % 10 == 3) {
				minute = j * 60;
				System.out.println(minute);
			}
		}
	}

}

/*
������ �ð迡 �Ϸ絿��(00:00~23:59) 3�� ǥ�õǴ� �ð��� �ʷ� ȯ���ϸ� 
�� �� ��(second) �ϱ��?

������ �ð�� �Ϸ絿�� ������ ���� ��:��(00:00~23:59)���� ǥ�õ˴ϴ�.
*/
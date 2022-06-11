import java.util.*;
public class Practice2 {

	public static void main(String[] args) {
		int second = 0;
		int minute = 0;
		int hour = 0;
		
		for(int i = 0; i < 60; i++) {//초
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
디지털 시계에 하루동안(00:00~23:59) 3이 표시되는 시간을 초로 환산하면 
총 몇 초(second) 일까요?

디지털 시계는 하루동안 다음과 같이 시:분(00:00~23:59)으로 표시됩니다.
*/
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
			//가운데에 있는 것 2개 더한 후 2로 나눔
		}
	}
}

/*
리스트에 있는 숫자들의 중앙값을 구하는 프로그램을 만들어라.

[7, 9, 14] = 9
[24, 31, 35, 49] = 33
[17, 37, 37, 47, 57] = 37

중앙값 : 자료를 작은 값에서부터 크기순으로 나열할 때 중앙에 위치한 값
① 자료의 개수가 홀수이면 가운데 위치한 값이 중앙값이다.
② 자료의 개수가 짝수이면 가운데 위치한 두 값의 평균이 중앙값이다.
*/
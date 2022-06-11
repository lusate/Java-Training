
public class MyArray {
	public static <T> void Swap(T[] x, int i, int j) {
		//x라는 배열, T는 자료형
		T temp;
		
		temp = x[i];
		x[i] = x[j];
		x[j] = temp;
		
	}
}


public class MyArray {
	public static <T> void Swap(T[] x, int i, int j) {
		//x��� �迭, T�� �ڷ���
		T temp;
		
		temp = x[i];
		x[i] = x[j];
		x[j] = temp;
		
	}
}

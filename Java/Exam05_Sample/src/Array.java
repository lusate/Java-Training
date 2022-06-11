import java.util.*;
public class Array {
	public static void main(String[] args) throws CloneNotSupportedException{
		Scanner input = new Scanner (System.in);
		
		Integer[] y = {1,2,3,4,5};
		Double[] z = {1.2,2.3,3.4,4.5,5.6};
		
		int i;
		
		System.out.println("Array y: ");
		for(i=0; i<=4; i++) {
			System.out.print(y[i] + ", ");
		}
		System.out.println();
		
		MyArray.Swap(y, 3, 4);	//3번째와 4번째 순서가 바뀐다.
		
		System.out.println("Array y: ");
		for(i=0; i<=4; i++) {
			System.out.print(y[i] + ", ");
		}
		System.out.println();
		
		System.out.println("Array z: ");
		for(i=0; i<=4; i++) {
			System.out.print(z[i] + ", ");
		}
		System.out.println();
		
		MyArray.Swap(z, 3, 4);	//3번째와 4번째 순서가 바뀐다.
		
		System.out.println("Array z: ");
		for(i=0; i<=4; i++) {
			System.out.print(z[i] + ", ");
		}
		System.out.println();
	}
}

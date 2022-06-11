import java.util.*;

public class Practice1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("수를 입력");
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		int z = (x*x) + (y*y);
		
		System.out.println("대각선의 길이 = " + z);
	}
}

import java.util.*;
public class Vect {

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner input = new Scanner(System.in);
		
		Vector v = new Vector();
		int i;
		
		v.add(10);
		v.add(10.5);
		v.add("Hello");
		
		System.out.println("Vector Size = " + v.size());
		
		for(i=0; i<=v.size() - 1; i++) {
			System.out.println("v[ " + i + " ]" + v.get(i)); //순서대로 출력 get(i)
		}
		
		v.add(1, "HI");
		for(i=0; i<=v.size() - 1; i++) {
			System.out.println("v[ " + i + " ]" + v.get(i)); //순서대로 출력 get(i)
		}
	}

}

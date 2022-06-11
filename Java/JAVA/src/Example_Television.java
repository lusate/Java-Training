import java.util.*;
public class Example_Television {

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner input = new Scanner(System.in);

		Integer[] y = {0,1,2,3,4};//int 아니고 Integer
		Double[] z = {0.1,1.2,2.3,3.4,4.5};//double이 아니고 Double
		
		int i;
		
		System.out.println("Before Swapping of y : ");
		for(i = 0; i <= 4; i++) {
			System.out.print(y[i] + ",  ");
		}
		System.out.println();
		
		//Swap 함수를 사용하여 두 원소를 서로 교환한다
		MyArray.Swap(y, 2, 4);	//2번째 원소와 4번째 원소를 바꿈
		
		System.out.println("After Swapping of y : ");
		for(i = 0; i <= 4; i++) {
			System.out.print(y[i] + ",  ");
		}
		System.out.println();
		
		System.out.println("Before Swapping of z : ");
		for(i = 0; i <= 4; i++) {
			System.out.print(z[i] + ",  ");
		}
		System.out.println();
		
		MyArray.Swap(z, 2, 4);	//2번째 원소와 4번째 원소를 바꿈
		
		System.out.println("After Swapping of z : ");
		for(i = 0; i <= 4; i++) {
			System.out.print(z[i] + ",  ");
		}
		System.out.println();
		System.out.println();
		
		Vector v = new Vector();
		
		//add는 순서대로 집어 넣음
		v.add(10);	//0번째 위치에다 정수형 10을 저장한다.
		v.add(10.5);//1번째 위치에다 실수형 10.5를 저장한다.
		v.add("Hello");//2번째 위치에다 문자열 Hello를 저장
		
		System.out.println("Vector size = " + v.size());
		for(i = 0; i < v.size(); i++) {
			System.out.println("v[" + i + "] = " + v.get(i));
		}
		
		v.add(2, "HI !");//2번 위치에다가 문자열 추가 add(index, value);
		System.out.println();
		System.out.println();
		
		System.out.println("Vector size = " + v.size());
		for(i = 0; i <= v.size() - 1; i++) {
			System.out.println("v[" + i + "] = " + v.get(i));
		}
		System.out.println();
		System.out.println();
		
		ArrayList<String> list = new ArrayList<String>();
		int index;
		
		list.add("Milk");	//0위치에다 Milk를 추가한다.
		list.add("Bread");	//1위치에다 Bread를 추가.
		list.add("Butter");	//2위치에다 Butter를 추가.
		
		System.out.println("ArrayList size = " + list.size());
		for(i = 0; i <= list.size() - 1; i++) {
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		
		list.add(1, "Apple");
		System.out.println();
		System.out.println();
		
		System.out.println("ArrayList size = " + list.size());
		for(i = 0; i <= list.size() - 1; i++) {
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		System.out.println();
		
		list.set(2, "Sweet"); //수정
		System.out.println("ArrayList size = " + list.size());
		for(i = 0; i <= list.size() - 1; i++) {
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		System.out.println();
		
		list.remove(1);
		System.out.println("ArrayList size = " + list.size());
		for(i = 0; i <= list.size() - 1; i++) {
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		
		System.out.println();
		
		index = list.indexOf("Butter"); //indexOf() : ()안의 값의 위치를 알려줌
		System.out.println("Index of Butter = " + index);
	}
}
/*
Collection(컬렉션)
자료 구조를 구현한 클래스들을 부르는 용어이다.
많이 사용되는 자료구조로는 스택, 큐, 리스트 등이 있다.

Vector Class
컬렉션의 일종으로 가변 크기의 배열을 구현한다.
Vector는 요소의 개수가 늘어나면 자동으로 배열의 크기가 늘어난다.
*Vector에는 어떤 타입의 객체라도 섞어서 저장할 수 있다.

Vector를 사용하려면 main()가 속한 클래스에서 import java.util.Vector를 추가해야 한다.

Vector에다 요소를 순서대로 추가하려면 add(object) 메소드를 사용한다.
정해진 위치에다 요소를 추가하려면 add(index, object) 메소드를 사용한다.
Vector에서 값을 추출하려면 get() 메소드를 사용한다.
size() 메소드는 현재 Vector 안에 있는 요소들의 개수를 반환한다.

ArrayList
리스트는 순서를 가지는 요소들의 모임으로
리스트는 인덱스를 사용하여 요소에 접근하므로 배열과 비슷하다.
리스트의 인덱스는 0부터 시작한다.

리스트를 배열로 구현한 것으로 크기가 자동으로 조정된다.
ArrayList를 생성하려면, 타입 매개변수를 지정해야 한다.
EX) 문자열 ArrayList를 생성하려면 ArrayList<String> list = new ArrayList<String>();
와 같이 선언한다.

생성된 ArrayList에다 데이터를 순서대로 저장하려면, add(데이터) 메소드를 사용하고,
특정 인덱스 위치에 추가하려면 add(인덱스 , 데이터) 메소드 사용. 인덱스는 위치.
특정 인덱스 위치의 원소를 수정하려면 set(인덱스, 데이터) 메소드 사용.
특정 인덱스 위치의 원소를 제거하려면 remove(인덱스, 데이터) 메소드 사용.
특정 인덱스 위치의 원소를 가져오려면 get(인덱스) 메소드 사용.
크기를 알려면 size() 메소드 사용.
특정 데이터가 저장된 위치를 알려면, indexOf(데이터) 메소드 사용하는데 ArrayList는 동일한 데이터도
여러 번 저장할 수 있으므로 맨 처음에 있는 데이터의 위치가 반환된다.
검색을 반대 방향으로 하려면 lastIndexOf(데이터) 메소드를 사용한다.
*/

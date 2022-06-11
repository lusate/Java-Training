import java.util.*;
public class MyArray {

	public static <T> void Swap(T[] x, int i, int j) {
		//
		T temp;
		
		temp = x[i];
		x[i] = x[j];
		x[j] = temp;
		
	}

} 

/*
제네릭 프로그래밍은 다양한 종류의 데이터를 처리할 수 있는 클래스와 메소드를 작성하는 기법이다.
EX) ArrayList<T> 어떤 종류의 객체도 저장할 수 있는 배열인데
여기서, T는 배열에 저장되는 타입을 나타내는 매개 변수이다.
ArrayList<Integer> list = new ArrayList<Integer>();

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
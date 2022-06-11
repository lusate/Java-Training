import java.util.*;
import java.util.Vector;
import java.util.Collection;
public class LinkedList {

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int i, j;
		int k = 5, m = 20;
		int min, max;
		
		System.out.println("Input 10 integer numbers : ");
		for(i = 0; i <= 9; i++) {
			j = input.nextInt();
			list.add(j);
		}
		System.out.println();
		System.out.println("ArrayList size = " + list.size());
		
		for(i = 0; i <=list.size() - 1; i++) {
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		
		Collections.shuffle(list);
		System.out.println();
		System.out.println("After Shuffling : ");
		for(i = 0; i <= list.size() - 1; i++) {
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		
		Collections.sort(list);	//오름차순으로 정렬
		System.out.println();
		System.out.println("After Sort : ");
		for(i = 0; i <= list.size() - 1; i++) {
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		
		Collections.sort(list, Collections.reverseOrder());	//내림차순으로 정렬
		System.out.println();
		System.out.println("After Sort : ");
		for(i = 0; i <= list.size() - 1; i++) {
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		
		j = Collections.binarySearch(list, k); //찾기
		System.out.println();
		System.out.println("After binarySearching : ");
		if(j >= 0) System.out.println("Index of " + k + " = " + j);
		if(j < 0) System.out.println(k + " does not exist j"); //k는 찾고자 하는 값, j는 위치
		
		j = Collections.binarySearch(list, m);
		System.out.println();
		System.out.println("After binarySearching : ");
		if(j >= 0) System.out.println("Index of " + m + " = " + j);
		if(j < 0) System.out.println(m + " does not exist j");
		
		min = Collections.min(list);
		max = Collections.max(list);
		System.out.println();
		System.out.println("Minimum element in the list = " + min);
		System.out.println("Minimum element in the list = " + max);
		
		Collections.reverse(list);
		System.out.println();
		System.out.println("After Reversing");
		for(i = 0; i <= list.size() - 1; i++) {
			System.out.println("list[" + i + "] = " + list.get(i));
		}
	}

}

/*
 LinkedList는 각 원소를 링크로 연결한다.
 각 원소는 다음 원소가 저장되어 있는 위치의 주소를 저장한다.
 모든 연결 리스트는 이중 연결 리스트 구조를 가진다.
 연결 리스트에서는 중간에 원소를 삽입하거나 삭제할 수 있다.
 
 LinkedList의 사용법은 ArrayList와 완전히 같다.
 문자열을 저장하는 연결 리스트는 다음과 같이 선언한다.
 LinkedList<String> list = new LinkedList<String>();
 
 Collection Class는 정렬과 탐색 등 자료구조의 기능을 구현한 메소드들을 제공한다.
 정렬(Sorting)은 데이터를 특정 기준에 맞추어 순서대로 나열하는 것이다. (기본적으로 오름차순으로 정렬)
 
 섞기(Shuffling)는 원소들의 순서를 랜덤하게 만든다.
 
 탐색(Searching)은 탐색은 미리 정렬되어 있는 리스트 안에서 특정 원소를 찾는 것이다.
 Binary Searching 기법을 기본적으로 사용한다.
 반환값이 음수가 아니면, 탐색이 성공한 위치이다.
 반환값이 음수이면, 탐색이 실패한 경우이다.
 
 min()은 리스트에서 최소값을 찾고 max()는 리스트에서 최대값을 찾는다.
 reverse()는 리스트에서 원소들의 순서를 반대로 한다. (내림차순이 됨)
 */
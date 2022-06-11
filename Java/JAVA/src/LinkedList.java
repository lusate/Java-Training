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
		
		Collections.sort(list);	//������������ ����
		System.out.println();
		System.out.println("After Sort : ");
		for(i = 0; i <= list.size() - 1; i++) {
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		
		Collections.sort(list, Collections.reverseOrder());	//������������ ����
		System.out.println();
		System.out.println("After Sort : ");
		for(i = 0; i <= list.size() - 1; i++) {
			System.out.println("list[" + i + "] = " + list.get(i));
		}
		
		j = Collections.binarySearch(list, k); //ã��
		System.out.println();
		System.out.println("After binarySearching : ");
		if(j >= 0) System.out.println("Index of " + k + " = " + j);
		if(j < 0) System.out.println(k + " does not exist j"); //k�� ã���� �ϴ� ��, j�� ��ġ
		
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
 LinkedList�� �� ���Ҹ� ��ũ�� �����Ѵ�.
 �� ���Ҵ� ���� ���Ұ� ����Ǿ� �ִ� ��ġ�� �ּҸ� �����Ѵ�.
 ��� ���� ����Ʈ�� ���� ���� ����Ʈ ������ ������.
 ���� ����Ʈ������ �߰��� ���Ҹ� �����ϰų� ������ �� �ִ�.
 
 LinkedList�� ������ ArrayList�� ������ ����.
 ���ڿ��� �����ϴ� ���� ����Ʈ�� ������ ���� �����Ѵ�.
 LinkedList<String> list = new LinkedList<String>();
 
 Collection Class�� ���İ� Ž�� �� �ڷᱸ���� ����� ������ �޼ҵ���� �����Ѵ�.
 ����(Sorting)�� �����͸� Ư�� ���ؿ� ���߾� ������� �����ϴ� ���̴�. (�⺻������ ������������ ����)
 
 ����(Shuffling)�� ���ҵ��� ������ �����ϰ� �����.
 
 Ž��(Searching)�� Ž���� �̸� ���ĵǾ� �ִ� ����Ʈ �ȿ��� Ư�� ���Ҹ� ã�� ���̴�.
 Binary Searching ����� �⺻������ ����Ѵ�.
 ��ȯ���� ������ �ƴϸ�, Ž���� ������ ��ġ�̴�.
 ��ȯ���� �����̸�, Ž���� ������ ����̴�.
 
 min()�� ����Ʈ���� �ּҰ��� ã�� max()�� ����Ʈ���� �ִ밪�� ã�´�.
 reverse()�� ����Ʈ���� ���ҵ��� ������ �ݴ�� �Ѵ�. (���������� ��)
 */
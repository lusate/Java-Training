import java.util.*;
public class Example_Television {

	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner input = new Scanner(System.in);

		Integer[] y = {0,1,2,3,4};//int �ƴϰ� Integer
		Double[] z = {0.1,1.2,2.3,3.4,4.5};//double�� �ƴϰ� Double
		
		int i;
		
		System.out.println("Before Swapping of y : ");
		for(i = 0; i <= 4; i++) {
			System.out.print(y[i] + ",  ");
		}
		System.out.println();
		
		//Swap �Լ��� ����Ͽ� �� ���Ҹ� ���� ��ȯ�Ѵ�
		MyArray.Swap(y, 2, 4);	//2��° ���ҿ� 4��° ���Ҹ� �ٲ�
		
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
		
		MyArray.Swap(z, 2, 4);	//2��° ���ҿ� 4��° ���Ҹ� �ٲ�
		
		System.out.println("After Swapping of z : ");
		for(i = 0; i <= 4; i++) {
			System.out.print(z[i] + ",  ");
		}
		System.out.println();
		System.out.println();
		
		Vector v = new Vector();
		
		//add�� ������� ���� ����
		v.add(10);	//0��° ��ġ���� ������ 10�� �����Ѵ�.
		v.add(10.5);//1��° ��ġ���� �Ǽ��� 10.5�� �����Ѵ�.
		v.add("Hello");//2��° ��ġ���� ���ڿ� Hello�� ����
		
		System.out.println("Vector size = " + v.size());
		for(i = 0; i < v.size(); i++) {
			System.out.println("v[" + i + "] = " + v.get(i));
		}
		
		v.add(2, "HI !");//2�� ��ġ���ٰ� ���ڿ� �߰� add(index, value);
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
		
		list.add("Milk");	//0��ġ���� Milk�� �߰��Ѵ�.
		list.add("Bread");	//1��ġ���� Bread�� �߰�.
		list.add("Butter");	//2��ġ���� Butter�� �߰�.
		
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
		
		list.set(2, "Sweet"); //����
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
		
		index = list.indexOf("Butter"); //indexOf() : ()���� ���� ��ġ�� �˷���
		System.out.println("Index of Butter = " + index);
	}
}
/*
Collection(�÷���)
�ڷ� ������ ������ Ŭ�������� �θ��� ����̴�.
���� ���Ǵ� �ڷᱸ���δ� ����, ť, ����Ʈ ���� �ִ�.

Vector Class
�÷����� �������� ���� ũ���� �迭�� �����Ѵ�.
Vector�� ����� ������ �þ�� �ڵ����� �迭�� ũ�Ⱑ �þ��.
*Vector���� � Ÿ���� ��ü�� ��� ������ �� �ִ�.

Vector�� ����Ϸ��� main()�� ���� Ŭ�������� import java.util.Vector�� �߰��ؾ� �Ѵ�.

Vector���� ��Ҹ� ������� �߰��Ϸ��� add(object) �޼ҵ带 ����Ѵ�.
������ ��ġ���� ��Ҹ� �߰��Ϸ��� add(index, object) �޼ҵ带 ����Ѵ�.
Vector���� ���� �����Ϸ��� get() �޼ҵ带 ����Ѵ�.
size() �޼ҵ�� ���� Vector �ȿ� �ִ� ��ҵ��� ������ ��ȯ�Ѵ�.

ArrayList
����Ʈ�� ������ ������ ��ҵ��� ��������
����Ʈ�� �ε����� ����Ͽ� ��ҿ� �����ϹǷ� �迭�� ����ϴ�.
����Ʈ�� �ε����� 0���� �����Ѵ�.

����Ʈ�� �迭�� ������ ������ ũ�Ⱑ �ڵ����� �����ȴ�.
ArrayList�� �����Ϸ���, Ÿ�� �Ű������� �����ؾ� �Ѵ�.
EX) ���ڿ� ArrayList�� �����Ϸ��� ArrayList<String> list = new ArrayList<String>();
�� ���� �����Ѵ�.

������ ArrayList���� �����͸� ������� �����Ϸ���, add(������) �޼ҵ带 ����ϰ�,
Ư�� �ε��� ��ġ�� �߰��Ϸ��� add(�ε��� , ������) �޼ҵ� ���. �ε����� ��ġ.
Ư�� �ε��� ��ġ�� ���Ҹ� �����Ϸ��� set(�ε���, ������) �޼ҵ� ���.
Ư�� �ε��� ��ġ�� ���Ҹ� �����Ϸ��� remove(�ε���, ������) �޼ҵ� ���.
Ư�� �ε��� ��ġ�� ���Ҹ� ���������� get(�ε���) �޼ҵ� ���.
ũ�⸦ �˷��� size() �޼ҵ� ���.
Ư�� �����Ͱ� ����� ��ġ�� �˷���, indexOf(������) �޼ҵ� ����ϴµ� ArrayList�� ������ �����͵�
���� �� ������ �� �����Ƿ� �� ó���� �ִ� �������� ��ġ�� ��ȯ�ȴ�.
�˻��� �ݴ� �������� �Ϸ��� lastIndexOf(������) �޼ҵ带 ����Ѵ�.
*/

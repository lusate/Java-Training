import java.util.*;
public class M_C_Exam11_TV {
	
	public static void main(String[] args) throws CloneNotSupportedException {
		Scanner input = new Scanner(System.in);
		
	TV SStv = new TV();//������ 1�� ���
	
	System.out.println("SStv: ");
	System.out.println("Channel Number = " + SStv.GetChannel());
	System.out.println("Volume = " + SStv.GetVolume());
	if(SStv.GetOnoff() == true) System.out.println("Power is on now");
	if(SStv.GetOnoff() == false) System.out.println("Power is off now");
	System.out.println();
	}
}
	/*
	//call by value ���·� ȣ���� ���
	//���� ���޵ǹǷ� ������ ���� �ʴ´�.
	System.out.println("Before calling the function, x = " + x);
	SStv.IncreaseNumber(x);
	System.out.println("After calling the function, x = " + x);
	System.out.println();
	
	//call by reference ���·� �Լ��� ȣ���� ���
	//��ü�� ���޵ǹǷ� ������ �ȴ�
	System.out.println("Before SStv volume = " + SStv)
	SStv.IncreaseNumber(SStv)
	System.out.println("After SStv volume = " + SStv);
	
}*/
//���� ���� ���� ��ü�� ������ ���� ����

/*
�޼ҵ�� �����͸� �����ϰ� ��ȯ�ϱ�
�޼ҵ带 ȣ���� �� �޼ҵ忡 �����͸� �����ϴ� ������δ� 2������ �ִ�

1) ���� ������ ��� (Call by value)
�����ϴ� �μ��� �Ϲ� ������ ��쿡�� �μ��� ���� ����Ǿ� ���޵ȴ�.
�׷��� �Ű������� ���� ����Ǿ ���� �μ��� ������ ������ ���� �ʴ´�.

2) ��ü�� ������ ���(Call by reference) *������ ����
�����ϴ� �μ��� ��ü�� ��쿡�� ��ü�� �ּҰ��� ����Ǿ� ���޵ȴ�.
�׷��� �Ű������� ���� ����Ǹ� ���� �μ��� ����Ű�� ��ü�� ���� ������ �ش�.

�޼ҵ忡�� ��ü�� ��ȯ�ϴ� ���
�޼ҵ�� ��ü�� ��ȯ�� �� �ִ�.
Ŭ�������� �޼ҵ带 ������ �� ��ȯ�ϰ��� �ϴ� ��ü�� Ŭ������ �޼ҵ��� �ڷ������� �����ϰ�
�޼ҵ� �ȿ��� return ���� ����Ͽ� ��ü�� ��ȯ�Ѵ�.
*/
import java.io.Serializable;
//Serializable �������̽��� ������ Ŭ������ ��ü�� ����ȭ�� �� �ִ�
//Ŭ������ ������ �� implements�� ������ �ϸ� �ȴ�.
public class Student implements Serializable {
    private String name;
    private int id;

    Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "name : " + name + ", id : " + id;
    }
}
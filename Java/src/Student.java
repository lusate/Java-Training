import java.io.Serializable;
//Serializable �������̽��� ������ Ŭ������ ��ü�� ����ȭ�� �� �ִ�
//Ŭ������ ������ �� implements�� ������ �ϸ� �ȴ�.
public class Student implements Serializable {
    private String name;
    private int id;
    private String password;

    Student(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "name : " + name + ", id : " + id + ", password: " + password;
    }
}
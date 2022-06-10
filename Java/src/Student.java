import java.io.Serializable;
//Serializable 인터페이스를 구현한 클래스의 객체만 직렬화할 수 있다
//클래스로 정의할 때 implements로 구현만 하면 된다.
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
import java.io.Serializable;
//Serializable 인터페이스를 구현한 클래스의 객체만 직렬화할 수 있다
//클래스로 정의할 때 implements로 구현만 하면 된다.
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
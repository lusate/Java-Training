import java.io.*;

public class Serialize {

    public static void main(String[] args) throws Exception {
//Student ��ü�� ����ȭ�Ͽ� ���Ͽ� �����ϰ� ���̷� ����� bytes�κ��� ������ȭ�Ͽ� �ٽ� ��ü�� ����� �����̴�.
        Student student = new Student("JS", 123);

        // serialization
        File file = new File("./student.file");
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(student);
            oos.flush();
        }
        //ObjectOutputStream �� writeObject() �� bytes stream���� ��ȯ�ϸ�
        //�̰��� File�� �����Ѵ�.

        // deserialization
        Student result = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Student) ois.readObject();
        }
        //ObjectInputStream �� readObject()�� bytes stream�� ��ü�� ��ȯ�Ѵ�.

        System.out.println(result.toString());
    }

}

//����ȭ �ϰ� �Ǹ� �� �ּ� ���� ������ �����͸� ���� ���� �� ���� �����ͷ� ��ȯ�� �ش�.
//����ȭ�� �� �����ʹ� �� ���� �ؽ�Ʈ �Ǵ� ���̳ʸ� ���� ���°� �Ǵµ�, �̷��� ���°� �Ǿ��� �� �����ϰų� ����� �� �Ľ��� ������ ���ǹ��� �����Ͱ� �ȴ�.
//����ϰ� �ִ� �����͸� ���� ���� Ȥ�� ������ ��ſ��� �Ľ��� �� �ִ� ���ǹ��� �����͸� ����� �����̴�.
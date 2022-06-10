import java.io.*;

public class Serialize {

    public static void main(String[] args) throws Exception {
//Student 객체를 직렬화하여 파일에 저장하고 파이렝 저장된 bytes로부터 역직렬화하여 다시 객체로 만드는 예제이다.
        Student student = new Student("JS", 123);

        // serialization
        File file = new File("./student.file");
        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(student);
            oos.flush();
        }
        //ObjectOutputStream 과 writeObject() 로 bytes stream으로 변환하며
        //이것을 File에 저장한다.

        // deserialization
        Student result = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (Student) ois.readObject();
        }
        //ObjectInputStream 과 readObject()로 bytes stream을 객체를 변환한다.

        System.out.println(result.toString());
    }

}

//직렬화 하게 되면 각 주소 값이 가지는 데이터를 전부 끌어 값 형식 데이터로 변환해 준다.
//직렬화가 된 데이터는 언어에 따라서 텍스트 또는 바이너리 등의 형태가 되는데, 이러한 형태가 되었을 때 저장하거나 통신할 때 파싱이 가능한 유의미한 데이터가 된다.
//사용하고 있는 데이터를 파일 저장 혹은 데이터 통신에서 파싱할 수 있는 유의미한 데이터를 만들기 위함이다.
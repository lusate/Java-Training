
public class M_C_Java_Exam_Interface {

	public static void main(String[] args) {
		InterFace U_BMW_Car = new BMW();	//BMW에 대한 객체를 생성
		InterFace U_Cadillac_Car = new Cadillac();
		
		U_BMW_Car.Start();
		U_BMW_Car.SetSpeed(100);
		U_BMW_Car.Turn(50);
		U_BMW_Car.Stop();
		
		U_Cadillac_Car.Start();
		U_Cadillac_Car.SetSpeed(80);
		U_Cadillac_Car.Turn(-50);
		U_Cadillac_Car.Stop();
	}

}

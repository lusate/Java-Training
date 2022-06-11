import java.awt.Color; //awt : 그래픽쪽 기능
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
//프레임 안에 패널이 들어간다. 즉 틀(프레임) 안에 그림(패널)이 그려진다.
//마우스 왼쪽을 눌러서 점을 찍기 위해서 누른 상태에서 마우스를 움직일 때 원이 그려지도록 한다.
	class Point {
		int x, y;
	}
	 
	class MyPanel extends JPanel implements MouseMotionListener{
		/*implements : 부모의 메소드를 반드시 오버라이딩(재정의) 해야 한다.
		여러 interface를 implements 가능, 메소드는 이름과 반환형만 정의하고
		실 구현은 implements 한 클래스에서 구현
		*/
		
		private int U_NumberOfPoint = 10000; //찍는 원 개수
		private int index = -1; //마우스를 조금씩 움직일 때마다 그 위치 값이 배열에 저장되도록 함
		Point[] array = new Point[U_NumberOfPoint]; //배열 만듦
		
		private int U_Size = 40; //지름 길이를 40을 초기화
		private Color U_CurrentColor = new Color(0,12,100); //Color(red, green, blue)로 색깔을 정해준다.
	
	
		//생성자
		public MyPanel() {
			this.addMouseMotionListener(this);
		}
		public void mouseDragged(MouseEvent e) {//마우스를 눌러 움직일 때 작동하는 이벤트 함수
		//모든 이벤트에 관계된 것이 e라고하는 변수에 저장되어 넘어온다.
			if(index >= U_NumberOfPoint) return; //원의 개수를 초과하면 끝냄 / 원의 개수 10개
			if(index < U_NumberOfPoint) {
				index++;	//현재 위치 index에서 1 더해줌으로써 바로 다음 원이 그려질 index를 설정해줌 
				array[index] = new Point();
				array[index].x = e.getX(); 
				array[index].y = e.getY();
				//index 위치가 총 원의 개수를 초과하지 않는다면 
				
				repaint(); //화면을 다시 그려준다 -> paintComponent
				
			}
		}
		
		public void paintComponent (Graphics g) {//화면을 다시 그리는 것
			g.setColor(U_CurrentColor);//색깔	
			//그 그래픽에다가 색깔을 지정한다. (즉 내가 이 색깔을 쓴다는 것)
			
			for(Point p : array) {
				//array하고 하는 배열 안에 있는 모든 원소의 값 각각을 한번씩 다 실행
				if(p != null) g.fillOval(p.x, p.y, U_Size, U_Size);
			}//fillOval : 속이 꽉찬 원
		}//drawOval : 타원의 테두리
		
			public void mouseMoved (MouseEvent e) {
				//마우스 클릭하지 않아도 그려지는 기능인데 우리는 마우스를 눌렀을 때 원이 그려져야 하므로 필요 없는 기능
			}
	}
	
public class M_C_Exam_Drawing extends JFrame{
	public M_C_Exam_Drawing() {
		setSize(1000, 750); //화면의 윈도우 크기를 잡아줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//윈도우 맨 오른쪽 위에 X를 누르면 끝내라
		add(new MyPanel());//내가 만든 것을 추가시킨다. (없으면 창은 나오지만 그려지지 않음)
		setVisible(true); //지금까지 만든 것을 화면에 보여라 (없으면 창이 나타나지 않음)
	}
	public static void main(String[] args) {
		M_C_Exam_Drawing s = new M_C_Exam_Drawing();
		//메인 함수에서 객체 이름을 s 로 설정하고 클래스 객체 M_C_Exam_Drawing을 생성한다. 
	}
}

/*
Event Driven Programming(이벤트 구동 프로그래밍)
어떤 이벤트가 일어나는지를 감시하고 있다가 이벤트가 발생하면 해당 이벤트에 대해
적절한 처리를 해주는 프로그래밍 방식을 이벤트 구동 프로그래밍이라 한다.

이벤트는 사용자가 마우스로 버튼을 클릭하거나 키보드를 누르면 발생한다.
이벤트가 발생하면 이벤트 객체가 생성된다.
이벤트 객체는 이벤트에 대한 여러 가지 정보를 가지고 있다.
발생한 이벤트 객체에 대해 이벤트를 처리하는 객체를 이벤트 리스너(Event Listener)라고 한다

Mouse Event (마우스 이벤트)
마우스 이벤트는 사용자가 마우스 버튼을 누르거나 마우스를 움직일 때 발생한다
사용자가 마우스로 그림을 그리려면 마우스 이벤트를 처리해야 한다.
마우스가 이동할 때 마우스의 위치를 받으려면 MouseMotionListener를 구현해서
MouseMotionEvent를 받는다.

마우스 버튼이 눌린채로 이동하면, mouseDragged() 함수가 호출이 되고,
마우스의 현재 좌표는 이벤트 객체의 getX() 와 getY()를 사용해서 얻는다.

이벤트 리스너 : 발생된 이벤트 객체에 반응하여 이벤트를 처리하는 객체
*/


import java.awt.Color; //awt : �׷����� ���
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
//������ �ȿ� �г��� ����. �� Ʋ(������) �ȿ� �׸�(�г�)�� �׷�����.
//���콺 ������ ������ ���� ��� ���ؼ� ���� ���¿��� ���콺�� ������ �� ���� �׷������� �Ѵ�.
	class Point {
		int x, y;
	}
	 
	class MyPanel extends JPanel implements MouseMotionListener{
		/*implements : �θ��� �޼ҵ带 �ݵ�� �������̵�(������) �ؾ� �Ѵ�.
		���� interface�� implements ����, �޼ҵ�� �̸��� ��ȯ���� �����ϰ�
		�� ������ implements �� Ŭ�������� ����
		*/
		
		private int U_NumberOfPoint = 10000; //��� �� ����
		private int index = -1; //���콺�� ���ݾ� ������ ������ �� ��ġ ���� �迭�� ����ǵ��� ��
		Point[] array = new Point[U_NumberOfPoint]; //�迭 ����
		
		private int U_Size = 40; //���� ���̸� 40�� �ʱ�ȭ
		private Color U_CurrentColor = new Color(0,12,100); //Color(red, green, blue)�� ������ �����ش�.
	
	
		//������
		public MyPanel() {
			this.addMouseMotionListener(this);
		}
		public void mouseDragged(MouseEvent e) {//���콺�� ���� ������ �� �۵��ϴ� �̺�Ʈ �Լ�
		//��� �̺�Ʈ�� ����� ���� e����ϴ� ������ ����Ǿ� �Ѿ�´�.
			if(index >= U_NumberOfPoint) return; //���� ������ �ʰ��ϸ� ���� / ���� ���� 10��
			if(index < U_NumberOfPoint) {
				index++;	//���� ��ġ index���� 1 ���������ν� �ٷ� ���� ���� �׷��� index�� �������� 
				array[index] = new Point();
				array[index].x = e.getX(); 
				array[index].y = e.getY();
				//index ��ġ�� �� ���� ������ �ʰ����� �ʴ´ٸ� 
				
				repaint(); //ȭ���� �ٽ� �׷��ش� -> paintComponent
				
			}
		}
		
		public void paintComponent (Graphics g) {//ȭ���� �ٽ� �׸��� ��
			g.setColor(U_CurrentColor);//����	
			//�� �׷��ȿ��ٰ� ������ �����Ѵ�. (�� ���� �� ������ ���ٴ� ��)
			
			for(Point p : array) {
				//array�ϰ� �ϴ� �迭 �ȿ� �ִ� ��� ������ �� ������ �ѹ��� �� ����
				if(p != null) g.fillOval(p.x, p.y, U_Size, U_Size);
			}//fillOval : ���� ���� ��
		}//drawOval : Ÿ���� �׵θ�
		
			public void mouseMoved (MouseEvent e) {
				//���콺 Ŭ������ �ʾƵ� �׷����� ����ε� �츮�� ���콺�� ������ �� ���� �׷����� �ϹǷ� �ʿ� ���� ���
			}
	}
	
public class M_C_Exam_Drawing extends JFrame{
	public M_C_Exam_Drawing() {
		setSize(1000, 750); //ȭ���� ������ ũ�⸦ �����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//������ �� ������ ���� X�� ������ ������
		add(new MyPanel());//���� ���� ���� �߰���Ų��. (������ â�� �������� �׷����� ����)
		setVisible(true); //���ݱ��� ���� ���� ȭ�鿡 ������ (������ â�� ��Ÿ���� ����)
	}
	public static void main(String[] args) {
		M_C_Exam_Drawing s = new M_C_Exam_Drawing();
		//���� �Լ����� ��ü �̸��� s �� �����ϰ� Ŭ���� ��ü M_C_Exam_Drawing�� �����Ѵ�. 
	}
}

/*
Event Driven Programming(�̺�Ʈ ���� ���α׷���)
� �̺�Ʈ�� �Ͼ������ �����ϰ� �ִٰ� �̺�Ʈ�� �߻��ϸ� �ش� �̺�Ʈ�� ����
������ ó���� ���ִ� ���α׷��� ����� �̺�Ʈ ���� ���α׷����̶� �Ѵ�.

�̺�Ʈ�� ����ڰ� ���콺�� ��ư�� Ŭ���ϰų� Ű���带 ������ �߻��Ѵ�.
�̺�Ʈ�� �߻��ϸ� �̺�Ʈ ��ü�� �����ȴ�.
�̺�Ʈ ��ü�� �̺�Ʈ�� ���� ���� ���� ������ ������ �ִ�.
�߻��� �̺�Ʈ ��ü�� ���� �̺�Ʈ�� ó���ϴ� ��ü�� �̺�Ʈ ������(Event Listener)��� �Ѵ�

Mouse Event (���콺 �̺�Ʈ)
���콺 �̺�Ʈ�� ����ڰ� ���콺 ��ư�� �����ų� ���콺�� ������ �� �߻��Ѵ�
����ڰ� ���콺�� �׸��� �׸����� ���콺 �̺�Ʈ�� ó���ؾ� �Ѵ�.
���콺�� �̵��� �� ���콺�� ��ġ�� �������� MouseMotionListener�� �����ؼ�
MouseMotionEvent�� �޴´�.

���콺 ��ư�� ����ä�� �̵��ϸ�, mouseDragged() �Լ��� ȣ���� �ǰ�,
���콺�� ���� ��ǥ�� �̺�Ʈ ��ü�� getX() �� getY()�� ����ؼ� ��´�.

�̺�Ʈ ������ : �߻��� �̺�Ʈ ��ü�� �����Ͽ� �̺�Ʈ�� ó���ϴ� ��ü
*/


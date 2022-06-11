import java.awt.Graphics; //�׷��� ��Ҹ� ����ϱ� ���� �ʿ�
import java.awt.Image; // �÷��̾�, ��, �̻��� �̹����� �������� ���� �ʿ�
import java.awt.Rectangle;	//�浹 ���θ� �����ϱ� ���ؼ� �ʿ���
//2���� �簢���� ��ġ���� �ƴ����� �Ǵ��� �� �ִ� ����� ����

public class Sprite {
	//protected �� ���� : ��� Ŭ�������� �������� ���� �ֱ� ������ ��� �޾Ƽ� ����ϱ� ���ؼ�
	protected int x; //�̹����� ���� ��ġ�� x��ǥ
	protected int y; //�̹����� ��ġ�� y��ǥ
	protected int dx; //�̹����� ���� �ð����� x�� �����̴� �Ÿ��� ����
	protected int dy; //�̹����� ���� �ð����� y�� �����̴� �Ÿ��� ����
	
	private Image image; //��������Ʈ ��ü�� �̹���
	
	//�����ڸ� ����� �ش�
	public Sprite (Image image, int pX, int pY) {//��������Ʈ ��ü�� �̹����� �̹����� ��ġ�� ��Ÿ�� ����
		this.image = image;
		x=pX;
		y=pY;
	}
	
	//�ش� �̹����� ���̿� ���� ���� �޾ƾ��Ѵ�.
	//�ش� �̹����� ���� �� ���� ���̸� ��ȯ�Ѵ�.
	public int GetWidth() {
		return image.getWidth(null);
	}
	//�ش� �̹����� ���� �� ���� ���̸� ��ȯ�Ѵ�.
	public int GetHeight() {
		return image.getHeight(null);
	}
	
	//��������Ʈ �̹����� ȭ�鿡 �׸���.
	public void Draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}//4��° �Ű������� ImageObserver�� �ý��� ���ο��� Image�� �ε��ϴ� �����尡 �ִµ�
	//�� ������� ���ο� �̹��� �����Ͱ� �ε��� ������ ImageObserver �������̽��� �ε� ������ �˷��ְ� �ȴ�
	
	//��������Ʈ �̹����� ���� �ð����� ������ �̵��Ÿ���ŭ �̵���Ų��.
	public void Move() {
		x=x+dx;
		y=y+dy;
	}
	//�̹����� ������ ������ ������ ��(�Ÿ�)�� �ް� �� ���� �־���� �ϱ� ������
	public int GetDx() {
		return dx;
	}
	
	public void SetDx(int pDx) {
		dx=pDx;
	}
	
	public int GetDy() {
		return dy;
	}
	
	public void SetDy(int pDy) {
		dy=pDy;
	}
	//���� ��ġ ���� �˸�ǹǷ� x, y ��ȯ�ϴ� get set
	public int GetX() {
		return x;
	}
	
	public int GetY() {
		return y;
	}
	
	/*
	Rectangle Ŭ������ �ڹٿ��� �����ϴ� Ŭ�����̴�.
	�簢�� ���¸� �̷��.

	setBounds �޼ҵ�� �簢�� ������ ������ �����Ѵ�
	intersects �޼ҵ�� ���� �ٸ� �� ���� �簢�� ������ ��ġ������ �����ؼ� ��ġ�� ��� true�� ��ȯ�Ѵ�.
	�� intersects�� �̻����� ���� ���� ������ ���� ����̴�. �׷��� �浹�ϸ� true�� ��ȯ
	�� �� �̹����� �浹 ���θ� ����ؼ� �浹�� ��쿡�� true�� ��ȯ
	*/
	
	public boolean CheckCollision (Sprite other) {//other�� ����(��) �簢��
		Rectangle myRect = new Rectangle(); //�÷��̾��� �簢�� ��ü
		Rectangle otherRect = new Rectangle(); //���� �簢�� ��ü
		
		//��ġ���� �־��ִµ� �̹����� ��ġ�� �˷��ְ� �̹����� ���̿� ���̸� �˷���� �� (�� �̹����� ������ �˷���)
		myRect.setBounds(x,y,GetWidth(), GetHeight());
		
		//�� ��ü�� ��ġ�� ����, ���̸� �����;� ��
		//x, y�� �÷��̾� �ڽ� ��ġ�̹Ƿ� �ٷ� ������ �� ������ ���� �ۿ��� �������� ������ ���� �ǵ帱 �� ����
		//������ x,y ���� �� �� �ִ� ��� �Լ��� �ҷ��;� �Ѵ�. 
		otherRect.setBounds(other.GetX(), other.GetY(), other.GetWidth(), other.GetHeight());
		
		//true ���� false ���� ����� �˷���
		return myRect.intersects(otherRect); //myRect�� otherRect�� �浹�� ����
		
	}
	
	//���α׷� ���൵ �ǰ� �ʿ������ ����� �ؾ� �Ѵ�. (�浹 ���� �� ���� ������)
	public void HandleCollision (Sprite other) {
		//�ڽ� Ŭ���� �ʿ��� �������̵� �ż� �浹���� �� � ����� ���� �����ǵȴ�.
	}
}

/*
���� ������ 5���� Ŭ������ ���
1) Sprite Class - 2���� ������ �׸� ���¸� sprite�� 2���� ��� ������ ������� ��
�⺻�� �Ǵ� Ŭ�����̰� �������� ��ҵ��� ������ �ִ�.

2) StarShip Class - �÷��̾ ���� Ŭ������ Sprite�� �������� ��ҵ��� �����Ƿ�
Sprite Class�� �θ� Ŭ������ ��� ��ӹ��� ���̴�.
�÷��̾ �� �̹����� ������ 50x50���� ����

3) Alien Class - ���� ���� Ŭ������ Sprite Class�� ��ӹ��� ���̴�.
���� �� �̹����� ������ 50x50���� ����

4) Shot Class - �÷��̾ �̻����� ������ ��� Ŭ������ Sprite Class ��ӹ��� ���̴�
�̻����� 10x10 ũ���� �̹����� ����

5) Galaga Class - main()�� �����ϴ� Ŭ������ �������� ������ ����� Ŭ����

*/

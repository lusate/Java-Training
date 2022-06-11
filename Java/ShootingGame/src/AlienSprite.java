import java.awt.Image;

public class AlienSprite extends Sprite{ //Sprite �� �ִ� protected ������ �� ���� ����
	private GalagaGame game;
	
	//������
	public AlienSprite (GalagaGame pGame, Image pImage, int pX, int pY) {
		super(pImage, pX, pY);//�θ� Ŭ���������� �����ڸ� �۵���Ŵ(�θ� Ŭ������ �����ڰ� �ʿ�� �ϴ� �Ű������� ��ȣ�ȿ� �Է����ָ� ��)
		
		game = pGame;
		dx=0;	//���� �¿�δ� �������� ����
		dy=2;	//���� ������ �Ʒ��� 2�� ���������� ���� (y���� Ŀ������ �Ʒ���)
		
	}
	
	//�������̵����� �������� �ٲ۴�
	public void Move() {
		if(y > 800) game.U_enemy_escaped = true; //800 ���� �Ѿ�� ���� ������
		//(�� ���� ������ ���ϰ� ���� ������ ����� ��) true �Ǹ鼭 ������ ����
		
		super.Move();
	}
}

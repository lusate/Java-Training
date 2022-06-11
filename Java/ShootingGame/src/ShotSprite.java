import java.awt.Image;
public class ShotSprite extends Sprite {
	private GalagaGame game;
	
	//(������)
	public ShotSprite(GalagaGame pGame, Image pImage, int pX, int pY) {
		super(pImage, pX, pY);
		
		game = pGame;
		
		dx=0;
		dy=-10; //dy�� �����̹Ƿ� ���� �ð����� 10�� �̻����� ���� �� (�� ���� �̻����� ������ ���󰡵���) 
	}
	
	//�������̵�
	public void Move() {
		super.Move();
		
		//�̻����� ���� �߻�Ǵµ�  ���� ������ -100�� ����ٸ� �����Ѵ�.
		if(y < 0) {
			game.RemoveSprite(this);
		}
	}
	
	//�̻����� ���� �浹���� �� ��� ���� ������ ����
	//���� �̻��ϰ� �浹���� ���� �̻����� ���� �浹���� ��� �� �߿� �ϳ��� ���� 
	public void HandleCollision(Sprite other) { //other�� ��
		if((other instanceof AlienSprite) == true) {
			game.RemoveSprite(this);	// �浹���� �� �̻��ϰ� ���� ����, this�� ���� �̻���
			game.RemoveSprite(other);	//other�� �̻���
			
			game.U_score = game.U_score + 10;// �̻����� ������ �� ���� 10 ����
			game.U_number_of_enemy--;	//�浹 ���� �� ���� ������ ����
		}
	}
	
}

import java.awt.Image;
import java.util.concurrent.TimeUnit; //

public class StarShipSprite extends Sprite{

	private GalagaGame game; //���� ������ ���� �ʾƼ� ���� ����
	//5��° main() �ִ� Ŭ������ ��������� ���� game
	
	//������
	public StarShipSprite (GalagaGame pGame, Image image, int x, int y) {
		super(image, x, y); //super�� �θ𿡰Լ� ��ӹ޾� �����ڸ� �̿�
		
		game = pGame;
		dx=0;
		dy=0;
	}
	
	//�������̵� �Լ� �̸�, �Ű����� �� �Ȱ��� �Լ� ���븸 �ٽ� �ڽ� Ŭ�������� ������
	//ȭ�� ������ �÷��̾ ������ �ʵ��� ������ ����
	public void Move() {// Sprite Ŭ���������� Move()�� �� ������ ���븸 �ٸ�
		//���� �Ѱ����� ������ ���
		if((dx<0) && (x<50)) { // �������� �̵�
			return; //�۵� �� ��
		}
		if((dx>0) && (x>1100)){//���������� �̵�
			return;
		}
		
		if((dy<0) && (y<50)){//�������� �̵�
			return;
		}
		//�Ʒ��� �Ѱ迡 ������ ���
		if((dy>0) && (y>740)){//�Ʒ������� �̵��Ͽ� �Ѱ����� ������ ���
			return;
		}
		//�����¿� �Ѱ��� �ȿ� �ִٸ� �θ� Ŭ����(Sprite Ŭ����)���� ������ ������ �����δ�
		super.Move();
	}
	
	//�������̵�
	public void HandleCollision (Sprite other) { //����� �浹���� �� ������ ���� ����
		if((other instanceof AlienSprite) == true){	// '������ AlienSprite�� ���ϴ� ������ �浹�Ѵٸ�' �̶�� ��
			if(game.U_player_life > 0) game.U_player_life--; // ���� �ε����� ���� �ϳ� ����
		}
	}
}

//other instanceof AlienSprite �� ����
//other��� ��ü�� AlienSprite��� Ŭ������ ���ϴ� ��ü�� ��쿡�� true�� ��ȯ�Ѵ�.
import java.awt.Image;

public class AlienSprite extends Sprite{ //Sprite 에 있는 protected 변수들 다 접근 가능
	private GalagaGame game;
	
	//생성자
	public AlienSprite (GalagaGame pGame, Image pImage, int pX, int pY) {
		super(pImage, pX, pY);//부모 클래스에서의 생성자를 작동시킴(부모 클래스의 생성자가 필요로 하는 매개변수를 괄호안에 입력해주면 됌)
		
		game = pGame;
		dx=0;	//적이 좌우로는 움직이지 않음
		dy=2;	//적이 위에서 아래로 2씩 내려오도록 설정 (y값이 커질수록 아래로)
		
	}
	
	//오버라이딩으로 움직임을 바꾼다
	public void Move() {
		if(y > 800) game.U_enemy_escaped = true; //800 범위 넘어가면 적이 도망감
		//(즉 적을 죽이지 못하고 적이 범위를 벗어났을 때) true 되면서 게임이 끝남
		
		super.Move();
	}
}

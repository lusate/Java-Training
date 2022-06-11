import java.awt.Image;
public class ShotSprite extends Sprite {
	private GalagaGame game;
	
	//(생성자)
	public ShotSprite(GalagaGame pGame, Image pImage, int pX, int pY) {
		super(pImage, pX, pY);
		
		game = pGame;
		
		dx=0;
		dy=-10; //dy가 음수이므로 단위 시간마다 10씩 미사일이 위로 감 (적 보다 미사일이 빠르게 날라가도록) 
	}
	
	//오버라이드
	public void Move() {
		super.Move();
		
		//미사일이 위로 발사되는데  위쪽 영역인 -100을 벗어난다면 제거한다.
		if(y < 0) {
			game.RemoveSprite(this);
		}
	}
	
	//미사일이 적과 충돌했을 때 어떻게 해줄 것인지 설정
	//적이 미사일과 충돌했을 경우와 미사일이 적과 충돌했을 경우 둘 중에 하나만 설정 
	public void HandleCollision(Sprite other) { //other은 적
		if((other instanceof AlienSprite) == true) {
			game.RemoveSprite(this);	// 충돌했을 때 미사일과 적을 없앰, this는 나인 미사일
			game.RemoveSprite(other);	//other는 미사일
			
			game.U_score = game.U_score + 10;// 미사일을 맞췄을 때 점수 10 증가
			game.U_number_of_enemy--;	//충돌 했을 때 적의 개수를 줄임
		}
	}
	
}

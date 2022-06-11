import java.awt.Image;
import java.util.concurrent.TimeUnit; //

public class StarShipSprite extends Sprite{

	private GalagaGame game; //아직 선언을 하지 않아서 에러 나옴
	//5번째 main() 있는 클래스로 결과적으로 만들 game
	
	//생성자
	public StarShipSprite (GalagaGame pGame, Image image, int x, int y) {
		super(image, x, y); //super로 부모에게서 상속받아 생성자를 이용
		
		game = pGame;
		dx=0;
		dy=0;
	}
	
	//오버라이딩 함수 이름, 매개변수 다 똑같고 함수 내용만 다시 자식 클래스에서 재정의
	//화면 밖으로 플레이어가 나가지 않도록 범위를 지정
	public void Move() {// Sprite 클래스에서의 Move()와 다 같은데 내용만 다름
		//왼쪽 한계점에 도달한 경우
		if((dx<0) && (x<50)) { // 왼쪽으로 이동
			return; //작동 안 함
		}
		if((dx>0) && (x>1100)){//오른쪽으로 이동
			return;
		}
		
		if((dy<0) && (y<50)){//윗쪽으로 이동
			return;
		}
		//아래쪽 한계에 도달한 경우
		if((dy>0) && (y>740)){//아래쪽으로 이동하여 한계점에 도달한 경우
			return;
		}
		//상하좌우 한계점 안에 있다면 부모 클래스(Sprite 클래스)에서 선언한 방법대로 움직인다
		super.Move();
	}
	
	//오버라이딩
	public void HandleCollision (Sprite other) { //상대방과 충돌했을 때 무엇을 하지 설정
		if((other instanceof AlienSprite) == true){	// '상대방이 AlienSprite에 속하는 적으로 충돌한다면' 이라는 뜻
			if(game.U_player_life > 0) game.U_player_life--; // 적과 부딪히면 생명 하나 삭제
		}
	}
}

//other instanceof AlienSprite 의 뜻은
//other라는 객체가 AlienSprite라는 클래스에 속하는 객체인 경우에는 true를 반환한다.
import java.awt.Graphics; //그래픽 요소를 사용하기 위해 필요
import java.awt.Image; // 플레이어, 적, 미사일 이미지를 가져오기 위해 필요
import java.awt.Rectangle;	//충돌 여부를 조사하기 위해서 필요함
//2개의 사각형이 겹치는지 아닌지를 판단할 수 있는 기능이 존재

public class Sprite {
	//protected 인 이유 : 모든 클래스에서 공통으로 갖고 있기 때문에 상속 받아서 사용하기 위해서
	protected int x; //이미지의 현재 위치의 x좌표
	protected int y; //이미지의 위치의 y좌표
	protected int dx; //이미지가 단위 시간마다 x가 움직이는 거리를 정함
	protected int dy; //이미지가 단위 시간마다 y가 움직이는 거리를 정함
	
	private Image image; //스프라이트 자체의 이미지
	
	//생성자를 만들어 준다
	public Sprite (Image image, int pX, int pY) {//스프라이트 자체의 이미지와 이미지의 위치를 나타낼 변수
		this.image = image;
		x=pX;
		y=pY;
	}
	
	//해당 이미지의 넓이와 높이 값을 받아야한다.
	//해당 이미지의 넓이 즉 가로 길이를 반환한다.
	public int GetWidth() {
		return image.getWidth(null);
	}
	//해당 이미지의 높이 즉 세로 길이를 반환한다.
	public int GetHeight() {
		return image.getHeight(null);
	}
	
	//스프라이트 이미지를 화면에 그린다.
	public void Draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}//4번째 매개변수는 ImageObserver로 시스템 내부에는 Image를 로딩하는 스레드가 있는데
	//이 스레드는 새로운 이미지 데이터가 로딩될 때마다 ImageObserver 인터페이스로 로딩 시점을 알려주게 된다
	
	//스프라이트 이미지를 단위 시간마다 정해진 이동거리만큼 이동시킨다.
	public void Move() {
		x=x+dx;
		y=y+dy;
	}
	//이미지가 움직일 때마다 움직인 값(거리)를 받고 그 값을 넣어줘야 하기 때문에
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
	//현재 위치 값만 알면되므로 x, y 반환하는 get set
	public int GetX() {
		return x;
	}
	
	public int GetY() {
		return y;
	}
	
	/*
	Rectangle 클래스는 자바에서 제공하는 클래스이다.
	사각형 형태를 이룬다.

	setBounds 메소드는 사각형 형태의 영역을 지정한다
	intersects 메소드는 서로 다른 두 개의 사각형 영역이 겹치는지를 조사해서 겹치는 경우 true를 반환한다.
	즉 intersects는 미사일을 쏴서 적을 맞췄을 때의 경우이다. 그래서 충돌하면 true를 반환
	즉 두 이미지의 충돌 여부를 계산해서 충돌한 경우에는 true를 반환
	*/
	
	public boolean CheckCollision (Sprite other) {//other는 상대방(적) 사각형
		Rectangle myRect = new Rectangle(); //플레이어의 사각형 객체
		Rectangle otherRect = new Rectangle(); //적의 사각형 객체
		
		//위치값을 넣어주는데 이미지의 위치를 알려주고 이미지의 넓이와 높이를 알려줘야 함 (즉 이미지의 영역을 알려줌)
		myRect.setBounds(x,y,GetWidth(), GetHeight());
		
		//적 객체의 위치와 넓이, 높이를 가져와야 함
		//x, y는 플레이어 자신 위치이므로 바로 가져올 수 있지만 적은 밖에서 가져오는 것으로 내가 건드릴 수 없어
		//적에게 x,y 값을 줄 수 있는 멤버 함수로 불러와야 한다. 
		otherRect.setBounds(other.GetX(), other.GetY(), other.GetWidth(), other.GetHeight());
		
		//true 인지 false 인지 결과를 알려줌
		return myRect.intersects(otherRect); //myRect와 otherRect의 충돌을 따짐
		
	}
	
	//프로그램 실행도 되고 필요없지만 존재는 해야 한다. (충돌 이후 뭘 해줄 것인지)
	public void HandleCollision (Sprite other) {
		//자식 클래스 쪽에서 오버라이딩 돼서 충돌했을 때 어떤 기능을 할지 재정의된다.
	}
}

/*
슈팅 게임은 5개의 클래스를 사용
1) Sprite Class - 2차원 형태의 그림 형태를 sprite로 2차원 평면 게임을 만들려고 함
기본이 되는 클래스이고 공통적인 요소들을 가지고 있다.

2) StarShip Class - 플레이어에 관한 클래스로 Sprite에 공통적인 요소들이 있으므로
Sprite Class를 부모 클래스로 삼아 상속받을 것이다.
플레이어가 될 이미지를 가져와 50x50으로 설정

3) Alien Class - 적을 관한 클래스로 Sprite Class를 상속받을 것이다.
적이 될 이미지를 가져와 50x50으로 설정

4) Shot Class - 플레이어가 미사일을 적에게 쏘는 클래스로 Sprite Class 상속받을 것이다
미사일은 10x10 크기의 이미지로 설정

5) Galaga Class - main()이 존재하는 클래스로 실질적인 게임이 진행될 클래스

*/

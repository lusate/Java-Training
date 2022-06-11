import java.awt.Color; //글자 색깔
import java.awt.Font; //글자 모양
import java.awt.Graphics; 
import java.util.concurrent.TimeUnit; //움직이는 시간을 정해주기 위한 것

import java.awt.event.KeyEvent; //키보드 눌러서 물체 움직이게
import java.awt.event.KeyListener;

import java.awt.image.BufferedImage; //메모리에 불러온 이미지를 올릴 때 사용 
import java.io.File; //폴더에서 플레이어, 적, 미사일 이미지를 가져옴
import java.io.IOException;// 문제 발생하면 에러 처리
import java.util.ArrayList;// 게임 상태를 구성하는 actor(플레이어, 적들, 미사일들)들을 ArrayList에 저장해서 매순간마다 그려줌 
//미사일 개수와 적의 개수 등 줄어들거나 늘어날 수 있으므로 Array가 아닌 크기가 가변적으로 변할 수 있는 Arraylist를 쓴다.

import javax.imageio.ImageIO;// 이미지를 try catch 로 예외처리 하게 해줌
import javax.swing.JFrame; // 윈도우 창을 만든다 (게임 도화지를 만듦)
import javax.swing.JPanel; // 프레임(게임 틀을 만듦)

public class GalagaGame extends JPanel implements KeyListener {
	
	private boolean U_Game_is_running_now = true;	//게임 진행 중
	private ArrayList sprites = new ArrayList();
	private Sprite starship, alien, shot; //차례대로 나, 적, 미사일
	
	private BufferedImage alienImage; //적 이미지
	private BufferedImage shotImage; //미사일 이미지
	private BufferedImage shipImage; //플레이어(나) 이미지
	
	private int U_player_unit_move=10; //사용자의 이동거리 (한번 움직일 때 10 이동)
	
	private int U_missile_launching_unit_time = 5; //미사일이 연속적으로 발사되는 것을 금지 즉 미사일 발사 쿨타임
	
	private int U_missile_timer = 0; // 처음 미사일을 발사하는 시간을 0으로 초기화
	
	public int U_player_life = 1; //플레이어 목숨 1개로 초기화
	public boolean U_enemy_escaped = false; //적은 처음 시작할 때 위에서부터 내려오므로 처음에는 false로 초기화
	//U_Game_is_running_now가 true인 동안에 적이 범위 벗어나 U_enemy_escaped가 true가 되면 U_Game_is_running_now는 false가 됌 
	
	public int U_score = 0; //점수
	public int U_number_of_enemy = 14; //적의 숫자
	
	//p는 나 s는 상대방 변수
	public int i, p, s;
	
	//생성자
	public GalagaGame() {
		JFrame frame = new JFrame("Galaxy Shooting Game"); //게임 타이틀 (게임 윈도우 창과 게임 이름을 설정)
		
		//화면에 보여줄 프레임을 구성
		frame.setSize(1600, 850); // 프레임 크기 가로 1600 세로 850
		frame.add(this); //바로 위 사이즈만큼 프레임을 추가
		frame.setResizable(false); //프레임 사이즈 변형 못하도록 고정
		frame.setVisible(true); //화면에 보이도록 설정
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //윈도우 창 X로 창 닫기
	

	//적, 미사일, 플레이어 이미지들을 읽어 들인다.
	try {//자바가 알아서 이미지를 읽어오므로 나는 디렉터리가 어디에 있는지만 밝히면 됨, 에러 생기면 catch에서 알아서 실행됨
		alienImage = ImageIO.read(new File("C:\\Enemy.png"));
		shotImage = ImageIO.read(new File("C:\\shot.png"));
		shipImage = ImageIO.read(new File("C:\\Player.png"));
	}
	
	catch(IOException e) {
		e.printStackTrace(); //에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력
	}
		
	//키보드 입력을 받기 위한 준비과정
	this.requestFocus(); //키보드 입력을 받을 수 있게 준비
	addKeyListener(this); //키보드 입력을 받는 것
	//위 2개를 같이 쓴다.
	
	//게임 화면의 초기화 부분으로 플레이어와 적을 생성한다.
	this.InitSprites(); 
	}
	
	//프레임 크기는 (1600x850)이었음
	//게임 화면의 초기화 부분인데 적을 생성한다.
	public void InitSprites() {
		//플레이어를 생성한다.  게임, 이미지, x, y 를 보내줘야 함
		starship = new StarShipSprite(this, shipImage, 600, 600);
		
		//생성한 플레이어를 ArrayList인 sprite에다가 추가한다.
		sprites.add(starship);
		
		for (i=1; i<=U_number_of_enemy; i++) { //x가 200+i*70 y가 30
			//패널에서 첫 번재 적의 이미지는 (120, 30) 위치에, 2 번째 적의 이미지는 (190, 30) 위치에 해서 적의 수는 14개로 생성
			alien = new AlienSprite(this, alienImage, 50 + i * 70, 30); 
			//생성한 적을 ArrayList인 sprites 에다가 추가한다.
			sprites.add(alien);
		}
	}
	
	public void RemoveSprite(Sprite sprite) {
		sprites.remove(sprite);
	}//HandleCollision 생성자에서 미사일과 적을 제거하도록 sprites에서 remove(sprite)
	
	//키보드의 스페이스바를 누를 때마다 호출이 되어 새로 발사되는 미사일을 생성한다.
	//키보드 누를 때마다 미사일이 발사되도록 한다.
	public void Fire() {//비행기가 starship 이미지 크기는 50X50
		//미사일 생성
		shot = new ShotSprite(this, shotImage, starship.GetX()+20, starship.GetY()-20);
		//비행기 위로 미사일이 발사되어야 하므로 x는 플레이어의 x 위치를 가져와서 20을 더해주고, 플레이어 위쪽에 미사일이 위치하도록 
		//starship(플레이어)의 y 위치에서 -20을 해준다.
		
		//생성한 미사일을 ArrayList인 sprites에다가 순서대로 추가한다.
		sprites.add(shot);
	}
	
	//Override
	//게임 화면에서 발생한 변화를 새롭게 보이도록 하기 위해서 반복적으로 게임 화면을 새로 다시 그린다.
	//후에 게임 루프 속에 있는 repaint()에 의해서 내부적으로 자동 실행된다.
	//화면을 다시 그린다면 repaint()를 불러서 무엇을 다시 그릴지 정할려면 void paint (Graphics g) 여기에서 정한다.
	//
	public void paint (Graphics g) {
		super.paint(g);
		g.setColor(Color.white); //칠할 배경 색을 지정
		g.fillRect(0, 0, 1600, 850); //화면 크기 1600x850 전체를 흰색으로 만듦
		
		for(i=0; i<=sprites.size() - 1; i++) {// 15개라면 0 ~ 14 이므로 -1을 해준다.
			Sprite sprite = (Sprite)sprites.get(i);
			sprite.Draw(g); //적, 플레이어, 미사일 모두 불러와서 Draw로 화면에 다시 그려줌
		}
		
		//필요한 정보들을 보여준다.
		g.setColor(Color.blue);  //글자색 파랑
		g.setFont(new Font("Default", Font.BOLD, 15));
		g.drawString("SCORE: " + U_score, 1130, 100);
		g.drawString("LIFE PACK: " + U_player_life, 1130, 130); //플레이어 생명 개수, 위치
		
		//플레이어가 죽거나 적이 탈출을 한다면
		if((U_player_life <= 0) || (U_enemy_escaped == true)) {
			g.setColor(Color.red);
			g.setFont(new Font("Default", Font.BOLD, 100));
			g.drawString("YOU FAILED",350 ,350);
		}
		
		//살아있는 적의 수를 보여준다.
		g.setColor(Color.gray);
		g.setFont(new Font("Default", Font.BOLD, 25));
		g.drawString("ENEMY: " + U_number_of_enemy, 1130, 160);
		
		if(U_number_of_enemy == 0) { //살아있는 적의 수가 0이라면
			g.setColor(Color.blue);
			g.setFont(new Font("Default", Font.BOLD, 100));
			g.drawString("YOU WIN",350 ,350);
		}
	}
	
	//Game Loop
	public void GameLoop() {
		//현재 게임이 제대로 실행되고 있는 동안에
		while(U_Game_is_running_now == true) {// 변수임
			U_missile_timer++;	// 미사일 발사 시간 간격을 재는 시계로 1씩 증가하도록 작동
			//현재 살아 있는 동안 게임 화면에 보이는 객체 각각을 자기 이동 방향과 이동 크기만큼 고려해서 이동시킨다.
			for(i=0; i<=sprites.size() - 1; i++) {
				Sprite sprite = (Sprite)sprites.get(i);
				sprite.Move();
			}
			
			//현재 살아 있는 나를 me라고 하고 나 이외의 살아 있는 것들은 other
			//나인 me와 남인 other가 충돌한 경우에는 각자에 대한 충돌 처리를 해준다.
			for(p=0; p <= sprites.size() - 1; p++) {
				for(s=p+1; s <=sprites.size() - 1; s++) {
					Sprite me = (Sprite)sprites.get(p); //p 위치에 있는 것이 나
					//s는 나 이외의 것
					Sprite other = (Sprite)sprites.get(s); //남
					
					//내가 남과 충돌 했다면
					if(me.CheckCollision(other) == true) {//나와 나 이외의 것이 부딪혔다면
						me.HandleCollision(other); //부딪혔을 때의 과정을 호출하여 내 입장에서 남과 충돌했을 때
						other.HandleCollision(me); //남이 나와 충돌했을 때를 호출
					}
				}
			}
			
			//위에서 언급한 paint()를 내부적으로 호출해서 게임 화면을 새로 그린다.
			repaint();
			
			try {
				TimeUnit.MILLISECONDS.sleep(40); //클수록 천천히 내려온다
			}//import java.util.concurrent.TimeUnit; 를 넣어서 시간적으로 거리를 띄우려고 함
			catch(Exception e) {
				
			}
		}
	}
	
	//Override
	//implements keylistner를 만듦
	public void keyPressed (KeyEvent e) {// 키보드를 눌렀을 때 키보드 입력을 받는 부분
		if (e.getKeyCode() == KeyEvent.VK_LEFT) //왼족으로 이동시킴
			starship.SetDx(-U_player_unit_move); // 왼쪽 키를 눌렀을 때 -10만큼
		//U_Player_unit_move를 10으로 초개화 했음
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) //오른족으로 이동시킴
			starship.SetDx(U_player_unit_move); // 오른쪽 키를 눌렀을 때 10만큼
		if (e.getKeyCode() == KeyEvent.VK_UP)
			starship.SetDy(-10);
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			starship.SetDy(U_player_unit_move);
		// VK_LEFT : 왼족 방향 화살표 키
		// VK_RIGHT : 오른쪽
		
		//ESC 키가 눌리면, 강제로 게임을 끝낸다.
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(0);
		
		//키보드의 스페이스 바를 눌렀을 때, 미사일을 발사
		//일정한 시간이 지난 뒤에 다음번 미사일을 발사한다. (간격 없이 연속적으로 미사일이 발사되는 것을 방지)
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			//플레이어가 살아있는 상태에서
			//미사일을 발사하면 타이머가 0으로 세팅이 되고 루프를 돌 때마다 하나씩 증가해서 다섯 루프를 돌 시간이 되어야 함
			//미사일 발사 간격 시간을 넘는 경우에 새로운 미사일을 발사
			if ((U_player_life>0) && (U_missile_timer > U_missile_launching_unit_time)) {
				Fire();
				U_missile_timer = 0; //미사일 발사 시간 간격을 재는 시계
			}//미사일을 발사하고 단위 시간 5 후에 다시 시계를 0으로 초기화하여 while문 반복
	}
	
	//오버라이딩
	//keyReleased가 없으면 왼쪽 키를 누르지 않아도 계속 왼쪽으로만 감
	public void keyReleased (KeyEvent e) {// 키보드를 눌렀다가 놓았을 때, 키보드 입력을 처리하는 부분
		//왼쪽 방향 키
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			starship.SetDx(0); //왼쪽 키 누르지 않으면 움직이지 않음
		
		//오른쪽 방향 키
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			starship.SetDx(0); //왼쪽 키 누르지 않으면 움직이지 않음
		
		//위쪽 방향 키
		if(e.getKeyCode() == KeyEvent.VK_UP)
			starship.SetDy(0);
		
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
			starship.SetDy(0);
	}
	
	public void keyTyped (KeyEvent arg0) {
		
	}
	
	public static void main(String[] args) {
		GalagaGame g = new GalagaGame();
		g.GameLoop();
		//main 에서 GameLoop()를 호출
	}

}

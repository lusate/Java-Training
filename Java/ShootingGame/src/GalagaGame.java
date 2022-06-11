import java.awt.Color; //���� ����
import java.awt.Font; //���� ���
import java.awt.Graphics; 
import java.util.concurrent.TimeUnit; //�����̴� �ð��� �����ֱ� ���� ��

import java.awt.event.KeyEvent; //Ű���� ������ ��ü �����̰�
import java.awt.event.KeyListener;

import java.awt.image.BufferedImage; //�޸𸮿� �ҷ��� �̹����� �ø� �� ��� 
import java.io.File; //�������� �÷��̾�, ��, �̻��� �̹����� ������
import java.io.IOException;// ���� �߻��ϸ� ���� ó��
import java.util.ArrayList;// ���� ���¸� �����ϴ� actor(�÷��̾�, ����, �̻��ϵ�)���� ArrayList�� �����ؼ� �ż������� �׷��� 
//�̻��� ������ ���� ���� �� �پ��ų� �þ �� �����Ƿ� Array�� �ƴ� ũ�Ⱑ ���������� ���� �� �ִ� Arraylist�� ����.

import javax.imageio.ImageIO;// �̹����� try catch �� ����ó�� �ϰ� ����
import javax.swing.JFrame; // ������ â�� ����� (���� ��ȭ���� ����)
import javax.swing.JPanel; // ������(���� Ʋ�� ����)

public class GalagaGame extends JPanel implements KeyListener {
	
	private boolean U_Game_is_running_now = true;	//���� ���� ��
	private ArrayList sprites = new ArrayList();
	private Sprite starship, alien, shot; //���ʴ�� ��, ��, �̻���
	
	private BufferedImage alienImage; //�� �̹���
	private BufferedImage shotImage; //�̻��� �̹���
	private BufferedImage shipImage; //�÷��̾�(��) �̹���
	
	private int U_player_unit_move=10; //������� �̵��Ÿ� (�ѹ� ������ �� 10 �̵�)
	
	private int U_missile_launching_unit_time = 5; //�̻����� ���������� �߻�Ǵ� ���� ���� �� �̻��� �߻� ��Ÿ��
	
	private int U_missile_timer = 0; // ó�� �̻����� �߻��ϴ� �ð��� 0���� �ʱ�ȭ
	
	public int U_player_life = 1; //�÷��̾� ��� 1���� �ʱ�ȭ
	public boolean U_enemy_escaped = false; //���� ó�� ������ �� ���������� �������Ƿ� ó������ false�� �ʱ�ȭ
	//U_Game_is_running_now�� true�� ���ȿ� ���� ���� ��� U_enemy_escaped�� true�� �Ǹ� U_Game_is_running_now�� false�� �� 
	
	public int U_score = 0; //����
	public int U_number_of_enemy = 14; //���� ����
	
	//p�� �� s�� ���� ����
	public int i, p, s;
	
	//������
	public GalagaGame() {
		JFrame frame = new JFrame("Galaxy Shooting Game"); //���� Ÿ��Ʋ (���� ������ â�� ���� �̸��� ����)
		
		//ȭ�鿡 ������ �������� ����
		frame.setSize(1600, 850); // ������ ũ�� ���� 1600 ���� 850
		frame.add(this); //�ٷ� �� �����ŭ �������� �߰�
		frame.setResizable(false); //������ ������ ���� ���ϵ��� ����
		frame.setVisible(true); //ȭ�鿡 ���̵��� ����
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //������ â X�� â �ݱ�
	

	//��, �̻���, �÷��̾� �̹������� �о� ���δ�.
	try {//�ڹٰ� �˾Ƽ� �̹����� �о���Ƿ� ���� ���͸��� ��� �ִ����� ������ ��, ���� ����� catch���� �˾Ƽ� �����
		alienImage = ImageIO.read(new File("C:\\Enemy.png"));
		shotImage = ImageIO.read(new File("C:\\shot.png"));
		shipImage = ImageIO.read(new File("C:\\Player.png"));
	}
	
	catch(IOException e) {
		e.printStackTrace(); //���� �޼����� �߻� �ٿ����� ã�Ƽ� �ܰ躰�� ������ ���
	}
		
	//Ű���� �Է��� �ޱ� ���� �غ����
	this.requestFocus(); //Ű���� �Է��� ���� �� �ְ� �غ�
	addKeyListener(this); //Ű���� �Է��� �޴� ��
	//�� 2���� ���� ����.
	
	//���� ȭ���� �ʱ�ȭ �κ����� �÷��̾�� ���� �����Ѵ�.
	this.InitSprites(); 
	}
	
	//������ ũ��� (1600x850)�̾���
	//���� ȭ���� �ʱ�ȭ �κ��ε� ���� �����Ѵ�.
	public void InitSprites() {
		//�÷��̾ �����Ѵ�.  ����, �̹���, x, y �� ������� ��
		starship = new StarShipSprite(this, shipImage, 600, 600);
		
		//������ �÷��̾ ArrayList�� sprite���ٰ� �߰��Ѵ�.
		sprites.add(starship);
		
		for (i=1; i<=U_number_of_enemy; i++) { //x�� 200+i*70 y�� 30
			//�гο��� ù ���� ���� �̹����� (120, 30) ��ġ��, 2 ��° ���� �̹����� (190, 30) ��ġ�� �ؼ� ���� ���� 14���� ����
			alien = new AlienSprite(this, alienImage, 50 + i * 70, 30); 
			//������ ���� ArrayList�� sprites ���ٰ� �߰��Ѵ�.
			sprites.add(alien);
		}
	}
	
	public void RemoveSprite(Sprite sprite) {
		sprites.remove(sprite);
	}//HandleCollision �����ڿ��� �̻��ϰ� ���� �����ϵ��� sprites���� remove(sprite)
	
	//Ű������ �����̽��ٸ� ���� ������ ȣ���� �Ǿ� ���� �߻�Ǵ� �̻����� �����Ѵ�.
	//Ű���� ���� ������ �̻����� �߻�ǵ��� �Ѵ�.
	public void Fire() {//����Ⱑ starship �̹��� ũ��� 50X50
		//�̻��� ����
		shot = new ShotSprite(this, shotImage, starship.GetX()+20, starship.GetY()-20);
		//����� ���� �̻����� �߻�Ǿ�� �ϹǷ� x�� �÷��̾��� x ��ġ�� �����ͼ� 20�� �����ְ�, �÷��̾� ���ʿ� �̻����� ��ġ�ϵ��� 
		//starship(�÷��̾�)�� y ��ġ���� -20�� ���ش�.
		
		//������ �̻����� ArrayList�� sprites���ٰ� ������� �߰��Ѵ�.
		sprites.add(shot);
	}
	
	//Override
	//���� ȭ�鿡�� �߻��� ��ȭ�� ���Ӱ� ���̵��� �ϱ� ���ؼ� �ݺ������� ���� ȭ���� ���� �ٽ� �׸���.
	//�Ŀ� ���� ���� �ӿ� �ִ� repaint()�� ���ؼ� ���������� �ڵ� ����ȴ�.
	//ȭ���� �ٽ� �׸��ٸ� repaint()�� �ҷ��� ������ �ٽ� �׸��� ���ҷ��� void paint (Graphics g) ���⿡�� ���Ѵ�.
	//
	public void paint (Graphics g) {
		super.paint(g);
		g.setColor(Color.white); //ĥ�� ��� ���� ����
		g.fillRect(0, 0, 1600, 850); //ȭ�� ũ�� 1600x850 ��ü�� ������� ����
		
		for(i=0; i<=sprites.size() - 1; i++) {// 15����� 0 ~ 14 �̹Ƿ� -1�� ���ش�.
			Sprite sprite = (Sprite)sprites.get(i);
			sprite.Draw(g); //��, �÷��̾�, �̻��� ��� �ҷ��ͼ� Draw�� ȭ�鿡 �ٽ� �׷���
		}
		
		//�ʿ��� �������� �����ش�.
		g.setColor(Color.blue);  //���ڻ� �Ķ�
		g.setFont(new Font("Default", Font.BOLD, 15));
		g.drawString("SCORE: " + U_score, 1130, 100);
		g.drawString("LIFE PACK: " + U_player_life, 1130, 130); //�÷��̾� ���� ����, ��ġ
		
		//�÷��̾ �װų� ���� Ż���� �Ѵٸ�
		if((U_player_life <= 0) || (U_enemy_escaped == true)) {
			g.setColor(Color.red);
			g.setFont(new Font("Default", Font.BOLD, 100));
			g.drawString("YOU FAILED",350 ,350);
		}
		
		//����ִ� ���� ���� �����ش�.
		g.setColor(Color.gray);
		g.setFont(new Font("Default", Font.BOLD, 25));
		g.drawString("ENEMY: " + U_number_of_enemy, 1130, 160);
		
		if(U_number_of_enemy == 0) { //����ִ� ���� ���� 0�̶��
			g.setColor(Color.blue);
			g.setFont(new Font("Default", Font.BOLD, 100));
			g.drawString("YOU WIN",350 ,350);
		}
	}
	
	//Game Loop
	public void GameLoop() {
		//���� ������ ����� ����ǰ� �ִ� ���ȿ�
		while(U_Game_is_running_now == true) {// ������
			U_missile_timer++;	// �̻��� �߻� �ð� ������ ��� �ð�� 1�� �����ϵ��� �۵�
			//���� ��� �ִ� ���� ���� ȭ�鿡 ���̴� ��ü ������ �ڱ� �̵� ����� �̵� ũ�⸸ŭ ����ؼ� �̵���Ų��.
			for(i=0; i<=sprites.size() - 1; i++) {
				Sprite sprite = (Sprite)sprites.get(i);
				sprite.Move();
			}
			
			//���� ��� �ִ� ���� me��� �ϰ� �� �̿��� ��� �ִ� �͵��� other
			//���� me�� ���� other�� �浹�� ��쿡�� ���ڿ� ���� �浹 ó���� ���ش�.
			for(p=0; p <= sprites.size() - 1; p++) {
				for(s=p+1; s <=sprites.size() - 1; s++) {
					Sprite me = (Sprite)sprites.get(p); //p ��ġ�� �ִ� ���� ��
					//s�� �� �̿��� ��
					Sprite other = (Sprite)sprites.get(s); //��
					
					//���� ���� �浹 �ߴٸ�
					if(me.CheckCollision(other) == true) {//���� �� �̿��� ���� �ε����ٸ�
						me.HandleCollision(other); //�ε����� ���� ������ ȣ���Ͽ� �� ���忡�� ���� �浹���� ��
						other.HandleCollision(me); //���� ���� �浹���� ���� ȣ��
					}
				}
			}
			
			//������ ����� paint()�� ���������� ȣ���ؼ� ���� ȭ���� ���� �׸���.
			repaint();
			
			try {
				TimeUnit.MILLISECONDS.sleep(40); //Ŭ���� õõ�� �����´�
			}//import java.util.concurrent.TimeUnit; �� �־ �ð������� �Ÿ��� ������ ��
			catch(Exception e) {
				
			}
		}
	}
	
	//Override
	//implements keylistner�� ����
	public void keyPressed (KeyEvent e) {// Ű���带 ������ �� Ű���� �Է��� �޴� �κ�
		if (e.getKeyCode() == KeyEvent.VK_LEFT) //�������� �̵���Ŵ
			starship.SetDx(-U_player_unit_move); // ���� Ű�� ������ �� -10��ŭ
		//U_Player_unit_move�� 10���� �ʰ�ȭ ����
		
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) //���������� �̵���Ŵ
			starship.SetDx(U_player_unit_move); // ������ Ű�� ������ �� 10��ŭ
		if (e.getKeyCode() == KeyEvent.VK_UP)
			starship.SetDy(-10);
		if (e.getKeyCode() == KeyEvent.VK_DOWN)
			starship.SetDy(U_player_unit_move);
		// VK_LEFT : ���� ���� ȭ��ǥ Ű
		// VK_RIGHT : ������
		
		//ESC Ű�� ������, ������ ������ ������.
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			System.exit(0);
		
		//Ű������ �����̽� �ٸ� ������ ��, �̻����� �߻�
		//������ �ð��� ���� �ڿ� ������ �̻����� �߻��Ѵ�. (���� ���� ���������� �̻����� �߻�Ǵ� ���� ����)
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
			//�÷��̾ ����ִ� ���¿���
			//�̻����� �߻��ϸ� Ÿ�̸Ӱ� 0���� ������ �ǰ� ������ �� ������ �ϳ��� �����ؼ� �ټ� ������ �� �ð��� �Ǿ�� ��
			//�̻��� �߻� ���� �ð��� �Ѵ� ��쿡 ���ο� �̻����� �߻�
			if ((U_player_life>0) && (U_missile_timer > U_missile_launching_unit_time)) {
				Fire();
				U_missile_timer = 0; //�̻��� �߻� �ð� ������ ��� �ð�
			}//�̻����� �߻��ϰ� ���� �ð� 5 �Ŀ� �ٽ� �ð踦 0���� �ʱ�ȭ�Ͽ� while�� �ݺ�
	}
	
	//�������̵�
	//keyReleased�� ������ ���� Ű�� ������ �ʾƵ� ��� �������θ� ��
	public void keyReleased (KeyEvent e) {// Ű���带 �����ٰ� ������ ��, Ű���� �Է��� ó���ϴ� �κ�
		//���� ���� Ű
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
			starship.SetDx(0); //���� Ű ������ ������ �������� ����
		
		//������ ���� Ű
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
			starship.SetDx(0); //���� Ű ������ ������ �������� ����
		
		//���� ���� Ű
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
		//main ���� GameLoop()�� ȣ��
	}

}

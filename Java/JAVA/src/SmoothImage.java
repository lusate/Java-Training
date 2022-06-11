import java.io.File;
import java.io.IOException;
import java.awt.Color; //그래픽 라이브러리
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class SmoothImage {//멤버변수들
	private BufferedImage SourceImage = null; //입력할 이미지	//아직 main에서 오지 않았기 때문에 null
	private BufferedImage TargetImage = null; //출력할 이미지
	//Source : 영상이 읽혀들어와서 컴퓨터 메모리에 일정한 공간 속에 픽셀값들
	//TargetImage : 결과물
	
	private int width, height;	//가로 방향, 세로 방향
	private int row, column;	//영상의 가로, 세로
	private int red, green, blue;
	private int new_red, new_green, new_blue;
	private int red_sum, green_sum, blue_sum;
	
	private Color color, new_color;
	
	private int i, j;
	
	private File U_InputFile = null; //처음부터 현재 존재하는 파일이름 + 경로
	private File U_OutputFile = null; //새로 만들어진 파일의 이름 + 경로
	
	// 매개변수 있는 생성자 (클래스 이름과 같아야 함)
	SmoothImage(String U_InputFile_Path, String U_OutputFile_Path, 
			int U_Brighter_Value){
		U_InputFile = new File (U_InputFile_Path); //U_InputFile_Path를 U_InputFile 에 저장
		U_OutputFile = new File (U_OutputFile_Path);
	
		try {
			SourceImage = ImageIO.read(U_InputFile);
			TargetImage = ImageIO.read(U_InputFile);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
		//문제가 없다면 여기로
		//Get image width and height 영상 크기
		width = SourceImage.getWidth(); //입력 영상의 넓이
		height = SourceImage.getHeight(); //입력 영상의 높이
		
		//흰색으로 출력 이미지 영역 전체를 칠한다.
		new_color = new Color(255, 255, 255);
		
		for(column = 0; column <= height - 1; column++) {
			for(row = 0; row <= width - 1; row++) {
				TargetImage.setRGB(row, column, new_color.getRGB()); //배경화면 흰색
			}
		}
		
		red_sum=0;
		blue_sum=0;
		green_sum=0;
		
		for(i=-1; i<=1; i++) {
			for(j=-1; j<=1; j++) {
				
			}
		}
		
		for(column = 0; column <= height - 1; column++) {
			for(row = 0; row <= width - 1; row++) {
				//입력 영상에서 특정 위치에 있는 색상을 읽어온다.
				color = new Color (SourceImage.getRGB(row, column));
				
				//읽어온 색상을 red, green, blue 3가지 성분으로 분해한다.
				red = (int)(color.getRed());
				green = (int)(color.getGreen());
				blue = (int)(color.getBlue());
				
				//calculate sum of red, green, blue 
				red_sum = red_sum + red;
				green_sum = green_sum + green;
				blue_sum = blue_sum + blue;
			
				new_red = (int)(red_sum/9.0);
				new_green = (int)(green_sum/9.0);
				new_blue = (int)(blue_sum/9.0);
				
			
				//3가지 성분 각각이 0부터 255 범위안에 있는지 조사하고 조정한다.
				if(new_red < 0) new_red = 0;
				if(new_red > 255) new_red = 255;
				if(new_green < 0) new_green = 0;
				if(new_green > 255) new_green = 255;
				if(new_blue < 0) new_blue = 0;
				if(new_blue > 255) new_blue = 255;
				
				//red, blue, green 3가지 값을 가지고 연산을 통새허 새로운 new_red, new_green, new_blue 값을 만든다.
				
				//새로 만들어진 new_red, new_green, new_blue를 가지고 새로운 색상을 만든다.
				new_color = new Color(new_red, new_green, new_blue);
				
				//만들어진 새로운 색을 출력이미지에다 기록한다.
				TargetImage.setRGB(row, column, new_color.getRGB());
			}
		} //row, column 은 저장한 이미지 크기인데  / width, height는 저장한 이미지 크기만큼 반복하기 위한 변수
		
		//write out the result image
		try {
			ImageIO.write(TargetImage, "jpg", U_OutputFile);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
}



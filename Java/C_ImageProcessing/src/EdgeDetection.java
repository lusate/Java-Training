import java.io.File;
import java.io.IOException;
import java.awt.Color; //그래픽 라이브러리
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class EdgeDetection {//멤버변수들
	private BufferedImage SourceImage = null; //입력할 이미지	//아직 main에서 오지 않았기 때문에 null
	private BufferedImage TargetImage = null; //출력할 이미지
	//Source : 영상이 읽혀들어와서 컴퓨터 메모리에 일정한 공간 속에 픽셀값들
	//TargetImage : 결과물
	
	private int Thresholding;
	
	private int width, height;	//가로 방향, 세로 방향
	private int row, column;	//영상의 가로, 세로
	private int red, green, blue;
	private int new_red, new_green, new_blue;
	
	private Color color, new_color;
	private Color color_right, color_down;
	
	private int average;
	private int red_right;
	private int red_down;
	
	private File U_InputFile = null; //처음부터 현재 존재하는 파일이름 + 경로
	private File U_OutputFile = null; //새로 만들어진 파일의 이름 + 경로
	
	
	//생성자 (클래스 이름과 같아야 함)
	EdgeDetection(String U_InputFile_Path, String U_OutputFile_Path, int U_Thresholding_Value){
		U_InputFile = new File (U_InputFile_Path); //U_InputFile_Path를 U_InputFile 에 저장
		U_OutputFile = new File (U_OutputFile_Path);
		Thresholding = U_Thresholding_Value;
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
		color = new Color(255, 255, 255);
		
		for(column = 0; column <= height - 1; column++) {
			for(row = 0; row <= width - 1; row++) {
				TargetImage.setRGB(row, column, color.getRGB()); //배경화면 흰색
			}
		}
		
		//STEP1 색깔을 회색으로 바꾼다
		
		for(column = 0; column <= height - 1; column++) {
			for(row = 0; row <= width - 1; row++) {
				//입력 영상에서 특정 위치에 있는 색상을 읽어온다.
				color = new Color (SourceImage.getRGB(row, column));
				
				//읽어온 색상을 red, green, blue 3가지 성분으로 분해한다.
				red = (int)(color.getRed());
				green = (int)(color.getGreen());
				blue = (int)(color.getBlue());
				
				average = (int)((red + green + blue) / 3.0);
				
				
				//3가지 성분 각각이 0부터 255 범위안에 있는지 조사하고 조정한다.
				if(average < 0) average = 0;
				if(average > 255) average = 255;
				
				//red, blue, green 3가지 값을 가지고 연산을 통새허 새로운 new_red, new_green, new_blue 값을 만든다.
				
				//새로 만들어진 new_red, new_green, new_blue를 가지고 새로운 색상을 만든다.
				new_color = new Color(average,average,average);
				
				//만들어진 새로운 색을 출력이미지에다 기록한다.
				SourceImage.setRGB(row, column, new_color.getRGB());
			}
		} //row, column 은 저장한 이미지 크기인데  / width, height는 저장한 이미지 크기만큼 반복하기 위한 변수
		
		//STEP2 - EDGE DETECTION
		for(column=0; column<=height-2; column++) {
			for(row=0; row<=width-2; row++) {
				//중앙에 있는 색상 하나를 읽어온다.
				color = new Color (SourceImage.getRGB(row, column));
				red = (int)(color.getRed());
				
				color_right = new Color (SourceImage.getRGB(row+1, column));
				red_right = (int)(color_right.getRed());
				
				color_down = new Color (SourceImage.getRGB(row, column+1));
				red_down = (int)(color_down.getRed());
				
				//좌우 또는 상하 방향으로 주어진 Thresholding 값보다 크거나 같은 차이가 난다면
				//해당 위치는 edge로 판단해서 검은색 점으로 찍은다.
				
				if ((Math.abs(red-red_right) >= Thresholding) || (Math.abs(red-red_down) >= Thresholding)){
					//new_color = new Color(0,0,0);
					
					TargetImage.setRGB(row, column, color.getRGB());
				}
			}
		}
		
		//write out the result image
		try {
			ImageIO.write(TargetImage, "png", U_OutputFile);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
}
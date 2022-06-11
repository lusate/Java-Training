import java.io.File;
import java.io.IOException;
import java.awt.Color; //그래픽 라이브러리
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class NoiseImage {//멤버변수들
	private BufferedImage SourceImage = null; //입력할 이미지	//아직 main에서 오지 않았기 때문에 null
	private BufferedImage TargetImage = null; //출력할 이미지
	//Source : 영상이 읽혀들어와서 컴퓨터 메모리에 일정한 공간 속에 픽셀값들
	//TargetImage : 결과물
	
	private int width, height;	//가로 방향, 세로 방향
	private int row, column;	//영상의 가로, 세로
	private int red, green, blue;
	
	private Color color, new_color;
	
	private File U_InputFile = null; //처음부터 현재 존재하는 파일이름 + 경로
	private File U_OutputFile = null; //새로 만들어진 파일의 이름 + 경로
	
	private int U_NumberOfNoise;
	
	//생성자 (클래스 이름과 같아야 함)
	NoiseImage(String U_InputFile_Path, String U_OutputFile_Path, int U_NumberOfNoise_Value){
		U_InputFile = new File (U_InputFile_Path); //U_InputFile_Path를 U_InputFile 에 저장
		U_OutputFile = new File (U_OutputFile_Path);
		U_NumberOfNoise = U_NumberOfNoise_Value;
		
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
		
		//NumberOfNoise
		for(int i = 1; i <= U_NumberOfNoise; i++) {
			row = (int)(Math.random() * (width - 1));
			column = (int)(Math.random() * (height - 1));
			
			//이미지 영역을 확인하고 조정한다.
			if(row < 0) row = 0;
			if(row > width - 1) row = width - 1;
			if(column < 0) column = 0;
			if(column > height - 1) column = height - 1;
			
			//검정 배경을 만든다.
			new_color = new Color (0,0,0);
			
			TargetImage.setRGB(row, column, new_color.getRGB());
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


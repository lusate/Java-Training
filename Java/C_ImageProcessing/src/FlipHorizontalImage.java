//FlipVerticalImage 와 같음
import java.io.File;
import java.io.IOException;
import java.awt.Color; //그래픽 라이브러리
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class FlipHorizontalImage {//멤버변수들
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
	
	
	//생성자 (클래스 이름과 같아야 함)
	FlipHorizontalImage(String U_InputFile_Path, String U_OutputFile_Path){
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
		
		//Flip Horizontal (좌우 뒤집음)
		//Flip Vertical (상하 뒤집음)
		//Horizontal + Vertical(2번 뒤집음)
		//(90도 왼쪽으로 돌림)
		//(90도 오른쪽으로 돌림)
		
		for(column = 0; column <= height - 1; column++) {
			for(row = 0; row <= width - 1; row++) {
				//원본 이미지 영역에서 픽셀값 하나를 가져온다.
				color = new Color (SourceImage.getRGB(row, column));
				
				//출력 이미지 영역에다 그 픽셀값을 기록한다
				//TargetImage.setRGB(row, column, color.getRGB());
				//TargetImage.setRGB(width - 1 - row, column, color.getRGB());
				TargetImage.setRGB(row, height - 1 - column, color.getRGB());
				//TargetImage.setRGB(width - 1 - row, height - 1 - column, color.getRGB());
			}
		} //row, column 은 저장한 이미지 크기인데  / width, height는 저장한 이미지 크기만큼 반복하기 위한 변수
		
		//write out the result image
		try {
			ImageIO.write(TargetImage, "png", U_OutputFile);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
}

/*
1) SourceImage = ImageIO.read(경로) <입력> / IO : InputOutput
SourceImage : 원판 이미지
4) ImageIO.write(TargetImage, "png", OutputFile) <저장>
TargetImage : 우리가 만든 결과물 / png : 이미지 형태 / OutputFile : 여기 디렉토리에 쓰기

pixel : 2차원 형태의 점들의 크기

2) color = new Color (SourceImage, getRGB(row, column)) <읽어옴>
getRGB : row와 column의 위치에 있는 색깔

3) TargetImage.setRGB(row, column, color.getRGB()) <쓰기>
결과 이미지로 사용하는 곳에 row와 column 위치에 정해진 색깔로 찍기

*/


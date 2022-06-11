import java.io.File;
import java.io.IOException; //에러 처리
import java.awt.Color; //색상 관리
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class FlipVerticalImage {
	private BufferedImage SourceImage = null; //메모리 상에서 
	private BufferedImage TargetImage = null; //메모리 상에서 출력 영상을 위한 이미지 영역
	
	private int width, height;
	private int row, column;
	private int red, green, blue;
	
	private Color color, new_color;
	
	private File U_InputFile = null; //현재 존재하고 있는 입력 이미지 파일의 이름과 경로
	private File U_OutputFile = null; //새로 만들어질 이미지 파일의 이름과 경로

	//////////////////////////////////
	// (Constructor)
	//////////////////////////////////
	
	FlipVerticalImage (String U_InputFile_Path, String U_OutputFile_Path){
		//입력 이미지 읽어들임
		//read in the input image
		U_InputFile = new File(U_InputFile_Path);
		U_OutputFile = new File(U_OutputFile_Path);
	
	
	try {
		SourceImage = ImageIO.read(U_InputFile);// 만들어진 파일
		TargetImage = ImageIO.read(U_OutputFile); // 곧 생성할 파일
	}
	catch(IOException e) {
		System.out.println(e);
	}
	
	//넓이와 높이 정보 가지오기
	width = SourceImage.getWidth(); //소스 이미지의 넓이 값을 가져온다.
	height = SourceImage.getHeight();
	
	
	//출력 이미지 영역을 흰색으로 칠한다. 즉 빈 배경 이미지를 흰색으로 만듦
	//TargetImage를 흰색으로
	
	color = new Color(255,255,255); //흰색
	for (column = 0; column <= height-1; column++) {
		for(row=0;row<=width-1;row++) {
			TargetImage.setRGB(row, column, new_color.getRGB());
		}
	}
	
	for (column = 0; column <= height-1; column++) {
		for(row=0;row<=width-1;row++) {
			//원본 이미지 영역에서 픽셀값 하나를 가져온다.
			color = new Color (SourceImage.getRGB(row, column));
			
			//TargetImage 에다가 색깔을 사용
			//TargetImage.setRGB(row, column, color.getRGB());
			//이거대로 라면 같은 row와 column으로 TargetImage에 쓰므로 동일한 이미지가 출력된다.
			
			TargetImage.setRGB(width, height - 1 - column, color.getRGB());
			//오른쪽으로 뒤집는데 그림대로라면 
			//TargetImage.setRGB(row, height - 1 - column, color.getRGB());
			
			//TargetImage.setRGB(width - 1 - row, height - 1 - column, color.getRGB());
		}
	}
	
	//////////////////////////////////
	// Flip HORIZONTAL IMAGE
	//////////////////////////////////
	
	
	
	
	//결과 이미지를 출력하고 저장
	try {
		ImageIO.write(TargetImage, "png", U_OutputFile);
	}
	catch(IOException e) {
		System.out.println(e);
	}
	}
}

//Flip Horizontal 영상을 좌우로 대치형태로 뒤집는다
//입력 출력 파일들을 열기 위해서는
/*
 try{ 여기서 문제되는 것 가져오고
 }
 catch(IOException e){여기서 처리
 } 
 */

//특정 위치의 색상을 읽어오려면 color = new Color (SourceImage.getRGB(row, column))
//특정 위치에다 색상 하나를 출력하려면 TargetImage.setRGB(row, column, color.getRGB())

//이미지 형태로 출력 파일에다 쓰기 위해서는 try, catch
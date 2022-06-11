import java.io.File;
import java.io.IOException;
import java.awt.Color; //그래픽 라이브러리
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Practice06 {
	private BufferedImage SourceImage = null;
	private BufferedImage TargetImage = null;
	
	private int row, column;
	private int width, height;
	private int red, green, blue;
	
	private Color color, new_color;
	
	private File U_InputFile = null;
	private File U_OutputFile = null;
	
	Practice06(String U_InputFile_Path, String U_OutputFile_Path){
		U_InputFile = new File(U_InputFile_Path);
		U_OutputFile = new File(U_OutputFile_Path);
		
		try {SourceImage = ImageIO.read(U_InputFile);
		TargetImage = ImageIO.read(U_InputFile);
		}
		
		catch(IOException e) {
			System.out.println(e);
		}
		
		width = SourceImage.getWidth();
		height = SourceImage.getHeight();
		
		new_color = new Color(255,255,255);
		
		for(column = 0; column < height; column++) {
			
		}
	}
	
	
}

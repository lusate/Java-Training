import java.io.File;
import java.io.IOException;
import java.awt.Color; //�׷��� ���̺귯��
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class BrighterImage {//���������
	private BufferedImage SourceImage = null; //�Է��� �̹���	//���� main���� ���� �ʾұ� ������ null
	private BufferedImage TargetImage = null; //����� �̹���
	//Source : ������ �������ͼ� ��ǻ�� �޸𸮿� ������ ���� �ӿ� �ȼ�����
	//TargetImage : �����
	
	private int width, height;	//���� ����, ���� ����
	private int row, column;	//������ ����, ����
	private int red, green, blue;
	
	private Color color, new_color;
	
	private File U_InputFile = null; //ó������ ���� �����ϴ� �����̸� + ���
	private File U_OutputFile = null; //���� ������� ������ �̸� + ���
	
	private int U_Brighter;
	
	//������ (Ŭ���� �̸��� ���ƾ� ��)
	BrighterImage(String U_InputFile_Path, String U_OutputFile_Path, 
			int U_Brighter_Value){
		U_InputFile = new File (U_InputFile_Path); //U_InputFile_Path�� U_InputFile �� ����
		U_OutputFile = new File (U_OutputFile_Path);
		U_Brighter = U_Brighter_Value;
	
		try {
			SourceImage = ImageIO.read(U_InputFile);
			TargetImage = ImageIO.read(U_InputFile);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
		//������ ���ٸ� �����
		//Get image width and height ���� ũ��
		width = SourceImage.getWidth(); //�Է� ������ ����
		height = SourceImage.getHeight(); //�Է� ������ ����
		
		//������� ��� �̹��� ���� ��ü�� ĥ�Ѵ�.
		new_color = new Color(255, 255, 255);
		
		for(column = 0; column <= height - 1; column++) {
			for(row = 0; row <= width - 1; row++) {
				TargetImage.setRGB(row, column, new_color.getRGB()); //���ȭ�� ���
			}
		}
		
		
		for(column = 0; column <= height - 1; column++) {
			for(row = 0; row <= width - 1; row++) {
				//�ȼ� 1���� ���� �о�´�.
				color = new Color (SourceImage.getRGB(row, column));
				
				//�о�� �ȼ����� red, green, blue 3���� �������� �����Ѵ�.
				red = (int)(color.getRed());
				green = (int)(color.getGreen());
				blue = (int)(color.getBlue());
				
				//3���� ���� ������ �־��� ũ�� U_Brighter ��ŭ ������Ų��.
				red = red + U_Brighter;
				green = green + U_Brighter;
				blue = blue + U_Brighter;
				
				//3���� ���� ������ 0���� 255 �����ȿ� �ִ��� �����ϰ� �����Ѵ�.
				if(red < 0) red = 0;
				if(red > 255) red = 255;
				if(green < 0) green = 0;
				if(green > 255) green = 255;
				if(blue < 0) blue = 0;
				if(blue > 255) blue = 255;
				
				//3���� ������ �ռ��ؼ� �ش�Ǵ� ���ο� ���� �����.
				new_color = new Color(red, green, blue);
				
				//������� ���ο� ���� ����̹������� ����Ѵ�.
				TargetImage.setRGB(row, column, new_color.getRGB());
			}
		} //row, column �� ������ �̹��� ũ���ε�  / width, height�� ������ �̹��� ũ�⸸ŭ �ݺ��ϱ� ���� ����
		
		//write out the result image
		try {
			ImageIO.write(TargetImage, "png", U_OutputFile);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
	}
}



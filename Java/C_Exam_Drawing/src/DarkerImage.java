import java.io.File;
import java.io.IOException;
import java.awt.Color; //�׷��� ���̺귯��
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class DarkerImage {//���������
	private BufferedImage SourceImage = null; //�Է��� �̹���	//���� main���� ���� �ʾұ� ������ null
	private BufferedImage TargetImage = null; //����� �̹���
	//Source : ������ �������ͼ� ��ǻ�� �޸𸮿� ������ ���� �ӿ� �ȼ�����
	//TargetImage : �����
	
	private int width, height;	//���� ����, ���� ����
	private int row, column;	//������ ����, ����
	private int new_red, new_green, new_blue;
	
	private Color color, new_color;
	
	private File U_InputFile = null; //ó������ ���� �����ϴ� �����̸� + ���
	private File U_OutputFile = null; //���� ������� ������ �̸� + ���
	
	private int U_Darker; //��� ���� ���� �� �������� ���� ����
	
	//������ (Ŭ���� �̸��� ���ƾ� ��)
	DarkerImage(String U_InputFile_Path, String U_OutputFile_Path, 
			int U_Darker_Value){
		U_InputFile = new File (U_InputFile_Path); //U_InputFile_Path�� U_InputFile �� ����
		U_OutputFile = new File (U_OutputFile_Path);
		U_Darker = U_Darker_Value;
	
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
				//�Է� ���󿡼� Ư�� ��ġ�� �ִ� ������ �о�´�.
				color = new Color (SourceImage.getRGB(row, column));
				
				//�о�� ������ red, green, blue 3���� �������� �����Ѵ�.
				new_red = (int)(color.getRed());
				new_green = (int)(color.getGreen());
				new_blue = (int)(color.getBlue());
				
				//3���� ���� ������ �־��� ũ�� U_Darker ��ŭ ������Ų��.
				new_red = new_red - U_Darker;
				new_green = new_green - U_Darker;
				new_blue = new_blue - U_Darker;
				
				//3���� ���� ������ 0���� 255 �����ȿ� �ִ��� �����ϰ� �����Ѵ�.
				if(new_red < 0) new_red = 0;
				if(new_red > 255) new_red = 255;
				if(new_green < 0) new_green = 0;
				if(new_green > 255) new_green = 255;
				if(new_blue < 0) new_blue = 0;
				if(new_blue > 255) new_blue = 255;
				
				//red, blue, green 3���� ���� ������ ������ ����� ���ο� new_red, new_green, new_blue ���� �����.
				
				//���� ������� new_red, new_green, new_blue�� ������ ���ο� ������ �����.
				new_color = new Color(new_red, new_green, new_blue);
				
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



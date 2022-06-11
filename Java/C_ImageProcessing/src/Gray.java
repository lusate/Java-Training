import java.io.File;
import java.io.IOException;
import java.awt.Color; //�׷��� ���̺귯��
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Gray {//���������
	private BufferedImage SourceImage = null; //�Է��� �̹���	//���� main���� ���� �ʾұ� ������ null
	private BufferedImage TargetImage = null; //����� �̹���
	//Source : ������ �������ͼ� ��ǻ�� �޸𸮿� ������ ���� �ӿ� �ȼ�����
	//TargetImage : �����
	
	private int width, height;	//���� ����, ���� ����
	private int row, column;	//������ ����, ����
	private int red, green, blue;
	private int new_red, new_green, new_blue;
	
	private Color color, new_color;
	private int average;
	
	private File U_InputFile = null; //ó������ ���� �����ϴ� �����̸� + ���
	private File U_OutputFile = null; //���� ������� ������ �̸� + ���
	
	
	//������ (Ŭ���� �̸��� ���ƾ� ��)
	Gray(String U_InputFile_Path, String U_OutputFile_Path){
		U_InputFile = new File (U_InputFile_Path); //U_InputFile_Path�� U_InputFile �� ����
		U_OutputFile = new File (U_OutputFile_Path);
	
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
		color = new Color(255, 255, 255);
		
		for(column = 0; column <= height - 1; column++) {
			for(row = 0; row <= width - 1; row++) {
				TargetImage.setRGB(row, column, color.getRGB()); //���ȭ�� ���
			}
		}
		
		//GRAY IMAGE
		
		for(column = 0; column <= height - 1; column++) {
			for(row = 0; row <= width - 1; row++) {
				//�Է� ���󿡼� Ư�� ��ġ�� �ִ� ������ �о�´�.
				color = new Color (SourceImage.getRGB(row, column));
				
				//�о�� ������ red, green, blue 3���� �������� �����Ѵ�.
				red = (int)(color.getRed());
				green = (int)(color.getGreen());
				blue = (int)(color.getBlue());
				
				average = (int)((red + green + blue) / 3.0);
				
				
				//3���� ���� ������ 0���� 255 �����ȿ� �ִ��� �����ϰ� �����Ѵ�.
				if(average < 0) average = 0;
				if(average > 255) average = 255;
				
				//red, blue, green 3���� ���� ������ ������ ����� ���ο� new_red, new_green, new_blue ���� �����.
				
				//���� ������� new_red, new_green, new_blue�� ������ ���ο� ������ �����.
				new_color = new Color(average,average,average);
				
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



import java.io.File;
import java.io.IOException;
import java.awt.Color; //�׷��� ���̺귯��
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class NoiseImage {//���������
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
	
	private int U_NumberOfNoise;
	
	//������ (Ŭ���� �̸��� ���ƾ� ��)
	NoiseImage(String U_InputFile_Path, String U_OutputFile_Path, int U_NumberOfNoise_Value){
		U_InputFile = new File (U_InputFile_Path); //U_InputFile_Path�� U_InputFile �� ����
		U_OutputFile = new File (U_OutputFile_Path);
		U_NumberOfNoise = U_NumberOfNoise_Value;
		
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
		
		//NumberOfNoise
		for(int i = 1; i <= U_NumberOfNoise; i++) {
			row = (int)(Math.random() * (width - 1));
			column = (int)(Math.random() * (height - 1));
			
			//�̹��� ������ Ȯ���ϰ� �����Ѵ�.
			if(row < 0) row = 0;
			if(row > width - 1) row = width - 1;
			if(column < 0) column = 0;
			if(column > height - 1) column = height - 1;
			
			//���� ����� �����.
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


import java.io.File;
import java.io.IOException; //���� ó��
import java.awt.Color; //���� ����
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class FlipVerticalImage {
	private BufferedImage SourceImage = null; //�޸� �󿡼� 
	private BufferedImage TargetImage = null; //�޸� �󿡼� ��� ������ ���� �̹��� ����
	
	private int width, height;
	private int row, column;
	private int red, green, blue;
	
	private Color color, new_color;
	
	private File U_InputFile = null; //���� �����ϰ� �ִ� �Է� �̹��� ������ �̸��� ���
	private File U_OutputFile = null; //���� ������� �̹��� ������ �̸��� ���

	//////////////////////////////////
	// (Constructor)
	//////////////////////////////////
	
	FlipVerticalImage (String U_InputFile_Path, String U_OutputFile_Path){
		//�Է� �̹��� �о����
		//read in the input image
		U_InputFile = new File(U_InputFile_Path);
		U_OutputFile = new File(U_OutputFile_Path);
	
	
	try {
		SourceImage = ImageIO.read(U_InputFile);// ������� ����
		TargetImage = ImageIO.read(U_OutputFile); // �� ������ ����
	}
	catch(IOException e) {
		System.out.println(e);
	}
	
	//���̿� ���� ���� ��������
	width = SourceImage.getWidth(); //�ҽ� �̹����� ���� ���� �����´�.
	height = SourceImage.getHeight();
	
	
	//��� �̹��� ������ ������� ĥ�Ѵ�. �� �� ��� �̹����� ������� ����
	//TargetImage�� �������
	
	color = new Color(255,255,255); //���
	for (column = 0; column <= height-1; column++) {
		for(row=0;row<=width-1;row++) {
			TargetImage.setRGB(row, column, new_color.getRGB());
		}
	}
	
	for (column = 0; column <= height-1; column++) {
		for(row=0;row<=width-1;row++) {
			//���� �̹��� �������� �ȼ��� �ϳ��� �����´�.
			color = new Color (SourceImage.getRGB(row, column));
			
			//TargetImage ���ٰ� ������ ���
			//TargetImage.setRGB(row, column, color.getRGB());
			//�̰Ŵ�� ��� ���� row�� column���� TargetImage�� ���Ƿ� ������ �̹����� ��µȴ�.
			
			TargetImage.setRGB(width, height - 1 - column, color.getRGB());
			//���������� �����µ� �׸���ζ�� 
			//TargetImage.setRGB(row, height - 1 - column, color.getRGB());
			
			//TargetImage.setRGB(width - 1 - row, height - 1 - column, color.getRGB());
		}
	}
	
	//////////////////////////////////
	// Flip HORIZONTAL IMAGE
	//////////////////////////////////
	
	
	
	
	//��� �̹����� ����ϰ� ����
	try {
		ImageIO.write(TargetImage, "png", U_OutputFile);
	}
	catch(IOException e) {
		System.out.println(e);
	}
	}
}

//Flip Horizontal ������ �¿�� ��ġ���·� �����´�
//�Է� ��� ���ϵ��� ���� ���ؼ���
/*
 try{ ���⼭ �����Ǵ� �� ��������
 }
 catch(IOException e){���⼭ ó��
 } 
 */

//Ư�� ��ġ�� ������ �о������ color = new Color (SourceImage.getRGB(row, column))
//Ư�� ��ġ���� ���� �ϳ��� ����Ϸ��� TargetImage.setRGB(row, column, color.getRGB())

//�̹��� ���·� ��� ���Ͽ��� ���� ���ؼ��� try, catch
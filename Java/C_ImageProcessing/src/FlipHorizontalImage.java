//FlipVerticalImage �� ����
import java.io.File;
import java.io.IOException;
import java.awt.Color; //�׷��� ���̺귯��
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class FlipHorizontalImage {//���������
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
	
	
	//������ (Ŭ���� �̸��� ���ƾ� ��)
	FlipHorizontalImage(String U_InputFile_Path, String U_OutputFile_Path){
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
		new_color = new Color(255, 255, 255);
		
		for(column = 0; column <= height - 1; column++) {
			for(row = 0; row <= width - 1; row++) {
				TargetImage.setRGB(row, column, new_color.getRGB()); //���ȭ�� ���
			}
		}
		
		//Flip Horizontal (�¿� ������)
		//Flip Vertical (���� ������)
		//Horizontal + Vertical(2�� ������)
		//(90�� �������� ����)
		//(90�� ���������� ����)
		
		for(column = 0; column <= height - 1; column++) {
			for(row = 0; row <= width - 1; row++) {
				//���� �̹��� �������� �ȼ��� �ϳ��� �����´�.
				color = new Color (SourceImage.getRGB(row, column));
				
				//��� �̹��� �������� �� �ȼ����� ����Ѵ�
				//TargetImage.setRGB(row, column, color.getRGB());
				//TargetImage.setRGB(width - 1 - row, column, color.getRGB());
				TargetImage.setRGB(row, height - 1 - column, color.getRGB());
				//TargetImage.setRGB(width - 1 - row, height - 1 - column, color.getRGB());
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

/*
1) SourceImage = ImageIO.read(���) <�Է�> / IO : InputOutput
SourceImage : ���� �̹���
4) ImageIO.write(TargetImage, "png", OutputFile) <����>
TargetImage : �츮�� ���� ����� / png : �̹��� ���� / OutputFile : ���� ���丮�� ����

pixel : 2���� ������ ������ ũ��

2) color = new Color (SourceImage, getRGB(row, column)) <�о��>
getRGB : row�� column�� ��ġ�� �ִ� ����

3) TargetImage.setRGB(row, column, color.getRGB()) <����>
��� �̹����� ����ϴ� ���� row�� column ��ġ�� ������ ����� ���

*/


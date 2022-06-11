import java.io.IOException;
public class M_ImageProcessing {

	public static void main(String[] args) throws IOException {
		String U_InputFile = "C://U_Java//cat.jpg";
		//String U_OutputFile = "C://U_Java//cat_Flip.jpg"; //πŸ≤€ ¿ÃπÃ¡ˆ
		String U_OutputFile = "C://U_Java//cat_Smooth.jpg";
		//int U_NumberOfNoise_Value = 2000;
		
		//int U_Brighter_Value = 80;
		//int U_Darker_Value=80;
		//int U_Thresholding_Value=6;
		
		//FlipHorizontalImage I = new FlipHorizontalImage(U_InputFile, U_OutputFile); 
		//NoiseImage I = new NoiseImage(U_InputFile, U_OutputFile, U_NumberOfNoise_Value);
		//BrighterImage GI = new BrighterImage(U_InputFile, U_OutputFile, U_Brighter_Value);
		//DarkerImage I = new DarkerImage(U_InputFile, U_OutputFile, U_Darker_Value);
		//Gray G = new Gray(U_InputFile, U_OutputFile);
		//EdgeDetection2 G = new EdgeDetection2(U_InputFile, U_OutputFile, U_Thresholding_Value);
		Smoothing G = new Smoothing(U_InputFile, U_OutputFile);
	}

}

import java.io.IOException;
public class FlipHorizontal {

	public static void main(String[] args) throws IOException {
		String U_InputFile = "C://U_Java//cat.jpg";
		//String U_OutputFile = "C://U_Java//cat_Flip.jpg"; //πŸ≤€ ¿ÃπÃ¡ˆ
		String U_OutputFile = "C://U_Java//cat_Darker.jpg";
		//int U_NumberOfNoise_Value = 2000;
		
		//int U_Brighter_Value = 80;
		//int U_Darker_Value=80;
		
		Flip I = new Flip(U_InputFile, U_OutputFile); 
		//NoiseImage I = new NoiseImage(U_InputFile, U_OutputFile, U_NumberOfNoise_Value);
		//BrighterImage GI = new BrighterImage(U_InputFile, U_OutputFile, U_Brighter_Value);
		//DarkerImage I = new DarkerImage(U_InputFile, U_OutputFile, U_Darker_Value);
	}

}

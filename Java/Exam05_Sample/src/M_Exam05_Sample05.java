
import java.util.Scanner;

public class M_Exam05_Sample05 {
	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		
		int[][] score = new int [4][3]; // 학생수 4명의 3과목 성적들
		int[] s_sum = new int[4];
		float[] s_average = new float[4];
		int[] s_max = new int[4];
		int[] s_min = new int[4];
		int[] b_max = new int[4];
		int[] b_min = new int[4];
		int[] b_sum = new int[4];
		float[] b_ave = new float[4];
		int i, j;
		
		System.out.print("Input 3 scores for each of 4 students ");
		
		//성적 입력
		for(i=0;i<4;i++) {
			for(j=0;j<3;j++) {
				score[i][j] = input.nextInt();
			}
		}
		
		//4 학생을 중심으로한 3 과목들의 최대 성적
		for(i=0;i<4;i++) {
			int max1 = score[i][0];
			for(j=0;j<3;j++) {
				if(score[i][j] > max1) {
					max1 = score[i][j];
				}
			}
			s_max[i] = max1;
		}
		
		//최소 성적
		for(i=0;i<4;i++) {
			int min1 = score[i][0];
			for(j=0;j<3;j++) {
				if(score[i][j] < min1) {
					min1 = score[i][j];
				}
			}
			s_min[i] = min1;
		}
		
		//합계
		for(i=0;i<4;i++) {
			s_sum[i]=0;
			for(j=0;j<3;j++) {
				s_sum[i] += score[i][j];
			}
		}
		
		//4명의 학생을 중심으로 한 3 과목들의 평균
		for(i=0;i<4;i++) {
			s_average[i] = (float)s_sum[i] / 3;
		}
		
		//3과목을 중심으로한 4 학생들의 최대값
		for(j=0;j<3;j++) {
			int max1 = score[0][j];
			
			for(i=0;i<4;i++) {
				if(score[i][j] > max1) {
					max1 = score[i][j];
				}
			}
			b_max[j] = max1;
		}
		
		//3과목을 중심으로한 4 학생들의 최소값
				for(j=0;j<3;j++) {
					int min1 = score[0][j];
					
					for(i=0;i<4;i++) {
						if(score[i][j] < min1) {
							min1 = score[i][j];
						}
					}
					b_min[j] = min1;
				}
				
		//3과목을 중심으로한 4 학생들의 합계
		for(j=0;j<3;j++) {
			b_sum[j] = 0;
			for(i=0;i<4;i++) {
				b_sum[j] = b_sum[j] + score[i][j];
			}
		}
		
		//3과목을 중심으로한 4 학생들의 평균
		for(j=0;j<3;j++) {
			b_ave[j] = (float)b_sum[j] / 4; 
		}
		
		//화면 출력
				System.out.println("\t" + "Kor" + "\t" + "Eng" + "\t" + "Math" + "\t" + "St.Sum" + "\t" + 
						"St.Avr" + "\t" + "St.Max" + "\t" + "St.Min");
				for(i=0;i<4;i++) {
					for(j=0;j<3;j++) {
						System.out.print("\t " + score[i][j]);
					}
					System.out.print("\t" + s_sum[i]);
					System.out.print("\t" + s_average[i]);
					System.out.print("\t" + s_max[i]);
					System.out.println("\t" + s_min[i]);
				}
				
				System.out.print("Sub_Max");
				for(j=0;j<3;j++) {
					System.out.print("\t " + b_max[j]);
				}
				System.out.println();
				System.out.print("Sub_Min");
				for(j=0;j<3;j++) {
					System.out.print("\t " + b_min[j]);
				}
				System.out.println();
				System.out.print("Sub_Sum");
				for(j=0;j<3;j++) {
					System.out.print("\t " + b_sum[j]);
				}
				System.out.println();
				System.out.print("Sub_Ave");
				for(j=0;j<3;j++) {
					System.out.print("\t " + b_ave[j]);
				}
	}
}

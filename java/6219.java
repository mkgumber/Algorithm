
import java.util.Scanner;

/**
*Edist
*/

class Main {
	
	static char[] str1 ;
	static char[] str2 ;
	static int editDistance[][] = new int[2001][2001];
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int testCases = s.nextInt();
		for(int i=0;i<testCases;i++){
			
			 str1 = s.next().toCharArray();
			 str2 = s.next().toCharArray();
			
			int distance  = calculateEditDistance(str1,str2);
			System.out.println(distance);
		
		}
		
		

	}

	private static int calculateEditDistance(char[] str1, char[] str2) {
		int l1=str1.length;
		int l2 = str2.length;
		
		
		
		for(int i=0;i<=l1;i++)
			editDistance[i][0]=i;
		
		for(int j=0;j<=l2;j++)
			editDistance[0][j]=j;
		
		
		for(int i=1;i<=l1;i++){
			for(int j=1;j<=l2;j++){
				int case1;
				int case2;
				int case3;
					if(str1[i-1] == str2[j-1])
						case1 = editDistance[i-1][j-1];
					else
						case1= editDistance[i-1][j-1] +1;
				case2 = editDistance[i-1][j]+1;
				case3 = editDistance[i][j-1]+1;
				
				editDistance[i][j] = Math.min(Math.min(case1, case2),case3);
					
					
				
			}
			
		}
		
		return editDistance[l1][l2];
	}

	
	

}


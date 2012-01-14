import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
* Mixtures - Basic DP problem. Identical to Matrix Multiplication
**/
class Main {
	
	static int[] bottles = new int[100];
	static int[][] minSmoke = new int[100][100];
	static int[][] color = new int[100][100];
	

	public static void main(String[] args) throws Exception{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String input;
		while((input = r.readLine())!=null){
			int count = Integer.parseInt(input);
			String input1 =  r.readLine();
			Scanner s = new Scanner(input1);
			
			for(int i=0;i<count;i++){
				bottles[i]=s.nextInt();
			}
			for(int i=0;i<count;i++)
				for(int j=0;j<count;j++){
					minSmoke[i][j]=-1;
					color[i][j]=-1;
					if(i==j){
						color[i][j]=bottles[i];
						minSmoke[i][j]=0;
					}
				}
			
			findResultColor(0,count-1);
			System.out.println(minSmoke[0][count-1]);
		}
		
		
	
	}

	private static int findResultColor( int left, int right) {
		
		if(color[left][right] != -1)
			return color[left][right];
		int[] storeResults = new int[right-left];
		int[] storeResultColor = new int[right-left];
		
		int p=0;
		for(int i=left;i<right;i++)
		{
			int color1 = findResultColor(left, i);
			int color2 = findResultColor(i+1, right);
			int resultColor = (color1 + color2 )%100;
			int heat = ( color1 * color2 ) + minSmoke[left][i] + minSmoke[i+1][right];
			
			storeResults[p]=heat;
			storeResultColor[p]=resultColor;
			p++;
			
		}
		
		int min=Integer.MAX_VALUE;
		int minIndex=-1;
		for(int q=0;q<p;q++){
			if(storeResults[q]< min){
				min=storeResults[q];
				minIndex = q;
			}
		}

		minSmoke[left][right]=min;
		color[left][right]= storeResultColor[minIndex];
		return color[left][right];
	}
}



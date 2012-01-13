
import java.math.BigInteger;
import java.util.Scanner;

/**
* Marbles
*/
class Main{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int testcases = s.nextInt();
		for(int i=0;i<testcases;i++){
			int n = s.nextInt();
			int k = s.nextInt();
			
			calculateAnswer(n-1,k-1);
		}

	}

	private static void calculateAnswer(int n, int k) {
		if(n==k){
			System.out.println(1);
			return;
		}
		BigInteger sol = BigInteger.valueOf(1);
		int large = Math.max(k, n-k);
		int small = Math.min(k, n-k);
		
		for(int i=large+1;i<=n;i++)
			sol = sol.multiply(BigInteger.valueOf(i));
		
		for(int i=1;i<=small;i++)
			sol = sol.divide(BigInteger.valueOf(i));
		
		System.out.println(sol);
		
	}

}



import java.util.Arrays;
import java.util.Scanner;

/**
* PIGBANK - equivalent to unbounded Knapsack problem
*/
class Main{
	
	static int[] coinValue = new int[500];
	static int[] coinWeight = new int[500];
	static int[] interResults = new int[500];
	static int nCoins;
	static int[] results = new int[10000];
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		
		int testCases = s.nextInt();
		s.nextLine();
		for(int i=0;i<testCases;i++){
			int wBefore = s.nextInt();
			int wAfter = s.nextInt();
			s.nextLine();
			int wRequired = wAfter - wBefore;
			 nCoins = s.nextInt();
			 s.nextLine();
			for(int j=0;j<nCoins;j++){
				coinValue[j] = s.nextInt();
				coinWeight[j] = s.nextInt();
				s.nextLine();
			}
			Arrays.fill(results, 0, wRequired, 0);
			results[0]=0;
		
			int minMoney = calculateMinMoney1(wRequired);
			if(minMoney !=-1)
				System.out.format("The minimum amount of money in the piggy-bank is %d.\n",minMoney);
			else
				System.out.println("This is impossible.");
		}
	}

	
	private static int calculateMinMoney1(int wRequired) {

		
		for (int w = 1; w <= wRequired; w++) {
			int min=Integer.MAX_VALUE;
			boolean impossible = true;
			for (int i = 0; i < nCoins; i++) {
				if (coinWeight[i] <= w) {
					int ret = results[w - coinWeight[i]];
					if (ret != -1) {
						interResults[i] = ret + coinValue[i];
						impossible = false;
					} else {
						interResults[i] = Integer.MAX_VALUE;
					}
				} else {
					interResults[i] = Integer.MAX_VALUE;
				}
				min=Math.min(min,interResults[i]);
			}
			if (impossible) {
				results[w]=-1;
				continue;
			}
			
			results[w]= min;
		}
		return results[wRequired];
		
		
	}

}


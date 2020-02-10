package Temp;

public class ClimbStairsWays {
	
	static int totalWays(int n) {
		int[] lookup = new int[n+1];
		
		if(n<=1)
			return 1;
		lookup[0]=1;
		lookup[1]=1;
		lookup[2]=2;
		for(int i=3;i<=n ;i++) {
			lookup[i] = lookup[i-1]+ lookup[i-2];
		}
		
		for(int j=0;j<n;j++) {
			for(int k=0;k<n;k++) {
				System.out.print(lookup[j]);
				System.out.print(",");
			}
			System.out.println();
		}
		return lookup[n];
	}
	
	
	
   public static void main(String... args) {
	   int n = 0;
	   System.out.printf("For %d number of stairs, there are %d total ways", n, totalWays(n));
   }

}

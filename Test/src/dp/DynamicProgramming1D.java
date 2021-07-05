package dp;

import java.util.Arrays;

public class DynamicProgramming1D {
	public static int mod=1000000007;
	
	public static void main(String [] args) {
		DynamicProgramming1D dps=new DynamicProgramming1D();
		
		int t=3;
		int k=2;
		int [] dp=dps.countFlowers(k);
		
		while(t-->0) {
			int a=4;
			int b=4;
			int res=(dp[b]-dp[a-1]+mod)%mod;
			System.out.println(res);
		}
		
		//System.out.println(Arrays.toString(dp));
	}
	
	public int[] countFlowers(int k) {
		int dp[]=new int[100000];
		dp[0]=1;
		for(int i=1;i<100000;i++) {
			if(i<k) {
				dp[i]=dp[i-1];
			}else {
				dp[i]=((dp[i-1]%mod)+(dp[i-k]%mod))%mod;
			}
		}
		
		for(int i=1;i<100000;i++) {
			dp[i]=((dp[i-1]%mod)+(dp[i]%mod))%mod;
		}
		return dp;
	}
}

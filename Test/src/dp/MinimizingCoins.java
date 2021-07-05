package dp;

import java.util.Arrays;
import java.util.List;

public class MinimizingCoins {
	public static void main(String[] args) {
		MinimizingCoins dp=new MinimizingCoins();
		int n=11;
		//System.out.println(dp.getFib(n));
		int [] dpa=new int[n];
		for(int i=0;i<n;i++) {
			dpa[i]=-1;
		}
		int [] coins=new int[] {1,5,7};
		//System.out.println(dp.getFibTopDown(n,dpa));
		System.out.println(dp.minCoinChangeBottomUp(coins,n));
		System.out.println(dp.minCoinChangeTopDown(coins,n,n-1,dpa));
		
	}
	

	
	public int minCoinChangeTopDown(int [] coins,int n,int sum,int [] dp) {
		if(sum<0) {
			return Integer.MAX_VALUE;
		}
		if(sum==0) {
			return 0;
		}
		if(dp[sum]!=-1) {
			return dp[sum];
		}
		int result=Integer.MAX_VALUE;
		for(int i=0;i<coins.length;i++) {
			int recResult=minCoinChangeTopDown(coins,n,sum-coins[i],dp);//I have selected coint at i
			if(recResult!=Integer.MAX_VALUE && recResult>=0) {
				result=Math.min(result,1+recResult);
			}
		}
		//System.out.println(sum+"-"+Arrays.toString(dp));
		return dp[sum-1]=result;
	}
	
	public int minCoinChangeBottomUp(int [] coins,int n) {
		int [] dp=new int[n+1];
		for(int i=0;i<=n;i++) {
			dp[i]=Integer.MAX_VALUE;
		}
		dp[0]=0;
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<coins.length;j++) {
				if(coins[j]>i) {
					continue;//Coin is greater than the required sum
				}
				dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
}

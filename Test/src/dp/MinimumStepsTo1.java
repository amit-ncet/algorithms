package dp;

import java.util.Arrays;
import java.util.List;

public class MinimumStepsTo1 {
	public static void main(String[] args) {
		MinimumStepsTo1 dp=new MinimumStepsTo1();
		int n=14;
		//System.out.println(dp.getFib(n));
		int [] dpa=new int[n+1];
		for(int i=0;i<=n;i++) {
			dpa[i]=-1;
		}
		//System.out.println(dp.getFibTopDown(n,dpa));
		System.out.println(dp.minStepToOneTopDown(n, dpa));
		System.out.println(dp.minStepToOneBottomUp(n));
	}
	

	/*
	 * Every step we have 3 possible options:
	 * 1) Divide by 3
	 * 2) Divide by 2
	 * 3) Subtract 1
	 * 
	 * Find the minimum step it will take to reach 1
	 * 
	 * https://github.com/amit-ncet/Unacademy-Notes/blob/main/Intro%20To%20Dynamic%20Programming%202.pdf
	 * 
	 * */
	//TOp down solution
	public int minStepToOneTopDown(int n,int [] dp) {
		if(n==2 ||  n==3) {
			return 1;
		}
		if(n==1) {
			return 0;
		}
		if(n<1) {
			return Integer.MAX_VALUE;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		
		int divBy3=Integer.MAX_VALUE;
		int divBy2=Integer.MAX_VALUE;
		int subBy1=Integer.MAX_VALUE;
		
		if(n%3==0) {
			divBy3=1+minStepToOneTopDown(n/3,dp);
		}
		if(n%2==0) {
			divBy3=1+minStepToOneTopDown(n/2,dp);
		}
		
		subBy1=1+minStepToOneTopDown(n-1,dp);
		
		return dp[n]=Math.min(divBy3,Math.min(divBy2,subBy1));
	}
	
	public int minStepToOneBottomUp(int n) {
		
		//initialize the DP array
		int [] dp=new int[n+1];
		//The 1st value, similar to base case of top down solution
		dp[0]=Integer.MAX_VALUE;//no use
		dp[1]=0;
		dp[2]=1;
		dp[3]=1;
		
		for(int i=4;i<=n;i++) {
			int divBy3=Integer.MAX_VALUE;
			int divBy2=Integer.MAX_VALUE;
			int subBy1=Integer.MAX_VALUE;
			
			if(i%3==0) {
				divBy3=1+dp[i/3];
			}
			if(i%2==0) {
				divBy2=1+dp[i/2];
			}
			subBy1=1+dp[i-1];
			dp[i]=Math.min(divBy3,Math.min(divBy2,subBy1));
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
	}
}

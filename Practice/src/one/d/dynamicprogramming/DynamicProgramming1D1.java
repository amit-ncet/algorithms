package one.d.dynamicprogramming;

public class DynamicProgramming1D1 {
	public static void main(String[] args) {
		DynamicProgramming1D1 d=new DynamicProgramming1D1();
		int k=2;
		long [] dp=d.flowersProblem(k);
		int a=4;
		int b=4;
		long result=dp[b]-dp[a-1];
		System.out.println(result);
		
	}
	
	/*
	 * Between red & white flower she can eat white flower in a group of k.
	 * Find the number of ways she can eat.
	 * 
	 * */
	public long[] flowersProblem(int k) {
		
		long [] dp=new long [100000];
		dp[0]=1;
		for(int i=1;i<dp.length;i++) {
			if(i<k) {
				dp[i]=dp[i-1];
			}else {
				dp[i]=dp[i-1]+dp[i-k];
			}
		}
		
		for(int i=1;i<dp.length;i++) {
			dp[i]=dp[i-1]+dp[i];
		}
		return dp;
	}
}

package dp;

public class RobMoneyFromHouse {
	public static void main(String[] args) {
		RobMoneyFromHouse rob=new RobMoneyFromHouse();
		int n=4;
		int [] houses=new int[] {6,2,3,9};
		int [] dp=new int[n];
		for(int i=0;i<dp.length;i++) {
			dp[i]=-1;
		}
		System.out.println(rob.robMoneyTopDown(houses,dp,n-1));
		System.out.println(rob.robMoneyBottomUp(houses,n));
	}
/*
 * Robber cannot rob adjcent houses. 
 * Find the combination in which he can Rob maximum money. 
 * */	
	public int robMoneyTopDown(int [] houses, int [] dp,int i) {
		//Base case
		if(i==0) {
			return dp[0]=houses[0];
		}
		if(i==1) {
			return dp[1]=Math.max(houses[0],houses[1]);
		}
		//Recursive task
		if(dp[i]!=-1) {
			return dp[i];
		}
		return dp[i]=Math.max((robMoneyTopDown(houses,dp,i-1)),(robMoneyTopDown(houses,dp,i-2)+houses[i]));
		//Self work
		//return dp[i];
		
	}
	
	public int robMoneyBottomUp(int [] houses,int n) {
		int [] dp=new int[n];
		dp[0]=houses[0];
		dp[1]=Math.max(houses[0],houses[1]);
		for(int i=2;i<n;i++) {
			dp[i]=Math.max(dp[i-1],dp[i-2]+houses[i]);
		}
		return dp[n-1];
		
	}
	
	
}

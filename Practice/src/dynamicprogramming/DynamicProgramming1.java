package dynamicprogramming;

import java.util.Arrays;

/*
 * https://unacademy.com/class/introduction-to-dynamic-programming-1/DCN0JKPJ
 * 
 * Dynamic Programming
 * 
 *	
 *	
 *	
 *	Mutual Exclusiveness: Can compute answer without any dependency on each other
 *
 *	Mutual Exhaustiveness: Explore all possiblities
 *
 *	How to identify if we need DP?
 *		-> Repeated/Overlapping subproblem:
 *			&
 * 			optimal substructure: If we want to compute optimal answer for the 
 * 			bigger problem then if we have optimal answer for the subproblem &
 * 			they contribute optimally to the bigger problem. So that the optimal
 * 			answer for the big problem can be constructed from optimal answer of
 * 			subproblems.
 * 
 * Top Down Dynamic Programming: (Big -> Small) : MEMOIZIATION (Recursive)
 * 				We start from a bigger subproblem and then move to
 * 					smaller subproblem
 * Bottom UP Dynamic Programming: (Small -> Big) : TABULATION (Iteratetive)
 * 				You start from the smallest subproblem and then move to 
 * 					biggest subproblem
 * 
 * State of the DP: Defined by 1 unique subproblem. The no. of parameters uniquely 
 * defining the subproblem gives us the dimensions of the DP.
 * */
public class DynamicProgramming1 {

	public static void main(String[] args) {
		DynamicProgramming1 dp = new DynamicProgramming1();
		//System.out.println(dp.fibonrec(5));
		int n=5;
		int [] dparr=new int [n+1];
		for(int i=0;i<dparr.length;i++) {
			dparr[i]=-1;
		}
		//System.out.println(dp.fibTopDown(n,dparr));
		
		//System.out.println(dp.fibBottomUp(5));
		
		int arr[]=new int[] {2,7,9,3,1};
		
		//System.out.println(dp.maxLootTopDown(n,n-1,arr,dparr));
		
		System.out.println(dp.maxLootBottomUp(n,arr));
	}

	/*
	 * 0,1,1,2,3,5,8,13.... Sum of previous 2 term
	 * Time complexity: O(2^n)
	 * Space Complexity: O(n)
	 * */
	public int fibonrec(int n) {
		//Base case
		if(n==0 || n==1)
			return n;
		//Recursive task
		return fibonrec(n-1)+fibonrec(n-2);
		//Self work
	}
	
	//topDown DP
	/*
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 * 	 * */
	public int fibTopDown(int n, int [] dp) {
		//Base case
		if(n==0 || n==1) {
			return n;
		}
		if(dp[n]!=-1) {
			return dp[n];
		}
		return dp[n]=fibTopDown(n-1,dp)+fibTopDown(n-2,dp);
	}
	
	/*
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 * 	 * */
	public int fibBottomUp(int n) {
		int dp[]=new int [n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			
			dp[i]=dp[i-1]+dp[i-2];
		}
		return dp[n];
	}
	
	
	
	
	/*
	 * 
	 * Max loot in N houses, 2 adjacent houses cannot be looted:
	 * 
	 * 
	 * */
	public int maxLootTopDown(int n,int idx,int arr[],int [] dp) {
		System.out.println("IDX: "+idx+" "+Arrays.toString(dp));
		//Base case
		if(idx==0 ) {
			return arr[0];
		}
		if(idx==1 ) {
			return Math.max(arr[0],arr[1]);
		}
		if(dp[idx]!=-1) {
			return dp[idx];
		}
		//Recursive assumption
		return dp[idx]=Math.max(maxLootTopDown(n,idx-1,arr,dp),maxLootTopDown(n,idx-2,arr,dp)+arr[idx]);
		
		//Self work
	}
	
	
	public int maxLootBottomUp(int n,int [] arr) {
		int [] dp=new int[n+1];
		dp[0]=arr[0];
		dp[1]=Math.max(arr[0],arr[1]);
		
		for(int i=2;i<n;i++) {
			dp[i]=Math.max(dp[i-1],dp[i-2]+arr[i]);
		}
		return dp[n-1];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

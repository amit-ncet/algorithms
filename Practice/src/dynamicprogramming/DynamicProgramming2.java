package dynamicprogramming;

import java.util.Arrays;

/*
 * https://unacademy.com/class/introdution-to-dynamic-programming-2/GQ8AAM2Y
 * 
 * */
public class DynamicProgramming2 {
	public static void main(String [] args) {
		DynamicProgramming2 dp=new DynamicProgramming2();
		
		int n=11;
		int [] dparr=new int[n+1];
		for(int i=0;i<dparr.length;i++) {
			dparr[i]=-1;
		}
		//dp.getNumberOrOperations(n,0);
		//System.out.println(dp.getNumberOrOperationsTopDown(n,dparr));
		//System.out.println(dp.getNumberOrOperationsBottomUp(n));
		//System.out.println(dp.result);
		
		dp.getMinimalCoinsSum(new int[] {1,5,7},11,0,0);
		System.out.println(dp.minStep);
		
		//System.out.println(dp.getMinimalCoinsSumTopDown(new int[] {1,5,7},n,dparr));
	
		//System.out.println(dp.getMinimalCoinsSumBottomUp(new int[] {1,5,7},n));
	}
	
	

	/*
	 * TC: O(n)
	 * SC: O(n)
	 * 
	 * */
	public int getNumberOrOperationsTopDown(int x,int [] dp) {
		//Base case
		if(x==1) {
			return 1;
		}
		if(x<1) {
			return Integer.MAX_VALUE;//Not a valid answer
		}
		
		if(dp[x]!=-1) {
			System.out.println("Optimization: "+x);
			return dp[x];
		}
		
		//Recursive task
		int res1=1+getNumberOrOperationsTopDown(x-1,dp);
		
		int res2=Integer.MAX_VALUE;;
		int res3=Integer.MAX_VALUE;;
		
		if(x%3==0)
			res2=1+getNumberOrOperationsTopDown(x/3,dp);
		if(x%2==0)
			res3=1+getNumberOrOperationsTopDown(x/2,dp);
		
		return dp[x]=Math.min(Math.min(res1,res2),res3);
		//Self work
		
	}
	
	public int getNumberOrOperationsBottomUp(int n) {
		int dp[] =new int [n+1];
		
		//Base cases
		dp[0]=Integer.MAX_VALUE;
		dp[1]=0;
		dp[2]=1;
		dp[3]=1;
		
		for(int i=4;i<=n;i++) {
			//3 options
			//int res=n-1;
			int res1=Integer.MAX_VALUE;
			int res2=Integer.MAX_VALUE;
			int res3=Integer.MAX_VALUE;
			
			if(i%3==0) {
				res3=1+dp[i/3];
			}
			if(i%2==0) {
				res2=1+dp[i/2];
			}
			res1=1+dp[i-1];
			dp[i]=Math.min(res1,Math.min(res2,res3));
		}
		System.out.println(Arrays.toString(dp));
		return dp[n];
		
	}



/*
 * Given a number , we can do 3 operations:
 * 1) Subtract 1 from X
 * 2) If x is divisible by 2, then divide it by 2
 * 3) If x is divisible by 3, then divide it by 3
 * 
 * Find the minimum number of operations it requires to reach 1 from X.
 * 
 * EX: 7 -> 
 * -1 =6 ->
 *  /3=2 ->
 *   /2 =1
 * 
 * Total step: 3
 * 
 */
	int result=Integer.MAX_VALUE;
	public void getNumberOrOperations(int x,int step) {
		System.out.println(x+" - "+step);
		//Base case
		if(x==1) {
			System.out.println(result+" ++++++++++ "+step);
			result=Math.min(result,step);
			return;
		}
		if(x<1) {
			return;
		}
		//Recursive task
		//I have 3 options from each step
		getNumberOrOperations(x-1,step+1);
		if(x%3==0) {
			System.out.println("x%3 : "+ x+" - "+step);
			getNumberOrOperations(x/3,step+1);
		}
			
		if(x%2==0) {
			System.out.println("x%2 : "+x+" - "+step);
			getNumberOrOperations(x/2,step+1);
		}
			
		//Self work
	}
	
	
	///#### MINIMIZING COINS #######
	
	/*
	 * Consider a money system consisting of coins, each coin has a positive 
	 * integer value. Produce the sum of money X using minimal number of coins. 
	 * If not possible, return -1.
	 * 
	 * EX: 1,5,7 target 11 : 5+5+1=11 -> 3 coins minimal
	 * 
	 * */
	int minStep=Integer.MAX_VALUE;
	public void getMinimalCoinsSum(int [] arr,int target,int sum,int step) {
		//Base case
		if(sum==target) {
			minStep=Math.min(step,minStep);
			return;
		}
		if(sum>target) {
			return;
		}
		
		//Recursive task
		for(int i=0;i<arr.length;i++) {
			getMinimalCoinsSum(arr,target,sum+arr[i],step+1);
		}
		//Self work
	}
	
	/*
	 * We will try to subtract all 
	 * */
	public int getMinimalCoinsSumTopDown(int [] arr, int sum,int [] dp) {
		//Base case
		if(sum==0) {
			return 0;
		}
		if(sum<0) {
			return Integer.MAX_VALUE;
		}
		
		if(dp[sum]!=-1) {
			return dp[sum];
		}
		//RECURSIVE TASK	
		int result=Integer.MAX_VALUE;
		System.out.println("sum: "+ sum);
		for(int i=0;i<arr.length;i++) {
			int recResult=getMinimalCoinsSumTopDown(arr,sum-arr[i],dp);
			if(recResult!=Integer.MAX_VALUE) {
				result=Math.min(result,1+recResult);
			}
		}
		return dp[sum]=result;
	}
	
	public int getMinimalCoinsSumBottomUp(int [] coins, int sum) {
		int [] dp=new int[sum+1];
		for(int i=0;i<dp.length;i++) {
			dp[i]=Integer.MAX_VALUE;
		}
		dp[0]=0;
		for(int i=1;i<=sum;i++) {
			for(int j=0;j<coins.length;j++) {
				if(coins[j]<=i) {
					System.out.println(Arrays.toString(dp));
					dp[i]=Math.min(dp[i],1+dp[i-coins[j]]);
				}
				
			}
		}
		
		//if[]
		return dp[sum];
	}
}

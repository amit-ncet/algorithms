package dynamicprogramming;

import java.util.Arrays;

/*
 * https://unacademy.com/class/introdution-to-dynamic-programming-2/GQ8AAM2Y
 * 
 * */
public class DynamicProgramming21 {
	public static void main(String [] args) {
		DynamicProgramming21 dp=new DynamicProgramming21();
		
		int n=11;
		int [] dparr=new int[n+1];
		for(int i=0;i<dparr.length;i++) {
			dparr[i]=-1;
		}
	
		
		//System.out.println(dp.getMaxSubsequenceBottomUp(8,new int[] {3,1,2,5,4,6,5,1}));
		
		//System.out.print(dp.getAllBinaryString(3));
		
		
		String [][] grid =new String [][] {
			{".",".",".",".","#"},
			{".",".",".",".","."},
			{".","#","#",".","."},
			{".",".",".",".","#"},
			{"#",".","#",".","."},
			{".",".",".#","#","."},
			{".",".","#",".","."}
		};
		
		System.out.println(dp.mazePathBottomUp(7,5,grid));
	}
	
	
	/*
	 * Find largest subsequence which is strictly increasing from an array
	 * 
	 * EX: 3,1,2,5,4,6,5,6
	 * Ans=> 5
	 * 
	 * */
	public int getMaxSubsequenceBottomUp(int n,int [] arr) {
		int [] dp=new int[n];
		//initialize dp with 1 as 1 is the minimum subsequence bossible at any indes
		for(int i=0;i<dp.length;i++)
			dp[i]=1;
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[i],1+dp[j]);
				}
			}
		}
		
		System.out.println(Arrays.toString(dp));
		int result=Integer.MIN_VALUE;
		for(int i=0;i<dp.length;i++)
			result=Math.max(result,dp[i]);
		return result;
	}
	
	
	/*
	 * For a given number n, find the count of possible binary string (0,1) 
	 * such that there is no consecutive 1's
	 * 
	 * Ex: n=3
	 * Ans: 5
	 * 100
	 * 101
	 * 010
	 * 000
	 * 001
	 * 
	 * */
	public int getAllBinaryString(int n) {
		//
		int dp[]=new int[n+1];
		dp[0]=1;
		dp[1]=2;
		
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		System.out.println(Arrays.toString(dp)+" "+n);
		return dp[n];
	}
	
	public int mazePathBottomUp(int row,int col,String grid[][]) {
		System.out.println(Arrays.deepToString(grid));
		int [][] dp=new int [row][col];
		
		for(int i=row-1;i>=0;i--) {
			for(int j=col-1;j>=0;j--) {
					dp[i][j]=1;
			}
			
		}
		System.out.println(Arrays.deepToString(dp));
		for(int i=row-1;i>=0;i--) {
			for(int j=col-1;j>=0;j--) {
				if(i==row-1 && j==col-1) {
					dp[i][j]=1;
				}
				else if(grid[i][j].equals("#")) {
					dp[i][j]=0;
				}else {
					int rowV=(i==row-1)?0:dp[i+1][j];
					int colV=(j==col-1)?0:dp[i][j+1];
					dp[i][j]=rowV+colV;
				}
			}
		}
		System.out.println(Arrays.deepToString(dp));
		return dp[0][0];
	}
}

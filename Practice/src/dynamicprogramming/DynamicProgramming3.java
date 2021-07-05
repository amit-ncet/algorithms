package dynamicprogramming;

import java.util.Arrays;

/*
 * https://unacademy.com/class/introduction-to-dynamic-programming-3/0Z3BGP6R
 * 
 * */
public class DynamicProgramming3 {

	public static void main(String[] args) {
		DynamicProgramming3 dp=new DynamicProgramming3();
		//System.out.println(dp.stoneGame(new int[] {2,3},7));
		//System.out.println(dp.getLongestSubsequence("axby","abcxby","axbxy"));
		int [][][] dpArr=new int [5+1][5+1][2];
		//System.out.println(dp.getLCS("12345","53142",0,0,1,dpArr));
		//getLCS(String st1,String st2,int i,int j,int k,int [][][] dp)
		
		System.out.println(dp.getLongestRepeatingSubsequence("AABEBCDD","AABEBCDD",0,0));
	}

	/*
	 * There is a set of N positive integers, Taro & Jayo plays
	 * We have pile of K stones. THe 2 players:
	 * 
	 * Taro & JAYO :Chose an element x in A, and removes exactly x stone from the pile
	 * 
	 * A player looses if he has no stone to play. Assuming both player plays optimally.
	 * 
	 * */
	
	public String stoneGame(int [] options,int k) {
		int [] dp=new int[k+1];
		
		for(int i=1;i<=k;i++) {
			for(int j=0;j<options.length;j++) {
				if(options[j]>i) {
					continue;
				}
				if(dp[i-options[j]]==0) {
					dp[i]=1;
				}
			}
		}
		System.out.println(Arrays.toString(dp));
		return dp[k]==1?"First":"Second";
	}
	
	/*
	 * You are given 3 strings, find the length of the longest common subsequence
	 * for the 3 strings
	 * 
	 * */
	public int getLongestSubsequence(String st1,String st2, String st3) {
		int m=st1.length();
		int n=st2.length();
		int o=st3.length();
		int [][][] dp=new int[m+1][n+1][o+1];
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=o;k++) {
					if(st1.charAt(i-1)==st2.charAt(j-1) && st2.charAt(j-1)==st3.charAt(k-1)) {
						//System.out.println(st1.charAt(i-1));
						dp[i][j][k]=dp[i-1][j-1][k-1]+1;
					}else {
						//System.out.println("else: "+st1.charAt(i-1));
						dp[i][j][k]=Math.max(dp[i-1][j][k],Math.max(dp[i][j-1][k],dp[i][j][k-1]));
					}
				}
			}
		}
		//System.out.println(Arrays.deepToString(dp));
		return dp[m][n][o];
	}
	
	
	/*
	 * You are given 2 strings, find the length of the longest common subsequence
	 * for the 2 strings. And have K as possible number of times we can change the 
	 * character of the string.
	 * 
	 * */
	public int getLCS(String st1,String st2,int i,int j,int k,int [][][] dp) {
		//Base case
		if(i==st1.length() || j==st2.length()) {
			return 0;
		}
		if(dp[i][j][k]!=-1) {
			System.out.println("DP logic called.");
			return dp[i][j][k];
		}
		if(st1.charAt(i)==st2.charAt(j)) {
			return  dp[i][j][k]=1+getLCS(st1,st2,i+1,j+1,k,dp);
		}else {
			if(k>0) {
				return  dp[i][j][k]=Math.max(getLCS(st1,st2,i+1,j,k,dp),Math.max(getLCS(st1,st2,i,j+1,k,dp),1+getLCS(st1,st2,i+1,j+1,k-1,dp)));
			}else {
				return  dp[i][j][k]=Math.max(getLCS(st1,st2,i+1,j,k,dp),getLCS(st1,st2,i,j+1,k,dp));
			}
		}
	}
	
	
	/*
	 * Given a string find the longest repeating subsequence
	 * */
	public int getLongestRepeatingSubsequence(String st1,String st2,int i,int j) {
		//Base case
		if(i==st1.length() || j==st2.length()) {
			return 0;
		}		
		//Recursive task
		if(st1.charAt(i)==st2.charAt(j) && i!=j) {
			return  1+getLongestRepeatingSubsequence(st1,st2,i+1,j+1);
		}else {
			return Math.max(getLongestRepeatingSubsequence(st1,st2,i+1,j),
					getLongestRepeatingSubsequence(st1,st2,i,j+1));
		}
		//Self work
	
	}
}
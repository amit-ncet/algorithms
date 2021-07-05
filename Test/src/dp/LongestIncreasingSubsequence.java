package dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		LongestIncreasingSubsequence ls=new LongestIncreasingSubsequence();
		int arr[] =new int[] {3,1,2,5,4,6,5,1};
		System.out.println(ls.getLongestSubsequence(arr,8));
	}
	
	/*
	 * Fjnd longest subsequence in strictly increasing order.
	 * Return the length
	 * */
	public int getLongestSubsequence(int [] arr,int n) {
		int [] dp=new int[n];
		for(int i=0;i<n;i++) {
			dp[i]=1;
		}
		
		for(int i=1;i<n-1;i++) {
			for(int j=0;j<i-1;j++) {
				if(arr[i]>arr[j]) {
					dp[i]=Math.max(dp[i],1+dp[i-1]);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(Arrays.toString(dp));
		return dp[dp.length-1];
	}
}

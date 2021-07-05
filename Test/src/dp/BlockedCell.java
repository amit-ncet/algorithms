package dp;

import java.util.Arrays;

public class BlockedCell {
	public static void main(String[] args) {
		BlockedCell ls=new BlockedCell();
		int m=7;
		int n=5;
		char grid[][] =new char[][] {
			{'0','0','0','0','#',},
			{'0','0','0','0','0',},
			{'0','#','#','0','0',},
			{'0','0','0','0','#',},
			{'#','0','#','0','0',},
			{'0','0','#','#','0',},
			{'0','0','#','0','0',}};
		
		int [][] dp=new int[m][n];
		
		dp[m-1][n-1]=1;
		for(int i=m-1;i>=1;i--) {
			for(int j=n-1;j>=1;j--) {
				if(i==m && j==n) {
					continue;
				}
				if(grid[i][j]=='#') {
					dp[i][j]=0;
					continue;
				}
				dp[i][j]=((i==m-1)?0:dp[i+1][j])+
						((j==n-1)?0:dp[i][j+1]);
			}
		}
		System.out.println(Arrays.deepToString(dp));
		System.out.println(dp[1][1]);
	}
	
	
}

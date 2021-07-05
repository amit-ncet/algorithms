package dp;

import java.util.List;

public class KStones {
	public static void main(String[] args) {
		KStones dp = new KStones();
		int n = 6;
		int[] dpa = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			dpa[i] = -1;
		}
		System.out.println(dp.getFibTopDown(n, dpa));
		
		System.out.println(dp.getFibBottomUp(n));
	}

	public int getStones(int n,int k,int [] arr) {
		System.out.println("FIRST");
		System.out.println("SECOND");
		
		return 1;
	}

}

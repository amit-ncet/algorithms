package test;

import java.util.Arrays;

public class BinarySearchProblem {

	public static void main(String[] args) {

		BinarySearchProblem bs=new BinarySearchProblem();
		int [] a=new int[]{-6, -2, 10, -7, 0, 8, -5, -10, 3, 3};
		int b[]=new int[] {-8, -7, -6, 0, 5, 8, 4, 3, -4, -4};

		System.out.println(bs.minDiffOfArrays(a,b));
	}

	int minDiffOfArrays(int[] a, int[] b) {
		int n = a.length;
		int minSum = 0;

		int[][] diff = new int[n][2];
		for (int i = 0; i < n; i++) {
			diff[i][0] = Math.abs(a[i] - b[i]);
			diff[i][1] = i;
		}
		Arrays.sort(diff, (a1, b1) -> Integer.compare(b1[0], a1[0]));
		//System.out.println(Arrays.deepToString(diff));

		int[] ser = new int[n];
		for (int i = 0; i < n; i++) {
			ser[i] = a[i];
		}
		Arrays.sort(ser);

		// find the nearest number
		int target = b[diff[0][1]];

		int res = binSearch(n, ser, target);

		//System.out.println(res);
		a[7] = res;

		for (int i = 0; i < n; i++) {
			minSum += Math.abs(a[i] - b[i]);
		}
		return minSum;
	}

	public int binSearch(int n, int[] ser, int target) {
		int l = 0;
		int r = n - 1;
		int last = 0;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (ser[mid] == target) {
				return ser[mid];
			} else if (target < ser[mid]) {
				// left
				r = mid - 1;
			} else {
				// right
				l = mid + 1;
			}
			last = ser[mid];
		}
		return last;
	}

}

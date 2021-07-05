import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][2];
		for (int i = 0; i < n; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = i;
		}
		
		System.out.println(Arrays.deepToString(arr));
		Arrays.sort(arr,
				Comparator.<int[]>comparingInt(a->a[0]).thenComparingInt(a->a[1]));

		System.out.println(Arrays.deepToString(arr));
		
		int [] segTree=new int[4*n];
		
		int [] result=new int [n];	
		
		for(int i=0;i<arr.length;i++) {
			int val=arr[i][0];
			int idx=arr[i][1];
			int res=query(segTree,0,n-1,1,0,idx-1);
			System.out.println("Range: "+0+"-"+(idx-1)+" result: "+res);
			update(result,segTree,0,n-1,1,idx,res+1);
		}
		
		int max=Integer.MIN_VALUE;
		for(int i=0;i<result.length;i++) {
			max=Math.max(max,result[i]);
		}
		System.out.println(Arrays.toString(result));
		System.out.println(Arrays.toString(segTree));
		System.out.println(max);
	}
	
	/*
	 * Find maximum element in the range
	 * */
	public static int query(int [] segTree,int s,int e, int tidx,int l,int r) {
		//Base case
		if(r<s || l>e) {
			return 0;
		}
		if(s>=l && e<=r) {
			return segTree[tidx];
		}
		int mid=(s+e)/2;
		int left=query(segTree,s,mid,2*tidx,l,r);
		int right=query(segTree,mid+1,e,2*tidx+1,l,r);
		return Math.max(left,right);
	}
	
	public static void update(int [] arr,int [] segTree,int s, int e, int tidx, int idx, int val) {
		//Base case
		if(s==e) {
			//Leaf node
			arr[idx]=val;
			segTree[tidx]=val;
			return;
		}
		int mid=(s+e)/2;
		if(idx>mid) {
			update(arr,segTree,mid+1,e,2*tidx+1,idx,val);
		}else {
			update(arr,segTree,s,mid,2*tidx,idx,val);
		}
		
		segTree[tidx]=Math.max(segTree[2*tidx],segTree[2*tidx+1]);
	}
}

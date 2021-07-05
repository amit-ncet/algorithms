package com.sum.range;

import java.util.Arrays;

/*
 * https://unacademy.com/class/mastering-range-queries-with-segment-trees/C0XZC4BH
 * 
 * https://unacademy.com/class/segment-tree-problem-solving/XRQWKA9R
 * 
 * */
public class SegmentTree {
	public static void main(String[] args) {
		int [] arr=new int[] {2,3,3,2,4,5,6,1};
		int n=arr.length;
		Integer.parseUnsignedInt()etI()
		int segmentTree[]=new int[4*n];
		build(arr,segmentTree,1,0,n-1);//for root node we will start at 1, for 1 based indexing	
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(segmentTree));
		
		System.out.println(query(segmentTree,1,0,n-1,2,4));
		update(arr,segmentTree,1,0,n-1,3,10);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(segmentTree));
		
		System.out.println(query(segmentTree,1,0,n-1,2,5));
	}
	
	public static void build(int [] arr,int [] segmentTree,int treeIndex,int start,int end) {
		//Base case
		if(start==end) {
			segmentTree[treeIndex]=arr[start];
			return;
		}
		
		int mid=(start+end)/2;
		build(arr,segmentTree,2*treeIndex,start,mid);
		build(arr,segmentTree,2*treeIndex+1,mid+1,end);
		segmentTree[treeIndex]=segmentTree[2*treeIndex]+segmentTree[2*treeIndex+1];
		
	}
	
	public static void update(int [] arr,int [] segmentTree,int treeIndex,int start,int end,int idx,int val) {
		//Base case
		if(start==end) {
			arr[idx]=val;
			segmentTree[treeIndex]=val;
			return;
		}
		
		int mid=(start+end)/2;
		if(idx>mid) {
			update(arr,segmentTree,2*treeIndex+1,mid+1,end,idx,val);
		}else {
			update(arr,segmentTree,2*treeIndex,start,mid,idx,val);
		}
		segmentTree[treeIndex]=segmentTree[2*treeIndex]+segmentTree[2*treeIndex+1];
	}
	
	public static int query(int [] segmentTree,int treeIndex,int start,int end,int left,int right) {
		if(start>right || end<left) {
			return 0;//completely outside
		}
		if(start>=left && end<=right) {
			return segmentTree[treeIndex];
		}
		
		int mid=(start+end)/2;
		int a1=query(segmentTree,2*treeIndex,start,mid,left,right);
		int a2=query(segmentTree,2*treeIndex+1,mid+1,end,left,right);
		return a1+a2;
	}
	
	/*
	 * Longest increasing subsequence
	 * 
	 * */
}

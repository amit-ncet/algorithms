package test;

/*
 You are given an array of integers a, where each element a[i] represents the length of a ribbon.
Your goal is to obtain k ribbons of the same length, by cutting the ribbons into as many pieces as you want.
Your task is to calculate the maximum integer length L for which it is possible to obtain at least k ribbons of length L by cutting the given ones.
Example
* For a = [5, 2, 7, 4, 9] and k = 5, the output should be cutTheRibbons(a, k) = 4.
 * */
import java.util.*;

class MaxCut {

	public static void main(String[] args) {
		MaxCut m=new MaxCut();
		int [] arr=new int [] {5, 2, 7, 4, 9};
		int k=5;
		System.out.println(m.findLargestCut(arr,k));
	}
	
	public int findLargestCut(int [] arr,int k) {
		//Find the largest size of ribon
		int max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			max=Math.max(max,arr[i]);
		}
		
		//Once we have the max element, that is the maximum size of cut we can do. This gives us the upper bound
		int l=1;
		int r=max;
		while(l<=r) {
			int mid=l+(r-l)/2;
			int pieces=getPossibleCuts(arr,mid);
			if(pieces<mid) {
				//go left
				r=mid-1;
			}else {
				//go right
				l=mid+1;
			}
		}
		return r;
	}

	private int getPossibleCuts(int[] arr, int target) {
		int pieces=0;
		for(int i=0;i<arr.length;i++) {
			pieces+=arr[i]/target;
		}
		return pieces;
	}
}

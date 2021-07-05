package test;

import java.util.Arrays;

public class WayFairRevision {
	public static void main(String [] args) {
		int arr[]=new int[] {1,2,3};
		WayFairRevision w=new WayFairRevision();
		//w.getSubarray(arr);
		//w.getSubstrings("ABC");
		int [] temp=new int[3];
		//w.getAllSubsequences(arr,temp,0);
		w.getAllPermutation(arr,0);
	}
	
	
	/*123
	 * 1
	 * 12
	 * 123
	 * 2
	 * 23
	 * 3
	 * 
	 * */	
	//	All Subarray of an Array
	public void getSubarray(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				for(int k=i;k<=j;k++) {
					System.out.print(arr[k]);
				}
				System.out.println();
			}
		}
	}
	
	//	All Substring of a String
	public void getSubstrings(String s) {
		for(int i=0;i<=s.length();i++) {
			for(int j=i+1;j<=s.length();j++) {
				System.out.println(s.substring(i,j));
			}
		}
	}
	
	/*
	 * 123
	 * 1
	 * 12
	 * 123
	 * 13
	 * 2
	 * 23
	 * 3
	 */
	//All Subsequence of an array & String	
	public void getAllSubsequences(int [] arr,int [] temp,int i) {
		//Base case
		if(i==arr.length) {
			printArray(arr,temp);
			return;
		}
		//Recursive task
		temp[i]=1;
		getAllSubsequences(arr,temp,i+1);
		temp[i]=0;
		getAllSubsequences(arr,temp,i+1);
		//Self work
		
	}

	public void printArray(int [] arr,int [] temp) {
		for(int i=0;i<arr.length;i++) {
			if(temp[i]==1) {
				System.out.print(arr[i]+" ");
			}
		}
		System.out.println();
	}
	
	/*
	 * 123
	 * 
	 * 123
	 * 132
	 * 213
	 * 231
	 * 312
	 * 321
	 * 
	 */
	//	All Permutations of an Array & String
	public void getAllPermutation(int [] arr, int i) {
		//Base case
		if(i==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		//Recursive task
		for(int j=i;j<arr.length;j++) {
			swap(arr,i,j);
			getAllPermutation(arr,i+1);
			swap(arr,j,i);
		}
		
	}
	
	public void swap(int [] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}

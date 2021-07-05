package revision;

import java.util.*;

public class RevisionApril4 {
	
	public static void main(String [] args) {
		RevisionApril4 rev=new RevisionApril4();
		int [] arr=new int[] {1,2,3};
		rev.getAllSubArray(arr);
		//rev.getAllSubStrings("ABC");
		//rev.getAllSubSequencesArray(arr,new int[arr.length],0);
		//rev.getAllSubsequencesString("ABC".toCharArray(),new int[3],0);
		//rev.getAllPermutationOfArray(arr,0);
		//rev.getAllPermutationsOfString("ABCD".toCharArray(),0);
	}
	
	
	//	All Subarray of an Array
	/*
	 * [1,2,3]
	 * [1]
	 * [1,2]
	 * [1,2,3]
	 * [2]
	 * [2,3]
	 * [3]
	 * 
	 * Time Complexity: = No of possible sub array: n*(n+1)/2
	 * Ex: 3*(3+1)/2 = 3*2 = 6 possible combinations
	 * */
	public void getAllSubArray(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				for(int k=i;k<=j;k++) {
					System.out.print(arr[k]+" ");
				}
				System.out.println();
			}
		}
	}
	
	//	All Substring of a String
	/*
	 * Time complexity: n*(n+1)/2 All possible substrings
	 */
	public void getAllSubStrings(String str) {
		for(int i=0;i<=str.length();i++) {
			for(int j=i;j<=str.length();j++) {
				System.out.print(str.substring(i,j)+" ");
			}
			System.out.println();
		}
	}
	
	
	//	All Subsequence/Subset of an array & String
	/*
	 * [1,2,3]
	 * [1]
	 * [1,2]
	 * [1,2,3]
	 * [1,3]
	 * [2]
	 * [2,3]
	 * [3]
	 * 
	 * Time complexity: No. of possible subsequences (2^N-1)
	 * */
	public void getAllSubSequencesArray(int [] arr,int [] temp,int i) {
		//Base Case
		if(i==arr.length) {
			//System.out.print(Arrays.toString(temp));
			//logic to print array
			for(int j=0;j<arr.length;j++) {
				if(temp[j]==1) {
					System.out.print(arr[j]+" ");
				}
			}
			System.out.println();
			return;//
		}
		
		//Recursive task
		temp[i]=1;
		//System.out.println("i= "+i+" "+Arrays.toString(temp));
		getAllSubSequencesArray(arr,temp,i+1);
		temp[i]=0;//Reset the value and invoke the method again;
		getAllSubSequencesArray(arr,temp,i+1);
	}
	
	public void getAllSubsequencesString(char [] ch, int [] temp,int i) {
		//Base case
		if(i==ch.length) {
			//Print array
			for(int j=0;j<ch.length;j++) {
				if(temp[j]==1) {
					System.out.print(ch[j]+" ");
				}
				
			}	
			System.out.println();
			return;
		}
		temp[i]=1;
		getAllSubsequencesString(ch,temp,i+1);
		temp[i]=0;
		getAllSubsequencesString(ch,temp,i+1);
	}
	

	
	//	All Permutations of an Array & String
	/*
	 * [1,2,3]
	 * 
	 * [1,2,3]
	 * [1,3,2]
	 * [2,1,3]
	 * [2,3,1]
	 * [3,1,2]
	 * [3,2,1]
	 * 
	 * Time Complexity: N!
	 */
	public void getAllPermutationOfArray(int [] arr,int i) {
		if(i==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int j=i;j<arr.length;j++) {
			swap(arr,i,j);
			getAllPermutationOfArray(arr,i+1);
			swap(arr,j,i);
			
		}
	}
	
	public void swap(int [] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	
	public void getAllPermutationsOfString(char[] arr,int i) {
		if(i==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int j=i;j<arr.length;j++) {
			swap(arr,i,j);
			getAllPermutationsOfString(arr,i+1);
			swap(arr,j,i);
		}
	}
	
	public void swap(char[] arr,int i,int j) {
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}	
}

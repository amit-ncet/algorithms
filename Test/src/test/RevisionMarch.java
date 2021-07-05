package test;

import java.util.*;

public class RevisionMarch {
	public static void main(String[] args) {
		int [] arr=new int[] {1,2,3};
		String str="ABC";
		RevisionMarch r=new RevisionMarch();
		//System.out.println(r.getAllSubArrays(arr));
		//System.out.println(r.getAllSubStrings(str));
		
		int [] temp=new int[arr.length];
		//r.getAllSubsequences(arr,temp,0);
		
		int [] temp1=new int[arr.length];
		//r.getAllSubsequencesString("ABC".toCharArray(),temp1,0);
		
		//r.getAllPermutations("ABC","");
		r.getAllPermutations(arr,0);
		System.out.println();
		r.getAllPermutationsString("ABC".toCharArray(),0);
	}
	
	//All Subarray of an Array
	/*
	 * [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]
	 * */
	public List<List<Integer>> getAllSubArrays(int [] arr){
		List<List<Integer>> results=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				List<Integer> result=new ArrayList<>();
				for(int k=i;k<=j;k++) {
					result.add(arr[k]);
				}
				results.add(result);
			}
		}
		return results;
	}
	
	//All Substring of a String
	//"ABC": [A, AB, ABC, B, BC, C]
	public List<String> getAllSubStrings(String s){
		List<String> results=new ArrayList<>();
		for(int i=0;i<=s.length();i++) {
			for(int j=i+1;j<=s.length();j++) {
				results.add(s.substring(i,j));
			}
		}
		return results;
	}
	
	//All Subsequence of an array & String
	/*
	 * {1,2,3} 
	 * {1} 
	 * {1,2} 
	 * {1,2,3} 
	 * {1,3} 
	 * {2}
	 * {2,3}
	 * {3}
	 * 
	 * */
	public void getAllSubsequences(int[] arr,int [] temp,int i) {
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
		//skip the arr with index 0
		for(int i=0;i<arr.length;i++) {
			if(temp[i]==1) {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}
	
	
	public void getAllSubsequencesString(char[] arr,int [] temp,int i) {
		//Base case
		if(i==arr.length) {
			printString(arr,temp);
			return;
		}
		//Recursive task
		temp[i]=1;
		getAllSubsequencesString(arr,temp,i+1);
		temp[i]=0;
		getAllSubsequencesString(arr,temp,i+1);
		//Self work
		
		
	}
	
	public void printString(char [] arr,int [] temp) {
		//skip the arr with index 0
		for(int i=0;i<arr.length;i++) {
			if(temp[i]==1) {
				System.out.print(arr[i]);
			}
		}
		System.out.println();
	}
	
	
	
	//All Permutations of an Array & String
	/* "ABC"
	 * 
	 * ABC
	 * ACB
	 * BAC
	 * BCA
	 * CAB
	 * CBA
	 * 
	 * */
	public void getAllPermutations(String s,String osf) {
		//Base case
		if(s.isEmpty()) {
			System.out.println(osf);
			return;
		}
		//Recursive task
		for(int i=0;i<s.length();i++) {
			char temp=s.charAt(i);
			String ros=s.substring(0,i)+s.substring(i+1);
			getAllPermutations(ros,osf+temp);
		}
		//Self work
	}
	
	public void getAllPermutations(int [] arr,int i) {
		//Base case
		if(i==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		//Recursive task
		for(int j=i;j<arr.length;j++) {
			swap(arr,i,j);
			getAllPermutations(arr,i+1);
			swap(arr,j,i);
		}		
		//Self work
	}
	
	public void swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public void getAllPermutationsString(char [] arr,int i) {
		//Base case
		if(i==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		//Recursive task
		for(int j=i;j<arr.length;j++) {
			swapChar(arr,i,j);
			getAllPermutationsString(arr,i+1);
			swapChar(arr,j,i);
		}		
		//Self work
	}
	
	public void swapChar(char arr[],int i,int j) {
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}

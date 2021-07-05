package revision;

import java.util.Arrays;

public class RevisionJune3 {
	public static void main(String[] args) {
		RevisionJune3 r=new RevisionJune3();
		
		//		All Subarray of an Array
		r.subArray(new int[] {1,2,3});
		//		All Substring of a String
		r.subString("ABC");
		System.out.println("--------");
		//		All Subsequence/Subset of an array & String
		r.subsequence("ABC".toCharArray(),new int[3],0);
		System.out.println("--------");
		r.subsequenceArr(new int [] {1,2,3},new boolean[3],0);
		
		System.out.println("----permutationOfString----");
		r.permutationOfString("AB".toCharArray(),0);
		//		All Permutations of an Array & String
		
	}
	
	/*ABC
	 * 
	 * ABC
	 * ACB
	 * BAC
	 * BCA
	 * CAB
	 * CBA
	 * 
	 * Each character will move the each index once and backtrack to original
	 * before invoking the next call
	 * */
	public void permutationOfString(char [] str,int j) {
		System.out.println(Arrays.toString(str)+" j: "+j);
		//Base case
		if(j==str.length) {
			System.out.println(str);
			return;
		}
		
		//Recursive task
		for(int i=j;i<str.length;i++) {
			swap(str,i,j);
			permutationOfString(str,j+1);
			swap(str,j,i);
		}
	}
	
	public void swap(char[] arr,int i,int j) {
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public void subsequenceArr(int [] arr,boolean [] temp,int idx) {
		//Base case
		if(idx==arr.length) {
			for(int i=0;i<temp.length;i++) {
				if(temp[i])
					System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}
		//Recursive task
		temp[idx]=true;
		subsequenceArr(arr,temp,idx+1);
		temp[idx]=false;
		subsequenceArr(arr,temp,idx+1);
	}
	
	/*
	 * ABC
	 * 
	 * A
	 * AB
	 * AC
	 * ABC
	 * B
	 * BC
	 * C
	 * 
	 * Every character can decide to exist or not exist once
	 * 
	 * O(n)= 2^(N-1)
	 * */
	public void subsequence(char[] s,int [] arr,int idx) {
		//Base case
		if(idx==s.length) {
			for(int i=0;i<arr.length;i++) {
				if(arr[i]==1) {
					System.out.print(s[i]);
				}
			}
			System.out.println();
			return;
		}
		
		arr[idx]=1;//1 means included
		subsequence(s,arr,idx+1);//First choice for the character is to be included
		//Reset the idx value while backtracking
		arr[idx]=0;//0 means excluded
		subsequence(s,arr,idx+1);//2nd choice for the character is to be excluded
	}
	
	
	/*
	 * 1
	 * 12
	 * 123
	 * 2
	 * 23
	 * 3
	 * 
	 * O(n) = n*(n+1)/2
	 * 
	 * */
	public void subArray(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				for(int k=i;k<=j;k++)
					System.out.print(arr[k]);
				System.out.println();
			}
		}
	}
	
	/*
	 * A
	 * AB
	 * ABC
	 * B
	 * BC
	 * C
	 * */
	public void subString(String s) {
		for(int i=0;i<=s.length();i++) {
			for(int j=i+1;j<=s.length();j++) {
				System.out.println(s.substring(i,j));
			}
		}
	}
}

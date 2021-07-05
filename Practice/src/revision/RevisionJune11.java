package revision;

public class RevisionJune11 {
	public static void main(String[] args) {
		RevisionJune11 r=new RevisionJune11();
		
		//All Subarray of an Array
		//r.subArray(new int[] {1,2,3});
		//All Substring of a String
		//r.substrings("ABC");
		//All Subsequence/Subset of an array & String
		//r.getAllSubsequences(new int[] {1,2,3},new int[3],0);
		//All Permutations of an Array & String
		r.getAllPermutation("ABC".toCharArray(),0);

	}
	
	/*[1,2,3]
	 * 
	 * [1]
	 * [1,2]
	 * [1,2,3]
	 * [2]
	 * [2,3]
	 * [3]
	 * 
	 * Time Complexity: O(n*(n+1)/2)
	 * 
	 * */
	public void subArray(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				for(int k=i;k<=j;k++) {
					System.out.print(arr[k]);
				}
				System.out.println();
			}
		}
	}
	
	public void substrings(String str) {
		for(int i=0;i<=str.length();i++) {
			for(int j=i+1;j<=str.length();j++) {
				System.out.println(str.substring(i,j));
			}
		}
	}
	
	/*
	 * [1,2,3]
	 * 
	 * [1]
	 * [1,2]
	 * [1,2,3]
	 * [1,3]
	 * [2]
	 * [2,3]
	 * [3]
	 * 
	 * Every element will be included & excluded once
	 * 
	 * Time complexity: O(2^n-1)
	 * 
	 * */
	public void getAllSubsequences(int [] arr,int [] temp,int idx) {
		//Base case
		if(idx==arr.length) {
			//print subsequence
			for(int i=0;i<temp.length;i++) {
				if(temp[i]==1) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
			return;
		}
		
		//Recursive task
		temp[idx]=1;//include
		getAllSubsequences(arr,temp,idx+1);
		temp[idx]=0;//Exclude it for backtracking
		getAllSubsequences(arr,temp,idx+1);
	}
	
	/*
	 * ABC
	 * 
	 * ABC
	 * ACB
	 * BAC
	 * BCA
	 * CAB
	 * CBA
	 * 
	 * Time complexity: O(n!)
	 * */
	public void getAllPermutation(char [] ch,int i) {
		//Base case
		if(i==ch.length) {
			//pring permutation
			System.out.println(ch);
			return;
		}
		
		//Recursive task
		//For every index we need to swap once
		for(int j=i;j<ch.length;j++) {
			swap(ch,i,j);
			getAllPermutation(ch,i+1);
			swap(ch,j,i);//Reset the swap for backtracking
		}
	}
	
	private void swap(char [] ch, int i,int j) {
		char temp=ch[i];
		ch[i]=ch[j];
		ch[j]=temp;
	}
}

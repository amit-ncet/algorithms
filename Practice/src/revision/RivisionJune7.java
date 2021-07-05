package revision;

import java.util.Arrays;

public class RivisionJune7 {
	public static void main(String [] args) {
		RivisionJune7 r=new RivisionJune7();
		
//		All Subarray of an Array
		//r.subArray(new int[] {1,2,3});
//		All Substring of a String
		//r.subString("ABC");
//		All Subsequence/Subset of an array & String
	//	r.subSequences(new int[] {1,2,3},new int[3],0);
//		All Permutations of an Array & String
		r.permutation(new int[] {1,2,3},0);

	}
	
	/*
	 *  O(n)=n*(n+1)/2
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
	
	/*
	 *  O(n)=n*(n+1)/2
	 *  
	 * */
	public void subString(String str) {
		for(int i=0;i<=str.length();i++) {
			for(int j=i+1;j<=str.length();j++) {
				System.out.println(str.substring(i,j));
			}
		}
	}
	
	/*
	 * 123
	 * 1
	 * 12
	 * 13
	 * 2
	 * 23
	 * 3
	 * Every element will be present & absent once
	 * 
	 * O(n): 2^(N-1)
	 * 
	 * */
	public void subSequences(int [] arr,int [] temp,int idx) {
		//Base case
		if(idx==arr.length) {
			//Logic to print the subsequence
			for(int i=0;i<temp.length;i++) {
				if(temp[i]==1)
					System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}
		
		//Recursive task 
		temp[idx]=1;//Include the element
		subSequences(arr,temp,idx+1);
		temp[idx]=0;//Exclude the element
		subSequences(arr,temp,idx+1);
				
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
	 * Need to swap each element once
	 * 
	 * O(n)=N!
	 * 
	 * */
	public void permutation(int [] arr,int idx) {
		//Base case
		if(idx==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		//start from current index swap till end of the string
		for(int i=idx;i<arr.length;i++) {
			swap(arr,i,idx);
			permutation(arr,idx+1);
			swap(arr,idx,i);//For backtracking revert it to the original state
		}
	}
	
	public void swap(int [] arr,int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}

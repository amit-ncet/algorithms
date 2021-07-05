package test;

import java.util.*;


public class SquareSum {
	public static void main(String[] args) {
		SquareSum sp=new SquareSum();
		long startTime = System.currentTimeMillis();


		
		///
		int [] a1=new int[] {3, -1, 9};
		int [] b1=new int[] {100, 5, -2};
		int upper=99;
		int lower=7;
		int count=0;
		if(a1.length<b1.length) {
			Arrays.parallelSort(b1);
			count+=sp.getSquaredSum(a1,b1,upper,lower);
		}else {
			Arrays.parallelSort(a1);
			count+=sp.getSquaredSum(b1,a1,upper,lower);
		}
		System.out.println("Result is: "+count);
		
		
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("milliseconds : "+elapsedTime);
		
	}
	/*
	 *  You are given two arrays of integers a and b, and two integers lower and upper.
	 *  Your task is to find the number of pairs (i, j) 
	 *  such that lower ≤ a[i] * a[i] + b[j] * b[j] ≤ upper.
	 *  
	 *  a = [  3, 9, 2,1], 9 100-9=91 9<=
	 *  20  (20-9)+
	 *  b = [ -2, 5,6,8, 100], 
	 *  
	 *  lower = 20, and upper = 99, 
	 *  the output should be boundedSquareSum(a, b, lower, upper) = 4.
	 */
	public int getSquaredSum(int [] a1,int [] b1,int upper,int lower) {
		System.out.println(Arrays.toString(a1));
		System.out.println(Arrays.toString(b1));
		List<Integer> range=null;
		//System.out.println(binarySearch(b1, 11, 0, b1.length,range));
		System.out.println("Range: "+range);
		
		for(int i=0;i<a1.length;i++) {
			binarySearch(b1, a1[i], 0, b1.length-1,upper,lower);
			//count+=possibleCount;		
			System.out.println("For the number: "+a1[i]+" Min possible: "+count+" max_possible is: "+count);
		}
		return count;
	}
	int count=0;
	//1 3 2 5 7 4 
	public void binarySearch(int [] arr,int val,int left, int right,int u,int l) {
		
		//List<Integer> mids=
		if(right>=left) {
			int mid=left+(right-left)/2;
			
			//System.out.println("Item  : "+arr[mid]);
			int sum=(val*val)+(arr[mid]*arr[mid]);
			if(sum>l && sum<u){
				
				count++;
				binarySearch(arr,val,mid+1,right,u,l);
				binarySearch(arr,val,left,mid-1,u,l);
			}
		}
	}
	
}

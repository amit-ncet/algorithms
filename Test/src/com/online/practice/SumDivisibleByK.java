package com.online.practice;

import java.util.Arrays;

/*
 * 
 * You are given an array of integers a and an integer k. 
 * Your task is to calculate the number of ways to pick two different indices i < j, 
 * such that a[i] + a[j] is divisible by k.

Example

For a = [1, 2, 3, 4, 5] and k = 3, the output should be sumsDivisibleByK(a, k) = 4.

There are 4 pairs of numbers that sum to a multiple of k = 3:

a[0] + a[1] = 1 + 2 = 3
a[0] + a[4] = 1 + 5 = 6
a[1] + a[3] = 2 + 4 = 6
a[3] + a[4] = 4 + 5 = 9
Input/Output

The number of ways to pick two different numbers from a, such that their sum is divisible by k.


 * 
 * */
public class SumDivisibleByK {
	public static void main(String[] args) {
		int [] arr=new int[] {1, 2, 3, 4, 5};
		int k=3;
		getAllSumDivisibleByK(arr,k);
	}

	public static int getAllSumDivisibleByK(int[] arr, int k) {
		//Let's prepare a remainder array which can be in the range of 0 to k-1
		int [] remainders=new int[k];
		for(int i=0;i<arr.length;i++) {
			remainders[arr[i]%k]=remainders[arr[i]%k]+1;
		}
		System.out.println(Arrays.toString(remainders));
		return 1;
	}
}

package test;

import java.util.*;


public class StringTest {
	public static void main(String[] args) {
		String s = "gfgfgfgfgfgfgfgfgfgfgfgfgfgfgf";
		StringTest sp=new StringTest();
		long startTime = System.currentTimeMillis();
		System.out.println("COUTNN : "+sp.getUniqueSubstrings(s));
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("milliseconds : "+elapsedTime);
		
		
		///
		int [] arr=new int[] {9, 8, 4, 9, 3};
		System.out.println(sp.getContigiousSubArray(arr));
	}
	
	
	public int getUniqueSubstrings(String s) {
		int count=0;
		for(int i=1;i<s.length();i++) {
			for(int j=i+1;j<s.length();j++) {
				// divide in two part, the left over part is the 3rd string
				//String a=s.substring(0,i);//0-i
				//String b=s.substring(i,j);//i-j
				//String c=s.substring(j);//j-end
				//System.out.println("ab= "+a+b+" bc= "+b+c+" ca= "+c+a+" a+b+c : "+a+b+c);
				
				String ab=s.substring(0,j);
				String bc=s.substring(i,s.length());
				String ca=s.substring(j,s.length())+s.substring(0,i);
				
				
				
				if(!ab.equals(bc) && !bc.equals(ca) && !ca.equals(ab)) {
					//System.out.println("Next ab= "+ab+" bc= "+bc+" ca= "+ca);
					count++;
				}
				
			}
		}
		return count;
	}
	
	
	
	
	 
	/*
	 * You are given an array of integers arr. Your task is to count the number of contiguous subarrays,
	 *  such that elements of the subarray are arranged in strictly decreasing order.
	 *  if arr = [9, 8, 4, 9, 3], then the subarray [9, 8, 4] 
	 *
	 * */
	
	
	
	public int getContigiousSubArray(int [] arr) {
		//List<List<Integer>> list=new ArrayList<>();
		int coun=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				boolean isDecreasing=true;
				for(int k=i;k<j;k++) {
					//System.out.println("k "+k);
					System.out.print(arr[k]+" "+" ");
					if(arr[k]<=arr[k+1]) {
						isDecreasing=false;
						break;
					}
					
				}
				if(isDecreasing)
					coun++;	
				System.out.println("");
			}
		}
		System.out.println("cpunt: "+coun);
		
		return coun;
	}
	
	
	
	
}

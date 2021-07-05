package test;

import java.util.*;

public class RevisionMarch2 {
	public static void main(String[] args) {
		RevisionMarch2 r=new RevisionMarch2();
		//System.out.println(r.getSubArray(new int[] {1,2,3,4,5}));
		
		//System.out.println(r.getSubStrings("abc"));
		List<String> sub=new ArrayList<>();
		//r.getSubSequenceString("abc",sub);
		//System.out.println(sub);
		char [] arr=new char[] {'A','B','C'};
		int [] sarr=new int[3];
		List<List<Integer>> temp=new ArrayList<>();
		//r.getSubsequenceArray(arr,7);
		r.printSubsequences(arr,0,new char[arr.length]);
		//System.out.println(temp);
	}
	
	/*
	 * 1,2,3
	 * 1
	 * 1,2
	 * 1,2,3
	 * 2
	 * 2,3
	 * 3
	 * 
	 * */
	//No recursion
	public List<List<Integer>> getSubArray(int [] arr){
		List<List<Integer>> results=new ArrayList<>();
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				List<Integer> li=new ArrayList<>();
				for(int k=i;k<=j;k++) {
					//System.out.print(arr[k]);
					li.add(arr[k]);
				}
				results.add(li);
				//System.out.println();
			}
		}
		return results;
	}
	
	/*	abc
	 * 
	 *  a
	 *  ab
	 *  abc
	 *  b
	 *  bc
	 *  c
	 * 
	 * */
	public List<String> getSubStrings(String str){
		List<String> res=new ArrayList<>();
		
		for(int i=0;i<str.length();i++) {
			StringBuilder sb=new StringBuilder();
			for(int j=i;j<str.length();j++) {
				sb.append(str.charAt(j));
				//System.out.println(sb.toString());
				res.add(sb.toString());
			}
		}
		return res;
	}
	
	/*
	 * 1,2,3,4
	 * 
	 * 1
	 * 1,2
	 * 1,2,3
	 * 1,2,3,4
	 * 1,3
	 * 1,3,4
	 * 1,4
	 * 2
	 * 2,3,4
	 * 2,4
	 * 3
	 * 3,4
	 * 4
	 * 
	 * */
	
	/*
	 * abc
	 * a
	 * ab
	 * abc
	 * ac
	 * b
	 * bc
	 * c
	 * 
	 * 
	 * 
	 * */
	public void getSubSequenceString(String str,List<String> res) {
		//base case
		if(str.length()==0) {
			res.add("");
			return;
		}
		
		//recursive intutition 
		//get sub sequence for rest of the string from index 1
		getSubSequenceString(str.substring(1),res);
		
		//self case
		//append the 1 string to rest of the result
		int n=res.size();
		for(int i=0;i<n;i++) {
			res.add(str.substring(0,1)+res.get(i));
		}
		
	}
		
	
	//Time Complexity: O(2^n)
	private void printSubsequences(char [] arrInput, int index, char [] temp){
        if(index==arrInput.length){
            print(arrInput,temp);
            return;
        }
        //set the current index bit and solve it recursively
        temp[index] = '1';
        printSubsequences(arrInput,index+1,temp);
        //System.out.println(Arrays.toString(temp));
        //unset the current index bit and solve it recursively
        temp[index] = '0';
        printSubsequences(arrInput,index+1,temp);
    }

    private void print(char [] arrInput, char [] temp){
        String result = "";
        for (int i = 0; i <temp.length ; i++) {
            if(temp[i]=='1')
                result += arrInput[i]+" ";
        }
        if(result=="")
            result = "{}";
        System.out.println(result);
    }
    
}

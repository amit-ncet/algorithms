package recursion;

import java.util.HashSet;
import java.util.Set;

/*
 * https://www.youtube.com/watch?v=sOD33g0Ede0
 * 
 * */
public class Recursion3 {
	public static void main(String [] args) {
		Recursion3 r=new Recursion3();
		//int[][] matrix=new int[3][3];
		//r.mazePath(3,3,0,0,"");
		//System.out.println(r.totalPath);
		
		//r.dicePath(7,0,"");
		//r.printLexiographical(113,0);
		r.permutationOfString("AACC","");
	}
	
	public void printLexiographical(int n,int idx) {
		//Base case
		if(idx>n) {
			return;
		}
		//Self work - Print itself
		System.out.println(idx);
		
		//Recursive task
		//We have 9 or 10 possible option for each idx value
		for(int i=(idx==0?1:0);i<=9;i++) {
			printLexiographical(n,10*idx+i);
		}
		
		
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
	 * 
	 * */
	public void permutationOfString(String str,String osf) {
		//System.out.println("str: "+str+" osf: "+osf);
		//Base case
		if(0==str.length()) {
			System.out.println(osf);
			return;
		}
		//Recursive intuition
		Set<String> visited=new HashSet<>();
		for(int i=0;i<str.length();i++) {
			String subString=String.valueOf(str.charAt(i));
			if(!visited.contains(subString)) {
				visited.add(subString);
				String restOfString=str.substring(0,i)+str.substring(i+1,str.length());
				permutationOfString(restOfString,osf+subString);
			}
		}
		//Self work
	}
	/*
	 * AAC
ACA
//AAC
//ACA
CAA
//CAA
	 * */
	
	public void dicePath(int n,int idx,String osf) {
		//Base case
		if(idx>=n) {
			return;
		}
		if(idx==n-1) {
			System.out.println(osf);
		}
		
		for(int i=1;i<=6;i++) {
			dicePath(n,idx+i,osf+i+"->");
		}
	}
	
	
	/*
	 * Given a M*N matrix, where we can move just right & down.
	 * Print & count all possible ways to reach the end point.
	 * 
	 * */
	int totalPath=0;
	public void mazePath(int m, int n, int i,int j, String osf) {
		//Base case
		if(i==m-1 && j==n-1) {
			totalPath++;
			System.out.println(osf);
			return;
		}
		if(i>=m || j>=n) {
			return;
		}
		//Recursive intuition
		mazePath(m,n,i,j+1,osf+"R");
		mazePath(m,n,i+1,j,osf+"D");
		mazePath(m,n,i+1,j+1,osf+"->");
		//Self work
		
		//return 1;
	}
	
}

package test;

import java.util.HashSet;
import java.util.Set;

public class RecursionMaster {
	public static void main(String[] args) {
		RecursionMaster m=new RecursionMaster();
		//System.out.println("power: "+m.power(10, 6));
		int [] arr=new int[] {1,2,3};
		
//		System.out.println(m.factorial(5));
		//System.out.println(m.fib(3));
		//System.out.println(m.countBinaryStrings(5));
		//m.arraySubSet(arr);
		m.mazePath(0, 0, 3, 3, "");
		//m.jumpSteps(0, 4, "");
		//m.getLexiographicalNumbers(1005,0);
		//m.printAllPermutation("ABC", "");
		
	}
	//Recurrence
	//work while going up/down
	//Recursion tree
	
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
	 * BC
	 * 
	 * CB
	 * 
	 * */
	void printAllPermutation(String s,String osf) {
		//Base case
		if(s.length()==0) {
			System.out.println(osf);
			return;
		}
		
		//System.out.println(osf);
		//Recursive intuition
		Set<Character> visited=new HashSet<>();
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			//if(!visited.contains(c)) {
				String res=s.substring(0,i)+s.substring(i+1,s.length());
				//visited.add(c);
				printAllPermutation(res,osf+c);
			//}
		}
		//Self work
	}
	
	
	void getLexiographicalNumbers(int n,int i) {
		//base case
		if(i>n) {
			return;
		}
		//self work
		System.out.println(i);
		
		//recursive intuition
		for(int j=(i==0?1:0);j<=9;j++) {
			getLexiographicalNumbers(n,10*i+j);
		}
		
		
	}
	
	
	void mazePath(int i,int j,int n,int m,String osf) {
		//System.out.println("i: "+i+" j: "+j+" m: "+m+" n: "+n+" osf: "+osf);
		if(i==n-1 && j==m-1) {
			System.out.println(osf);
			osf="";
			return;
		}
		if(i>=n || j>=m) {
			//crossed the matrix
			return;
		}
		mazePath(i,j+1,n,m,osf+"R");
		mazePath(i+1,j,n,m,osf+"D");
		mazePath(i+1,j+1,n,m,osf+"->");
	}
	
	void jumpSteps(int i,int n,String osf) {
		//base case 1 path 1, 2 =2
		
		if(i==n-1) {//reached the destination
			System.out.println(osf);
			return;
		}
		if(i>=n) {
			return;//the jump is cross the last cell
		}
		for(int j=1;j<=6;j++) {
			jumpSteps(i+j,n,osf+"->"+j);
		}
		//recursive intuition
		
		//self work
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void arraySubSet(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
			for(int j=i;j<arr.length;j++) {
				
				System.out.print(arr[j]);
			}
			System.out.println();
		}
	}
	
	
	
	
	
	public void printPattern(int n) {
		//base case if n==1 => *
		for(int i=n;i>=0;i--) {
			for(int j=0;j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void printPatternRec(int n,int i) {
		//base case
		if(n==0) {
			return;
		}
		if(i<n) {//need to print from i till n
			System.out.print("*");
			printPatternRec(n,i+1);
		}else {
			System.out.println();
			printPatternRec(n-1,0);
		}
	
	}
	
	int power(int a,int b) {
		//base case
		System.out.println("called");
		if(b==0) {
			return 1;
		}
		if(b==1) {
			return a;
		}
		// solve it for b/2
		//recursive intitutaion
		int half=power(a,b/2);
		
		
		//self work
		if(b%2==0) {
			return half*half;
		}else {
			return a*half*half;
		}
	}
	
	public int factorial(int n) {
		//Base condition
		if(n==1 || n==0) {
			return 1;
		}
		
		//Recursive intution
		int subproblem=factorial(n-1);
		
		//self work
		return n*subproblem;
		
	}
	
	public int fib(int n) {
		//base case
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		//recursive intuition
		int subproblem1=fib(n-1);
		int subproblem2=fib(n-2);
		
		//self work
		return subproblem1+subproblem2;
	}
	
	public void printNNaturalNumber(int n) {
		//base case
		if(n==0) {
			return;
		}
		
		//recursive intutition 
		printNNaturalNumber(n-1);
		
		//self work
		System.out.println(n);
	}
	
	public void printNNaturalNumberDec(int n) {
		//base case
		if(n==1) {
			System.out.println(n);
			return;
		}
		//self work
		System.out.println(n);
		
		//recursive intutition 
		printNNaturalNumberDec(n-1);
		
		System.out.println(n);
		
		
	}
	/*
	 * 000
	 * 001
	 * 010
	 * 100
	 * 101
	 * 
	 * */
	public int countBinaryStrings(int n) {
		//no consecutive 1s
		
		//Base case
		if(n==1) {
			return 2;
		}
		if(n==2) {
			return 3;
		}
		
		//Recursive intuition
		return countBinaryStrings(n-1)+countBinaryStrings(n-2);
		
		
		//Self work
	}
}

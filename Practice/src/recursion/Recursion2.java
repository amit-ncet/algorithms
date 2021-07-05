package recursion;

import java.util.Arrays;

/*
 * 
 * https://www.youtube.com/watch?v=WSm8pf_UEtI&t=2848s
 * 
 * */
public class Recursion2 {
	public static void main(String[] args) {
		Recursion2 r=new Recursion2();
		//System.out.println(r.pairCountForParty(4));
		
		//System.out.println(r.power(4,2));
		//System.out.println(r.powerV2(5,3));
		
		//r.printPattern(7,0);
		//r.printPatternRev(4,4);
		//r.printSubset(new int[] {1,2,3},3,0,"");
		//System.out.println(r.isArraySorted(new int[] {2,3,4,5,10,12},1));
		r.printBinaryStrings(4,new int[4],0);
	}
	
	
	/*
	 * Given a value n, print all binary string which has no consecutive 1's
	 * 
	 * Ex: n=3
	 * 000
	 * 001
	 * 010
	 * 100
	 * 101
	 * 
	 * 
	 * */
	public void printBinaryStrings(int n,int [] arr,int idx) {
		//Base case
		if(idx==arr.length) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		
		//Recursive institution
		//We have 2 choices: 
		//if(idx-1)==0 we can keep idx=0/1
		if(idx==0 || arr[idx-1]==0) {
			arr[idx]=1;
			printBinaryStrings(n,arr,idx+1);
			arr[idx]=0;
			printBinaryStrings(n,arr,idx+1);
		}else {
			//else idx=0 must be
			arr[idx]=0;
			printBinaryStrings(n,arr,idx+1);
		}
		//Self work
	}
	
	public boolean isArraySorted(int [] arr,int idx) {
		//Base case
		if(idx==arr.length) {
			System.out.println("return true");
			return true;
		}
		if(arr[idx]<arr[idx-1]) {
			System.out.println("return false");
			return false;
		}
		return isArraySorted(arr,idx+1);
	}

	public void printSubset(int [] arr,int n,int i,String osf) {
		//Base case
		if(i==n) {
			System.out.println(osf);
			return;		
		}
		
		//2 choices
		printSubset(arr,n,i+1,osf+arr[i]);
		printSubset(arr,n,i+1,osf);
		
	}
	
	/*
	 * 	 	* 
	 * 		* * *
	 * 		* * * *
	 * 
	 * */
	public void printPatternRev(int n,int col) {
		//Base case
		if(n==0 ) {
			return;
		}
		if(col==0) {
			System.out.println();
			return;
		}
		if(n==col) {
			printPatternRev(n-1,col-1);
		}
		System.out.print("*");
		printPatternRev(n,col-1);
	}
	
	
	
	/*
	 * 	 	* * *
	 * 		* *
	 * 		*
	 * 
	 * */
	public void printPattern(int n,int col) {
		//Base case
		if(n==0) {
			return;
		}
		if(col<n) {
			System.out.print("*");
			printPattern(n,col+1);//Print the column of the row
		}else {
			System.out.println();
			printPattern(n-1,0);//Print the next row
		}
	}
	
	
	
	
	
	public int powerV2(int a,int b) {
		//Base case
		//Smallest subproblem pow(1)=1
		if(b==0) {
			System.out.println("Return 1 "+a+" "+b);
			return 1;
		}
		if(b==1) {
			System.out.println("Return a "+a+" "+b);
			return a;
		}
		
		//Recursive intuition
		int temp = powerV2(a,b/2);
		
		if(b%2==0) {
			//Even
			return temp*temp;
		}else {
			return a*temp*temp;
		}
		//Self work
	}
	
	
	public int power(int a,int b) {
		//Base case
		//Smallest subproblem pow(1)=1
		if(b==0) {
			return 1;
		}
		if(b==1) {
			return a;
		}
		
		//Recursive intuition
		return a*power(a,b-1);
		//Self work
	}
	
	
	/*
	 * Every person can go alone or can go on pair. How many ways people can go in the party.
	 * 
	 * A,B,C
	 * 	
	 * A B C
	 * AB C
	 * AC B
	 * BC A
	 * 
	 * Total 4 ways n=3 can go in a party
	 * 
	 * 
	 * */
	public int pairCountForParty(int n){
		//Base case
		if(n==1) {
			//A
			return 1;
		}
		if(n==2) {
			//A B, AB
			return 2;
		}
		
		//Recursive institution
		return pairCountForParty(n-1)+pairCountForParty(n-1)*pairCountForParty(n-2);
		//Self work
	}
	
	
	
}

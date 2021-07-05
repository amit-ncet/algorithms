package backtracking;

import java.util.Arrays;
import java.util.Stack;

/*
 * https://unacademy.com/a/free-course-on-backtracking
 * 
 * https://unacademy.com/class/backtracking-deep-dive-part-1/T10BA9S6
 * 
 * */
public class Backtracking1 {
	
	public static void main(String [] args) {
		Backtracking1 bt=new Backtracking1();
		//bt.permutationOfStringBacktracking("ABC".toCharArray(),0);
		int n=7;
		int [][] grid=new int[][] {
			{0,0,1,0,0,1,0},
			{1,0,1,1,0,0,0},
			{0,0,0,0,1,0,1},
			{1,1,0,0,0,0,0},
			{1,0,1,1,0,1,0},
			{1,0,0,0,0,1,0},
			{1,1,1,1,0,0,0}
		};
		
		//bt.countMazePath(7,0,0,grid,new boolean [n][n]);
		//System.out.println(bt.totalPath);
		
		bt.printSubSets(new int[] {1,2,3},"",0);
		//bt.printSubSetsBacktracking(new int[] {1,2,3},new Stack<Integer>(),0);
		
	}
	
	/*
	 * I:P: 123
	 * 
	 * 1
	 * 12
	 * 123
	 * 2
	 * 23
	 * 3
	 * every element will be included & excluded once
	 * 
	 * */
	public void printSubSetsBacktracking(int [] arr,Stack<Integer> osf,int idx) {
		//Base case
		if(idx==arr.length) {
			System.out.println(osf);
			return;
		}
		//Self work: Print osf at every step
		System.out.println(osf);
		
		//Recursive task
		osf.add(arr[idx]);
		printSubSetsBacktracking(arr,osf,idx+1);
		osf.pop();
		printSubSetsBacktracking(arr,osf,idx+1);
		
		
	}
	
	
	public void printSubSets(int [] arr,String osf,int idx) {
		//Base case
		if(idx==arr.length) {
			System.out.println(osf);
			return;
		}
		//Self work: Print osf at every step
		//System.out.println(osf);
		
		//Recursive task
		printSubSets(arr,osf+arr[idx],idx+1);
		printSubSets(arr,osf,idx+1);
		
		
	}
	
	
	
	/*
	 * Time complexity:
	 * (4 ^ n square) we cannot go 4 cells in each call
	 * max will be 3
	 * 3 ^ (n square)-(4n-4) * 2 ^ (4n-4)
	 * 
	 * */
	int totalPath=0;
	public void countMazePath(int n,int i,int j,int[][] grid,boolean [][] visited) {
		//Base case
		if(i==grid.length-1 && j==grid[i].length-1) {
			totalPath++;
			return;
		}
		System.out.println(i+"="+j);
		if(!isItSafe(n,i,j,visited)) {
			return;
		}
		System.out.println(i+"="+j);
		//Recursive task
		visited[i][j]=true;
		
		//top
		if(i>0 && grid[i-1][j]==0)
			countMazePath(n,i-1,j,grid,visited);
		//left
		if(j>0 && grid[i][j-1]==0)
			countMazePath(n,i,j-1,grid,visited);
		//down
		if(i<n-1 && grid[i+1][j]==0)
			countMazePath(n,i+1,j,grid,visited);
		//right
		if(j<n-1 && grid[i][j+1]==0)
			countMazePath(n,i,j+1,grid,visited);
		
		visited[i][j]=false;
		//Self work
	}
	
	
	private boolean isItSafe(int n,int i,int j,boolean [][] visited) {
		return i>=0 && j>=0 && i<n && j<n && visited[i][j]==false;
	}
	
	
	
	
	
	
	public void permutationOfStringRec(String str,String osf) {
		//Base case
		if(str.isEmpty()) {
			System.out.println(osf);
			return;
		}
		//Every character should become prefix once
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			String restOfString=str.substring(0,i)+str.substring(i+1);
			permutationOfStringRec(restOfString,osf+ch);
		}
	}
	
	public void permutationOfStringBacktracking(char[] str,int idx) {
		//Base case
		if(idx==str.length-1) {
			System.out.println(str);
			return;
		}
		//System.out.println(str);
		//Recursive task
		//We have to consider each character as prefix once
		for(int i=idx;i<str.length;i++) {
			swap(str,i,idx);
			//System.out.println("Inside"+Arrays.toString(str));
			permutationOfStringBacktracking(str,idx+1);
			swap(str,idx,i);
			//System.out.println("Inside post"+Arrays.toString(str));
		}
	}
	
	private void swap(char[] str,int i,int j) {
		//System.out.println("i: "+i+" j: "+j);
		char temp=str[i];
		str[i]=str[j];
		str[j]=temp;
	}
}

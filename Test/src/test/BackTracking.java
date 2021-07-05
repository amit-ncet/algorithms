package test;

import java.util.*;


public class BackTracking {
	int n=7;
	public static void main(String[] args) {
		BackTracking m=new BackTracking();
		//m.printUniqueSubPermutation("ABC".toCharArray(), 0);
		
		
		m.n=7;
		
		int [][] maze=new int[][]{{0,0,1,0,0,1,0},{1,0,1,1,0,0,0},
		{0,0,0,0,1,0,1},
		{1,0,1,0,0,0,0},
		{1,0,1,1,0,1,0},
		{1,0,0,0,0,1,0},
		{1,1,1,1,0,0,0}};
		//System.out.println(Arrays.deepToString(m.visited));
		//m.ratInAMaze(maze, 0, 0, maze.length);
		//System.out.println("Paths: "+m.pathCount);
		
		//int []arr=new int[] {1,2,3};
		//m.getSubsetOfArray(arr, new Stack<Integer>(), 0, 3);
		int n=5;
		boolean [][] visited=new boolean[n][n];
		//m.nQueenMoves(visited, 0, n);
		//System.out.println("coutn: "+m.count);
		
		int [][] grid=new int[n][n];
		int counter=0;
		m.knightsTour(visited, grid, 0, 0, n, counter);
		System.out.println(counter);
		
	}

	void knightsTour(boolean [][] visited,int [][] grid,int i,int j,int n,int count) {
		if(count==(n*n)-1) {
			//success
			grid[i][j]=count;
			displayKnight(grid);
			return;
		}
		if(count>(n*n)) {
			return;
		}
		
		//8 possible direction
		int xDir[]=new int[] {-2,-2,-1,-1,2,2,1,1};
		int yDir[]=new int[] {1,-1,2,-2,1,-1,2,-2};
		visited[i][j]=true;
		grid[i][j]=count;
		for(int k=0;k<8;k++) {
			if(isItSafeForKnight(visited, grid, i+xDir[k], j+yDir[k], n, count)) {
				grid[i][j]=++count;
				knightsTour(visited, grid, i+xDir[k], j+yDir[k], n, count+1);
			}
			
		}
		grid[i][j]=count-1;
		visited[i][j]=false;
	}
	
	boolean isItSafeForKnight(boolean [][] visited,int [][] grid,int i,int j,int n,int counter) {
		return  i>=0 && j>=0 && i<n && j<n && visited[i][j]==false;
	}
	
	public void displayKnight(int [][] visited) {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				//if(visited[i][j])
					System.out.print(visited[i][j]+" ");
				//System.out.print(" * ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//####################
	public void displayQueen(boolean [][] visited) {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				if(visited[i][j])
					System.out.print(" Q ");
				System.out.print(" * ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
	}
	
	int count=0;
	
	public void nQueenMoves(boolean [][] visited,int current_row,int n) {
		//Base case
		if(current_row==n) {
			//We found a way
			displayQueen(visited);
			count++;
			return;
			
		}
		//Recursive intuition
		//check each coloumn in the current row
		for(int i=0;i<n;i++) {
			if(isItSafe(visited, current_row,i, n)) {
				visited[current_row][i]=true;
				nQueenMoves(visited, current_row+1, n);
				visited[current_row][i]=false;
			}
		}
		
		//Self work
	}
	

	
	private boolean isItSafe(boolean [][] visited,int row,int col,int n) {
		
		//Column check
		for(int i=row-1;i>=0;i--) {
			//Going down in the column
			if(visited[i][col]==true) {
				return false;
			}
		}
		
		
		//left upper Diagnol check
		for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--) {
			if(visited[i][j]) {
				return false;
			}
		}
		
		//right upper Diagnol check
		for(int i=row-1,j=col+1;i>=0 && j<n;i--,j++) {
			if(visited[i][j]) {
						return false;
			}
		}
				
				
		return true;
	}











	public boolean isItSafe(int i,int j,int n ,boolean [][] visited) {
		return i>=0 && j>=0 && i<n && j<n && visited[i][j]==false;
	}
	
	int pathCount=0;
	boolean visited[][]=new boolean[n][n];
	public void ratInAMaze(int[][] maze,int i,int j,int n) {
		
		if(i==n-1 && j==n-1) {
			pathCount++;
			return;
		}
		
		if(!isItSafe(i, j, n, visited)) {
			return;//prune the unsafe call
		}
		
		visited[i][j]=true;
		//recursion call
		
		if(maze[i][j]==0) {
			if(i<n)
			ratInAMaze(maze, i+1, j, n);//down
			if(i>=0)
			ratInAMaze(maze, i-1, j, n);//up
			ratInAMaze(maze, i, j+1, n);//right
			ratInAMaze(maze, i, j-1, n);//left
		}
		
		visited[i][j]=false;
		
		return;
		
	}
	
	/*
	 * {1,2,3}
	 * 
	 * {}
	 * {1}
	 * {1,2}
	 * {1,3}
	 * {1,2,3}
	 * {2}
	 * {2,3}
	 * {3}
	 * */
	
	public void getSubsetOfArray(int [] arr,Stack<Integer> temp,int i,int n) {
		//Base case
		if(n==i) {
			System.out.println(temp);
			return;
		}
		//Recursion intution
		temp.add(arr[i]);
		getSubsetOfArray(arr, temp, i+1, n);
		temp.pop();
		getSubsetOfArray(arr, temp, i+1, n);
		//Self work
	}
	
	
	
	
	
	
	/*
	 * ABC
	 * ACB
	 * CAB
	 * CBA
	 * BAC
	 * BCA
	 * 
	 * */
	public void printUniqueSubPermutation(char []  str,int j) {
		//Base case
		if(str.length-1==j) {
			System.out.println(Arrays.toString(str));
			return;
		}
		
		//Recursive assumption
		for(int i=j;i<str.length;i++) {
			//str.
			swap(str, i, j);
			printUniqueSubPermutation(str, j+1);
			swap(str, i, j);
		}
		
		//Self work
	}
	
	private void swap(char [] arr,int i,int j) {
		char temp=arr[j];
		arr[j]=arr[i];
		arr[i]=temp;
	}
	/*
	 * 
	 * [B, A, C]
[B, A, C]
[B, C, A]
[B, C, A]
[B, C, A]
[B, A, C]
[A, C, B]
[A, C, B]
[A, B, C]




	 * */
	
}

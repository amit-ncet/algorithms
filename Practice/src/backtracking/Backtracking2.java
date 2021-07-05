package backtracking;

import java.util.Arrays;
import java.util.Stack;

/*
 * https://unacademy.com/a/free-course-on-backtracking
 * 
 * https://unacademy.com/class/backtracking-deep-dive-part-1/T10BA9S6
 * 
 * */
public class Backtracking2 {
	
	public static void main(String [] args) {
		Backtracking2 bt=new Backtracking2();
		int n=4;
		bt.nQueen(n,new boolean[n][n],0);
		System.out.println("Total moves: "+bt.totalMoves);
		
	}
	
	
	/*
	 * How many ways we can place N Queen on a N*N grid.
	 * 
	 * Space complexity : O(n^2)
	 * Time complexity: 
	 * 
	 * Better answer : O(n!) 
	 * 
	 * As we will reduce number of rows as long as we are
	 * going down the row to explore rows.
	 * Loose answer : O(n^n)
	 * 
	 * 
	 * */
	int totalMoves=0;
	public void nQueen(int n,boolean [][] grid, int row) {
		//Base case
		if(row==n) {
			totalMoves++;
			display(n,grid);
			return;
		}
		
		//Recursive task
		//In the current row, scan all the column
		for(int i=0;i<n;i++) {
			//check if the current position is safe
			if(isSafe(n,grid,row, i)) {
				//if this is safe than place the current queen to this position
				grid[row][i]=true;
				nQueen(n,grid,row+1);//Explore the next row for next queen
				grid[row][i]=false;//reset the value for backtracking
			}
		}
		//Self work
	}
	
	private void display(int n,boolean [][] grid) {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]==true) {
					System.out.print(" Q ");
				}else {
					System.out.print(" . ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private boolean isSafe(int n,boolean[][] grid, int row, int col) {
		//Scan all the top column
		for(int i=row;i>=0;i--) {
			if(grid[i][col]==true) {
				return false;
			}
		}
		//Scan left diagnoal on top
		for(int i=row,j=col;i>=0 && j>=0;i--,j--) {
			if(grid[i][j]==true) {
				return false;
			}
		}
		//Scan sright diagnol on top
		for(int i=row,j=col;i>=0 && j<n;i--,j++) {
			if(grid[i][j]==true) {
				return false;
			}
		}
		return true;
	}
	
	
	/*
	 * 
	 * Given a N*N board with a knight placed at (0,0) position, check if the knight
	 * can cover all the position of the board without repeating it's position.
	 * 
	 * TIme complexity: 8^(n^2) 
	 * */
	public void nKnight(int n) {
		
	}
	
}

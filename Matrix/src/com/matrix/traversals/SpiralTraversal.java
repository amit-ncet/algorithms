package com.matrix.traversals;

public class SpiralTraversal {
	public static void main(String[] args) {
		int [][] matrix=new int[][] {
			{1  ,2	,3	,4	,5},
			{6  ,7	,8	,9	,10},
			{11 ,12 ,13 ,14	,15},
			{16 ,17 ,18 ,19 ,20},
			{16 ,17 ,18 ,19 ,20},
			{16 ,17 ,18 ,19 ,20}};
			
			spiralTraversalInMatrix(matrix);
	}
	
	
	public static void spiralTraversalInMatrix(int [][] matrix) {

		// start_row	end_row
		// start_col	end_col
		//1 while loop & 4 for loops
		
		int startRow=0;
		int endRow=matrix.length-1;
		int startCol=0;
		int endCol=matrix[0].length-1;
		while(startRow<=endRow && startCol<=endCol) {
			
			//1st print the start row
			
			for(int i=startCol;i<=endCol;i++) {
				System.out.print(matrix[startRow][i]+"-");
			}
			System.out.println();
			startRow++;
			
			//Print the last column, col will remain fix, row will change
			for(int i=startRow;i<=endRow;i++) {
				System.out.print(matrix[i][endCol]+"-");
			}
			System.out.println();
			endCol--;
			
			//Print the last row, row will be fix col will move
			for(int i=endCol;i>=startCol;i--) {
				System.out.print(matrix[endRow][i]+"-");
			}
			System.out.println();
			endRow--;
			
			//Print the 1st col, col will be fix row will move
			for(int i=endRow;i>=startRow;i--) {
				System.out.print(matrix[i][startCol]+"-");
			}
			System.out.println();
			startCol++;
			//break;
		}
	}
}

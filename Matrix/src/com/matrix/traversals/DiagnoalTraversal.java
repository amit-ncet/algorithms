package com.matrix.traversals;

import java.util.ArrayList;
import java.util.List;

public class DiagnoalTraversal {
	public static void main(String[] args) {
		int [][] matrix=new int[][] {
			{1  ,2	,3	,4	,5},
			{6  ,7	,8	,9	,10},
			{11 ,12 ,13 ,14	,15},
			{16 ,17 ,18 ,19 ,20},
			{16 ,17 ,18 ,19 ,20},
			{16 ,17 ,18 ,19 ,20}};

			//diagnoalsOfMatrix(matrix);
			//System.out.println();
			//System.out.println();
			//diagnoalsOfMatrixReverse(matrix);
			
		
	}
	
	

	
	public static void diagnoalsOfMatrix(int [][] matrix) {
		//rows: take column 0 of every row till end of the row
		//column: take every column of last row starting 1, as 0 we have already covered
		
		for(int row=0;row<matrix.length;row++) {
			// i-1, j+1
			int i=row;
			int j=0;
			while(i>=0 && j<matrix[i].length) {
				System.out.print(matrix[i][j]+"-");
				i=i-1;
				j=j+1;
			}
			System.out.println();
		}
		
		for(int col=1;col<matrix[0].length;col++) {
			//i-1,j+1
			int i=matrix.length-1;
			int j=col;
			while(i>=0 && j<matrix[i].length) {
				System.out.print(matrix[i][j]+"-");
				i=i-1;
				j=j+1;
			}
			System.out.println();
		}
	}
	
	
	public static void diagnoalsOfMatrixReverse(int [][] matrix) {
		//rows: take column 0 of every row till end of the row
		//column: take every column of last row starting 1, as 0 we have already covered
		
		for(int col=matrix[0].length-1;col>0;col--) {
			int i=matrix.length-1;
			int j=col;
			while(i>=0 && j<matrix[0].length) {
				//i-1, j+1
				System.out.print(matrix[i][j]+"*");
				i=i-1;
				j=j+1;
			}
			System.out.println();
		}
		

		for(int row=matrix.length-1;row>=0;row--) {
			int i=row;
			int j=0;
			
			while(i>=0 && j<matrix[i].length) {
				System.out.print(matrix[i][j]+"*");
				i=i-1;
				j=j+1;
			}
			System.out.println();
		}
		
	}
}

package revision;

import java.util.Arrays;
import java.util.Comparator;

public class MatrixProblem {
	public static void main(String[] args) {
		int matrix[][] = new int[][] { 
			{ 1, 9, 10, 8 }, 
			{ 3, 4, 4, 4 }, 
			 };
		
			int queries[][] = new int[][] { 
				{ 2, 3 }, 
				{ 3, 2 }
				};
			meanAndChessboard(matrix,queries);
			
	}

	public static int[][] meanAndChessboard(int[][] matrix, int[][] queries) {
		int n = matrix.length * matrix[0].length;
		int wl = 0;
		int bl = 0;

		if (n % 2 == 0) {
			wl = n / 2;
			bl = n / 2;
		} else {
			wl = n / 2 + 1;
			bl = n / 2;
		}
		int[][] black = new int[bl][3];
		int[][] white = new int[wl][3];
		// int [][] arr=new int[][]{{1},{2}};
		int b = 0;
		int w=0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						white[w][0] = matrix[i][j];
						white[w][1] = i;
						white[w][2] = j;
						//white[w] = new int[][] { { i }, { j } };
						w++;
					} else {
						black[b][0] = matrix[i][j];
						black[b][1]=i;
						black[b][2]=j;
								
						//black[b] = new int[][] { { i }, { j } };
						b++;
					}
				} else {
					if (j % 2 == 0) {
						black[b][0] = matrix[i][j];
						black[b][1]=i;
						black[b][2]=j;
						//black[b] = new int[][] { { i }, { j } };
						b++;
					} else {
						white[w][0] = matrix[i][j];
						white[w][1] = i;
						white[w][2] = j;
						//white[w] = new int[][] { { i }, { j } };
						w++;
					}
				}
			}
		}
		System.out.println("Black: "+Arrays.deepToString(black));
		System.out.println("White: "+Arrays.deepToString(white));
		// Arrays.sort(array, Comparator.<int[]>comparingInt(a -> a[0]).thenComparingInt(a -> a[1]));
		Arrays.sort(black,Comparator.<int[]>comparingInt(a->a[0]).thenComparingInt(a->a[1]).thenComparingInt(a->a[2]));
		Arrays.sort(white,Comparator.<int[]>comparingInt(a->a[0]).thenComparingInt(a->a[1]).thenComparingInt(a->a[2]));
		System.out.println("Black: "+Arrays.deepToString(black));
		System.out.println("White: "+Arrays.deepToString(white));
		
		/*
		 *
Find the average value of these two cells;
If the average value is a whole integer, replace both of the selected cells with the found average value;

Otherwise, replace the cell of the greater value with the average rounded up to the nearest integer, 
and replace the cell of the smaller value with the average rounded down to the nearest integer.
		 * */
		
		System.out.println("matrix: "+Arrays.deepToString(matrix));
		
		for(int i=0;i<queries.length;i++) {
			int ith=queries[i][1];//white
			int jth=queries[i][0];//black
			
			int ival=white[ith][0];
			int jval=black[jth][0];
			
			double sum=ival+jval;
			if(sum%2==0) {
				int a=(int)sum/2;
				matrix[white[ith][1]][white[ith][2]]=a;
				matrix[black[jth][1]][black[jth][2]]=a;	
				white[ith][0]=a;
				black[jth][0]=a;
			}else {
				int a1=(int) Math.ceil(sum/2);
				int b1=(int) Math.floor(sum/2);
				if(matrix[white[ith][1]][white[ith][2]]>matrix[black[jth][1]][black[jth][2]]) {
					matrix[white[ith][1]][white[ith][2]]=a1;
					matrix[black[jth][1]][black[jth][2]]=b1;
					white[ith][0]=a1;
					black[jth][0]=b1;
				}else {
					matrix[black[jth][1]][black[jth][2]]=a1;
					matrix[white[ith][1]][white[ith][2]]=b1;
					black[jth][0]=a1;
					white[ith][0]=b1;					
				}			
			}
			Arrays.sort(black,Comparator.<int[]>comparingInt(a->a[0]).thenComparingInt(a->a[1]).thenComparingInt(a->a[2]));
			Arrays.sort(white,Comparator.<int[]>comparingInt(a->a[0]).thenComparingInt(a->a[1]).thenComparingInt(a->a[2]));
			
			System.out.println("matrix--: "+Arrays.deepToString(matrix));
		}
		
		return null;
	}

}

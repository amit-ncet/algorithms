package test;

/*
Imagine we have an image. We'll represent this image as a simple 2D array where every pixel is a 1 or a 0.

The image you get is known to have potentially many distinct rectangles of 0s on a background of 1's. Write a function that takes in the image and returns the coordinates of all the 0 rectangles -- top-left and bottom-right; or top-left, width and height.

image1 = [
  [0, 1, 1, 1, 1, 1, 1],
  [1, 1, 1, 1, 1, 1, 1],
  [0, 1, 1, 0, 0, 0, 1],
  [1, 0, 1, 0, 0, 0, 1],
  [1, 0, 1, 1, 1, 1, 1],
  [1, 0, 1, 0, 0, 1, 1],
  [1, 1, 1, 0, 0, 1, 1],
  [1, 1, 1, 1, 1, 1, 0],
]

Sample output variations (only one is necessary):

findRectangles(image1) =>
  // (using top-left-row-column and bottom-right):
  [
    [[0,0],[0,0]],  
    [[2,0],[2,0]],  top-left     bottom-right
    [[2,3],[3,5]], [row,colum], [row,column]
    [[3,1],[5,1]],
    [[5,3],[6,4]],
    [[7,6],[7,6]],
  ]
  // (using top-left-row-column and width/height):
  [
    [[0,0],[1,1]],
    [[2,0],[1,1]],    top-left
    [[2,3],[3,2]],   [row,column], [width, height]
    [[3,1],[1,3]],
    [[5,3],[2,2]],
    [[7,6],[1,1]],
  ]

Other test cases:

image2 = [
  [0],
]

findRectangles(image2) =>
  // (using top-left-row-column and bottom-right):
  [
    [[0,0],[0,0]],
  ]

  // (using top-left-row-column and width/height):
  [
    [[0,0],[1,1]],
  ]

image3 = [
  [1],
]

findRectangles(image3) => []

image4 = [
  [1, 1, 1, 1, 1],
  [1, 0, 0, 0, 1],
  [1, 0, 0, 0, 1],
  [1, 0, 0, 0, 1],
  [1, 1, 1, 1, 1],
]

findRectangles(image4) =>
  // (using top-left-row-column, and bottom-right or width/height):
  [
    [[1,1],[3,3]],
  ]

n: number of rows in the input image
m: number of columns in the input image

*/

import java.io.*;
import java.util.*;

public class WayFairTest {
  public static void main(String[] argv) {

    int[][] image1 = {
      {0, 1, 1, 1, 1, 1, 1},
      {1, 1, 1, 1, 1, 1, 1},
      {0, 1, 1, 0, 0, 0, 1},
      {1, 0, 1, 0, 0, 0, 1},
      {1, 0, 1, 1, 1, 1, 1},
      {1, 0, 1, 0, 0, 1, 1},
      {1, 1, 1, 0, 0, 1, 1},
      {1, 1, 1, 1, 1, 1, 0},
    };

    int[][] image2 = {
      {0},
    };

    int[][] image3 = {
      {1},
    };

    int[][] image4 = {
      {1, 1, 1, 1, 1},
      {1, 0, 0, 0, 1},
      {1, 0, 0, 0, 1},
      {1, 0, 0, 0, 1},
      {1, 1, 1, 1, 1},
    };
    WayFairTest s=new WayFairTest();
    
    s.getRectanglesInImage(image1);
//     for(int i = 0; i < image1.length; i++){
//       for(int j = 0; j < image1[i].length; j++){
//         System.out.print(image1[i][j] + " ");
//       }
//       System.out.println();
//     }
    
  }
  
  public List<List<Integer>> getRectanglesInImage(int [][] img){
    int [][] image=new int[img.length][img[0].length];
    
    for(int i=0;i<image.length;i++){
      for(int j=0;j<image[i].length;j++){
        image[i][j]=img[i][j];
      }
    }
    List<List<Integer>> result=new ArrayList<>();
    for(int i=0;i<image.length;i++){
      for(int j=0;j<image[i].length;j++){
        if(image[i][j]==0){
          
          List<Integer> li=new ArrayList<>();
          li.add(i);
          li.add(j);
          //[[0,0],[0,0]],
          List<Integer> li1=bfs(image,i,j);
          result.add(li);
          result.add(li1);
          
        }
      }
    }
    System.out.println(result);
    //System.out.println(Arrays.deepToString(img));
    
    System.out.println(Arrays.deepToString(image));
    
    return result;
  }
  
  
  public List<Integer> bfs(int [][] image,int x,int y){
    System.out.println("called: "+x+"-"+y);
    Queue<int[]> q=new LinkedList<>();
    q.add(new int[] {image[x][y],x,y});
    while(!q.isEmpty() && x<image.length-1 && y<image[0].length-1){
      int[] ref=q.poll();//0
      System.out.println("ref: "+ref+" "+x+"-"+y);
      if(ref[0]==0){
        x=ref[1];
        y=ref[2];
        image[x][y]=1;
        //right i,j j++
        q.add(new int[] {image[x][y+1],x,y+1});
        //down i++
        q.add(new int [] {image[x+1][y],x+1,y});
        System.out.println("inside: "+x+"-"+y);
      }
    }
    List<Integer> res=new ArrayList<>();
    res.add(x);
    res.add(y);
    return res;
  }
}

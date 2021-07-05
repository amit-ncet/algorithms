package test;
import java.io.*; 
import java.util.*;
// Add any extra import statements you may need here
import java.math.*;

class Main {

  // Add any helper functions you may need here
  class Subarray{
	  int left;
	  int right;
	  public Subarray(int l,int r){
		  this.left=l;
		  this.right=r;
	  }
  }

	public Subarray[] aboveAverageSubarrays(int[] A) {
		  Subarray[] sArr=new Subarray[A.length];
		  double totalAvg=0.0;
		  for(int i=0;i<A.length;i++){
		    totalAvg+=A[i];
		  }
		  totalAvg=totalAvg/A.length;
		  int s=0;
		  for(int i=0;i<A.length;i++){
		    int sum=A[i];
		    int start=i;
		    for(int j=i;j<A.length;j++){
		      sum+=A[j];
		      int avg=sum/(j-start+1);
		      if(avg>totalAvg){
		        sArr[s]=new Subarray(start,j);
		        s++;
		        break;//
		      }
		    }
		  }
		  //Arrays.sort(sArr,(a,b)->Double.compare(a.left,b.left) < Double.compare(a.left,b.left));
		  
		  
		  Arrays.sort(sArr,(a,b)->Integer.compare(a!=null?a.left:0,b!=null?b.left:0));
		  return sArr;
		}


  public static void main(String[] args) {
    Main m=new Main();
    int [] arr=new int[] {3,4,7,8,3,5,2};
    //System.out.println(m.aboveAverageSubarrays(arr));
    Subarray[] res=m.aboveAverageSubarrays(arr);
    for(Subarray sub:res) {
    	if(sub!=null)
    	System.out.println("{ "+sub.left+" , "+sub.right+" }");
    }
    
  }
}
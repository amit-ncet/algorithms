package test;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Demo
{        
  // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    public static List<Integer> cellCompete(int[] states, int days)
    {
    	System.out.println("CALLEDDD : ");
        //create another array for the manipulation
        int j=1;
        System.out.println("CALLEDDD : "+days);
        while(j<=days) {
        	int [] cellComplete=new int[states.length];
            System.out.println("Day numer : "+j);
        printArr(states);
        //0|1 0 0 1 0 1 0 1|0 => Initial cell states
        for(int i=0;i<states.length;i++){
            //Handle the starting and ending conditions
            if(i==0) {
                if(states[i+1]==0) {
                    cellComplete[i]=0;
                }else{
                    cellComplete[i]=1;
                }
            }else if(i==(states.length-1)) {
                if(states[i-1]==0) {
                    cellComplete[i]=0;
                }else{
                    cellComplete[i]=1;
                }
            }else{
                //logic for remaining arrays
                //0__0 or 1__1 => 0
                //1__0 or 0__1 => 1
                if((states[i-1]==0 && states[i+1]==0) || (states[i-1]==1 && states[i+1]==1)) {
                    cellComplete[i]=0;
                }else{
                   cellComplete[i]=1; 
                }
            }
        }
        //change the states assingment to cellComplete
        states=cellComplete;
        printArr(states);
        j++;
        }
        
        return convertListToArray(states);
    }
    
    public static int generalizedGCD(int num, int[] arr)
    {
        // WRITE YOUR CODE HERE 2 3 4 5 6: 2 4 6 8 10
        for(int i=0;i<arr.length;i++){
            
        }
        int i=0;
        int gcd=0;
        while(i<arr.length-1){
            if(gcd==1) {
            	return 1;
            }else if(gcd==0){
            	 gcd=getGCD(arr[i],arr[i+1]);
            }
            else {
            	gcd= getGCD(gcd,arr[i+1]);
            }
            i++;
        }
        return gcd;
    }
    // METHOD SIGNATURE ENDS
    //write the logic to get GCD of 2 numbers by using euclids algorithms
    private static int getGCD(int p, int q) {
        int r = q%p;
        System.out.println("Finding GCD of "+p+" "+q+" is R: "+r);
        if(r==1){
            return 1;
        }
        else if(r==0) {//p should be the smaller number
            return p;
        }else{
            return getGCD(r,p);
        }
    }
    
    
    private static void printArr(int [] arr) {
    	for(int i=0;i<arr.length;i++) {
            System.out.print(arr[i]+",");
        }
         System.out.println();
    }
    
    private static List<Integer> convertListToArray(int [] arr) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++) {
          list.add(arr[i]);  
        }
        return list;
    } 
    
    public static void main(String [] args) {
    	System.out.println("RUNNNN");
    	int [] states= {1,1,1,0,1,1,1,1};
    	//cellCompete(states, 2);
    	//int gcd=getGCD(54,98);
    	//System.out.println(gcd);
    	int[] sd= {2,4,6,8,10};
    	 // WRITE YOUR CODE HERE 2 3 4 5 6: 2 4 6 8 10
    	int demo=generalizedGCD(5,sd);
    			System.out.println("GCD is : "+demo);
    }
  // METHOD SIGNATURE ENDS
}
package recursion;

import java.util.Arrays;

public class MissingNumber {
	public static void main(String[] args) {
		MissingNumber m=new MissingNumber();
		int [] arr=new int[] {1,2,3,4,2};
		m.getMissingElement(arr);
	}
	
	public int getMissingElement(int [] arr) {
		for(int i=0;i<arr.length;i++) {
			if(arr[arr[i]-1]<0) {
				System.out.println(Arrays.toString(arr));
				System.out.println("Missing number: "+arr[i]);
				return arr[i];
			}
			arr[arr[i]-1]=-1*arr[arr[i]-1];
		}
		System.out.println(Arrays.toString(arr));
		return -1;
	}
	
}

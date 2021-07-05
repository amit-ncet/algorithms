import java.util.*;

public class MissingNumber {
	/*
	 * 
	 * 5
		2 3 1 5
	 * */
	public static void main(String[] args) {
		
		
		
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int b[] = new int[n];
		for(int i = 0; i < n; i++){
		    b[i] = sc.nextInt();
		}
		//System.out.println(Arrays.toString(b));
		
		Set<Integer> nums=new HashSet<>();
		for(int i=0;i<b.length;i++) {
			nums.add(b[i]);
		}
		
		while(n>0) {
			if(!nums.contains(n)) {
				System.out.println(n);
			}
			n--;
		}
	}
}

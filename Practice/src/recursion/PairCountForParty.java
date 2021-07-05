package recursion;

public class PairCountForParty {
	public static void main(String [] args) {
		PairCountForParty pc=new PairCountForParty();
		System.out.println(pc.pairCount(4));
	}
	
	public int pairCount(int n) {
		//Base case
		if(n<=2) {
			return n;
		}
		
		return pairCount(n-1)+(n-1)*pairCount(n-2);
	}
}

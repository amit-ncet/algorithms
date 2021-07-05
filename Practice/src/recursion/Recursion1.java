package recursion;

public class Recursion1 {
	public static void main(String[] args) {
		Recursion1 r=new Recursion1();
		
		/*
		 * Pattern 1 : Recurrence relation 
		 * Ex: Factorial & Fibonnaci series
		 * where we have the solution as a recurrence relation
		 * i.e. n*f(n-1) or f(n-1)+f(n-2) respectively 
		 * */
		//System.out.println(r.factorial(5));
		//System.out.println(r.fibonacci(3));
		
		
		/*
		 * Pattern 2: Print result problems and self work position
		 * 
		 * We will have some problem where we will do self work while pushing the function call to stack
		 * We will have some problem where we will do self work while returning the function call from the stack
		 * 
		 * */
		
		//r.printNNaturanNumberReverse(5);
		//r.printN(5);
		System.out.println(r.countBinaryString(5));
	}
	
	
	public int countBinaryString(int n) {
		//Base case
		if(n==0) {
			return 2;
		}
		if(n==1) {
			return 3;
		}
		return countBinaryString(n-1)+countBinaryString(n-2);
		//Self work
	}
	
	
	public void printN(int n) {
		//Base case
		if(n==1) {
			System.out.println(n);
			return;
		}
			//return;
		
		//Self work
		System.out.println(n);
		//Recursive intution
		printN(n-1);
		
		//Self work
		System.out.println(n);
	}
	public void printNNaturanNumberReverse(int n) {
		//Base Case
		if(n==0)
			return;
		//Self work
		System.out.println(n);
		
		//Recursive intitution
		printNNaturanNumberReverse(n-1);
		
	}
	
	public void printNNaturalNumber(int n) {
		//base case
		//smallest subproblem n=1
		if(n==0) {
			//System.out.println(n);
			return;
		}
		//Recursive intuition
		printNNaturalNumber(n-1);
		
		//Self work
		System.out.println(n);
	}
	
	
	
	
	//0,1,1,2,3,5,8,13.... Sum of previous 2 term
	//f(n) ---> f(n-1)+f(n-2)
	public int fibonacci(int n) {//3
		//Base case
		if(n==0 || n==1) {
			return n;
		}
		
		//Recursive intution
		int subproblem1=fibonacci(n-1);
		int subproblem2=fibonacci(n-2);
		//Self work
		return subproblem1+subproblem2;
	}
	
	
	
	
	
	
	
	public int factorial(int n){
		//base case
		if(n==1) {
			System.out.println("Return line 12 : "+n);
			return 1;
		}
		//Recursive Assumption
		int sub=factorial(n-1);
		System.out.println("Return line 17: "+n+" sub: "+sub+" res: "+n*sub);
		//Self work
		return n*sub;
	}
}

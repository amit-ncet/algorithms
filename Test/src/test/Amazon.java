package test;

import java.util.*;

public class Amazon {
	int n = 7;

	public static void main(String[] args) {
		Amazon m = new Amazon();
		// m.printUniqueSubPermutation("ABC".toCharArray(), 0);
		char a[] = new char[] { 'a', 'b' };
		char b[] = new char[] { 'a', 'c' };
		char c[] = new char[] { 'a', 'a', 'b', 'c' };
		// System.out.println("Is combinable: "+m.isCombinable(a, b, c));

		char a1[] = new char[] { 'a', 'b', 'c' };
		//m.isCombinable(a, b, c);
		//System.out.println("Is combinable: " + m.isCombinable(a, b, c));

		// m.allDivisions("ABC",new ArrayList<>());
		// m.getAllDivisions("AB",0,"");
		// System.out.println(res);
		//System.out.println(m.results);
		
		//Combo test
		m.combo("ABCD",new ArrayList<>());
	}

	
	public void combo(String s,List<String> res) {
		if(s.isEmpty()) {
			System.out.println("Recursion call end- String empty");
			return;
		}
		//Base case
		//Recursive task
		for(int i=1;i<=s.length();i++) {
			String left=s.substring(0,i);
			String right=(s.substring(i));
			System.out.println(left+" "+right);
			res.add(left);
			res.add(right);
			
			combo(right,res);
			System.out.println("Recursion call end");
		}
		//Self work
	}
	/*
	 * IP: ABC [[ABC], [AB, C], [A, BC], [A, B, C]]
	 * 
	 */
	List<List<String>> results = new ArrayList<>();

	public void getAllDivisions(String s, int i, String out) {
		if (i == s.length()) {
			String[] st = out.split(",");
			results.add(Arrays.asList(st));
			System.out.println("Returning reslt: " + " i: " + i + " out: " + out);
			return;
		}

		for (int j = s.length() - 1; j >= i; j--) {
			String sub_str = s.substring(i, j + 1) + ",";
			System.out.println("sub: " + sub_str + " j: " + j + " i: " + i + " out: " + out);
			getAllDivisions(s, j + 1, out + sub_str);
		}
	}

	/*
	 * A: "aab" B: "ac" C: "aacab"
	 * 
	 * return true
	 * 
	 */
	public boolean isCombinable(char[] A, char[] B, char[] C) {

		char[] AB = new char[A.length + B.length];
		int idx = 0;
		for (int i = 0; i < A.length; i++) {
			AB[idx++] = A[i];
		}
		for (int i = 0; i < B.length; i++) {
			AB[idx++] = B[i];
		}
		System.out.println("AB: " + Arrays.toString(AB));
		generateAllPermutations(C, 0, AB);
		return isMatched;

	}

	boolean isMatched = false;

	public void generateAllPermutations(char[] C, int j, char[] AB) {
		if (isMatched) {
			return;
		}
		if (j == C.length) {
			// Print the array
			System.out.println(Arrays.toString(C));
			if (Arrays.equals(C, AB)) {
				// System.out.println("EQUALS: "+Arrays.toString(C));

				isMatched = true;
			}
			return;
		}
		Set<Character> visited = new HashSet<>();
		for (int i = j; i < C.length; i++) {
			if (!visited.contains(C[i])) {
				visited.add(C[i]);
				swap(i, j, C);
				generateAllPermutations(C, j + 1, AB);
				swap(j, i, C);
			}
		}
	}

	public void swap(int i, int j, char[] ch) {
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
	}

}

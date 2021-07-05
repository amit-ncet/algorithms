package test;

import java.util.*;


public class StringSplit {
	public static void main(String[] args) {
		String s = "gfgfgfgfgfgfgfgfgfgfgfgfgfgfgf";
		/*
		 *a b c ab bc abc

		 * xzx
		 * zxz
		 * zxx
		 * zzx
		 * xzxz
		 * xxzx
		 * zxzx
		 * xzxzx
		 * 
		 * */
		StringSplit sp=new StringSplit();
		long startTime = System.currentTimeMillis();
		System.out.println("COUTNN : "+sp.count(s));
		
		//sp.getSplitCount(s," ",0);
		//System.out.println(sp.li);
		/*
		List<String> acc=new ArrayList<>();
		sp.getSubsequence(s,acc);
		
		//System.out.println("ACC : "+acc);
		
		List<String> result=new ArrayList<>();
		sp.getSubstring(s, result);
		System.out.println("Substring : "+result);
		
		Set<String> visited=new HashSet<>();
		for(int i=0;i<result.size();i++) {
			for(int j=i+1;j<result.size();j++) {
				for(int k=j+1;k<result.size();k++) {
					String a=result.get(i);
					String b=result.get(j);
					String c=result.get(k);
					
					String st=a+" "+b+" "+c;
					if((a+b+c).equals(s) && !visited.contains(st)) {
						System.out.println(result.get(i)+" "+result.get(j)+" "+result.get(k));
						visited.add(st);
					}
					//a + b, b + c and c + a 
					//System.out.println("Final result");
					if(!visited.contains(st) && (a+b+c).equals(s) && !(a+b).equals(b+c) && !(b+c).equals(c+a)) {
						System.out.println(result.get(i)+" "+result.get(j)+" "+result.get(k));
						//visited.add(st);
					}
				}	
			}
		}*/
		long elapsedTime = System.currentTimeMillis() - startTime;
		System.out.println("milliseconds : "+elapsedTime);
		
	}
	

	public void getSubstring(String s,List<String> result) {
		
		for(int i=0;i<=s.length();i++) {
			for(int j=i+1;j<=s.length();j++) {
				result.add(s.substring(i,j));
			}
		}
	}

	public int count(String str) {
        //cc

        int len = str.length();
        int count = 0;
        for (int i = 1; i <= len - 2; i++) {
            for (int j = i + 1; j <= len - 1; j++) {
//          Separate the String into three parts with different index range, each lenght is at least 1
//                String a = str.substring(0, i); // [0, i - 1]
//                String b = str.substring(i, j); // [i, j - 1]
//                String c = str.substring(j, len); // [j, len - 1]
                String ab = str.substring(0, j); // this is [0, i - 1] + [i, j - 1] = [0, j - 1];
                String bc = str.substring(i, len); // this [i, j - 1] + [j, len - 1] = [i, len - 1];
                String ca = str.substring(j, len) + str.substring(0, i); // this is [j, len - 1] + [0, i - 1]
                System.out.println("ab: "+ab+" bc: "+bc+" ca= "+ca);
                if (!(ab.equals(bc) || bc.equals(ca) || ca.equals(ab))) { // check if the three concatenation are the same, if not, add it to the count
                    count++;
                }
            }
        }
        return count;
    }

	public void getSubsequence(String substr,List<String> acc) {
		if(substr.length()==0) {
			acc.add("");
			return;
		}
		getSubsequence(substr.substring(1),acc);
		//Add first char to all the strings in the list
		int n=acc.size();
		for(int i=0;i<n;i++) {
			acc.add(substr.substring(0,1)+acc.get(i));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	Set<String> li=new HashSet<String>();
	private void getSplitCount(String s,String sub,int i) {
		
		//get all substring
		for(int j=i;j<s.length();j++) {//0,1
			String subj=s.substring(i,j+1);//0 1
			li.add(subj);//x
			
			getSplitCount(s,subj,j+1);
		}
		//return 0;
	}
	
	
	private void getCount(List<String> li,int i,String str,int count,String tar) {
		
		if(str.equal())
		//get all substring
		for(int j=i;j<li.size();j++) {//0,1
			getCount(li,j+1,str+li.get(j),count+1);
		}
		//return 0;
	}
	
}

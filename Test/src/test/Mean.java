package test;

import java.util.*;

public class Mean {
	public static void main(String[] args) {
		Mean m=new Mean();
		int [][] a=new int [][] {{3,3,4,2},{4,4},{4,0,3,3},{2,3},{3,3,3}};
		m.getMean(a);
	}

	private int[][] getMean(int[][] a) {
		Map<Integer,List<Integer>> m=new HashMap<>();
		for(int i=0;i<a.length;i++) {
			int mean=getAvg(a[i]);
			if(m.containsKey(mean)) {
				List<Integer> l=m.get(mean);
				l.add(i);
				m.put(mean,l);
			}else {
				List<Integer> l=new ArrayList<>();
				l.add(i);
				m.put(mean,l);
			}
		}
		//System.out.println(m);
		int arr[][]=new int[m.size()][];
		int j=0;
		for(Map.Entry<Integer,List<Integer>> entry:m.entrySet()) {
			int k=0;
			//arr[j][]
			arr[j]=new int[entry.getValue().size()];
			for(Integer i:entry.getValue()) {
				arr[j][k]=i;
				k++;
			}
			j++;
		}
		//for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.deepToString(arr));
		//}
		Arrays.sort(arr,(x,y)->Integer.compare(x[0], y[0]));	
		System.out.println(Arrays.deepToString(arr));
		return arr;
	}

	private int getAvg(int[] a) {
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		}
		return sum/a.length;
	}
}

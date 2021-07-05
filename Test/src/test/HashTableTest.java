package test;

public class HashTableTest {
	public static void main(String[] args) {
		HashTable hash=new HashTable();
		hash.put(10, 20);
		hash.put(12, 25);
		hash.put(13, 200);
		hash.put(14, 2003);
		hash.put(15, 220);
		hash.put(17, 2450);
		
		hash.put(18, 2450);
		hash.put(19, 52);
		//System.out.println(hash);
		
		hash.put(23, 43);
		hash.put(33, 44);
		hash.put(43, 45);
		//hash.put(53, 46);
		//hash.put(63, 47);
		
		
		System.out.println(hash);
		
		System.out.println(hash.get(23));
	}
}

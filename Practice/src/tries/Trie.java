package tries;
import java.util.*;
public class Trie {

	public static void main(String[] args) {
		Trie t=new Trie();
		t.insert("amit");
		t.insert("Sumit");
		t.insert("Rohit");
		t.insert("Ratan");
		t.insert("Bharat");
		
		System.out.println(t.search("amit"));
		System.out.println(t.search("ada"));
		
	}
	
	class TrieNode {
		Map<Character,TrieNode> children;
		boolean isWord;
		public TrieNode(){
			children=new HashMap<>();
		}
	}
	
	TrieNode root=new TrieNode();
	
	public void insert(String word) {
		TrieNode current=root;
		for(Character c:word.toCharArray()) {
			current=current.children.computeIfAbsent(c,(a)->new TrieNode());
		}
		current.isWord=true;
		System.out.println("Inserted the word : \""+word+"\" sucessfully to trie.");
	}
	
	public boolean search(String word) {
		TrieNode current=root;
		for(Character c:word.toCharArray()) {
			current=current.children.get(c);
			//System.out.println(current.children);
			if(current==null) {
				//System.out.println("null curr");
				return false;
			}
		}
		return current.isWord;
	}
}

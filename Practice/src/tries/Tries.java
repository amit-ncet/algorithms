package tries;

import java.util.HashMap;
import java.util.Map;

public class Tries {
	
	public static void main(String[] args) {
		Tries trie=new Tries();
		trie.insert("Programming");
	    trie.insert("is");
	    trie.insert("a");
	    trie.insert("way");
	    trie.insert("of");
	    trie.insert("life");
	    
	    System.out.println(trie.search("life"));
	    System.out.println(trie.search("life123"));
	    

	}
	
	class TrieNode{
		Map<Character,TrieNode> children;
		boolean isWord;
		public TrieNode() {
			children=new HashMap<>();
		}
	}
	
	TrieNode root=new TrieNode();;
	/*
	 * Used for prefix search 
	 * */
	
	public void insert(String word) {
		TrieNode current=root;
		
		for(Character c:word.toCharArray()) {
			current=current.children.computeIfAbsent(c,(a)->new TrieNode());
		}
		current.isWord=true;
	}
	
	public boolean search(String word) {
		TrieNode current=root;
		for(Character c:word.toCharArray()) {
			current=current.children.get(c);
			if(current==null) {
				return false;
			}
		}
		return current.isWord;
	}
}

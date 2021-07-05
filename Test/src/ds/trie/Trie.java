package ds.trie;

import java.util.*;

public class Trie {
	class TrieNode{
		HashMap<Character,TrieNode> children;
		boolean isWord;
		public TrieNode() {
			children=new HashMap<>();
		}
	}
	
	private TrieNode root;
	
	Trie(){
		root=new TrieNode();
	}
	//insert
	public void insert(String str) {
		TrieNode current=root;
		
		for(char c:str.toCharArray()) {
			current=current.children.computeIfAbsent(c,k->new TrieNode());
		}
		current.isWord=true;
	}
	
	//search
	public boolean search(String key) {
		TrieNode current=root;
		for(char c:key.toCharArray()) {
			System.out.println(current.children);
			TrieNode node=current.children.get(c);
			if(node==null) {
				return false;//Reached till end
			}
			current=node;
		}
		return current.isWord;
	}
	
	public static void main(String [] args) {
		Trie trie=new Trie();
		trie.insert("Amit");
		trie.insert("kumar");
		trie.insert("giridih");
		trie.insert("verma");
		trie.insert("nawadiha");
		trie.insert("ranchi");
		
		
		System.out.println(trie.search("Amit"));
		System.out.println(trie.search("kumar"));
	}
}

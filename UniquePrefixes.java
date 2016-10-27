/*
 * Nilanshu Sharma
 * https://www.interviewbit.com/problems/shortest-unique-prefix/
 */ 

class TrieNode {
    TrieNode[] map;  
    int frequency; 
    char val;
    boolean isLeaf; 
    TrieNode(){ // This is for the root
        map = new TrieNode[256]; 
        frequency = 0; 
        isLeaf = false; 
        val = ' '; 
    }
    
    TrieNode(char val){ // This is for other nodes 
        map = new TrieNode[256]; 
        frequency = 0; 
        isLeaf = false; 
        this.val = val; 
    }
}

class Trie {
    TrieNode root; 
    Trie(){
        root = new TrieNode();
    }
    public TrieNode buildTrie(ArrayList<String> list){
        for(String s : list) {
            TrieNode curr = root; 
            for(int i=0; i<=s.length()-1; i++) {
                char ch = s.charAt(i);
                if(curr.map[ch-'a'] == null){
                    curr.map[ch-'a'] = new TrieNode(ch); 
                }
                curr.map[ch-'a'].frequency++; 
                curr = curr.map[ch-'a']; 
                if(i == s.length()-1) curr.isLeaf = true; 
            }
        }
        return root;
    }
} 

public class UniquePrefixes {
    public ArrayList<String> prefix(ArrayList<String> a) {
        ArrayList<String> list = new ArrayList<String>(); 
        if(a == null || a.size() == 0) return list; 
        Trie trie = new Trie(); 
        TrieNode root = trie.buildTrie(a);
        
        for(String s : a) {
            TrieNode curr = root; 
            StringBuilder sb = new StringBuilder(); 
            int i=0; 
            while(i<=s.length()-1) {
                char ch = s.charAt(i);
                if(curr.map[ch-'a'].frequency > 1){
                    sb.append(ch); 
                } else {
                    sb.append(ch);
                    break; 
                }
                curr = curr.map[ch-'a']; 
                i++;  
            }
            list.add(new String(sb));
        }
        return list; 
    }
}
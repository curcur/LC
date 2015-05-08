Implement Trie (Prefix Tree)
/**
 * - Node does not contain character, edge does
 * - Every node have a list of child nodes, and needs to be found quickly
 *   so use hashmap
 * - How to express the end of a word, a special end character is needed, 
 *   or hashmap allows null key and null value, we can use null pair instead
 */

class TrieNode {
    // Initialize your data structure here.
    Map<Character, TrieNode> chlists;
    public TrieNode() {
        chlists = new HashMap<>();
    }
    
    public boolean containsChild(Character c) {
        return chlists.containsKey(c);
    }
    
    public TrieNode getChild(Character c) {
        if (!chlists.containsKey(c))
            chlists.put(c, new TrieNode());
        return chlists.get(c);
    }
    
    public void putEnd() {
        chlists.put(null, null);
    }
}

public class Trie {
    private TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        int length = word.length();
        TrieNode curr = root;
        for(int i=0; i<length; i++) {
            char c = word.charAt(i);
            curr = curr.getChild(c);
        }
        curr.putEnd();
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        int length = word.length();
        TrieNode curr = root;
        for(int i=0; i<length; i++) {
            char c = word.charAt(i);
            if (!curr.containsChild(c))
                return false;
            curr = curr.getChild(c);
        }
        return curr.containsChild(null);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        int length = prefix.length();
        TrieNode curr = root;
        for(int i=0; i<length; i++) {
            char c = prefix.charAt(i);
            if (!curr.containsChild(c))
                return false;
            curr = curr.getChild(c);
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

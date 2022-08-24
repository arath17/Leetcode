import java.util.HashSet;

/*
 * @lc app=leetcode id=208 lang=java
 *
 * [208] Implement Trie (Prefix Tree)
 */

// @lc code=start
class Trie {
    int ALPHABET_SIZE = 26;
    TrieNode root;

    class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            for (TrieNode child : children) {
                child = null;
            }
        }
    }

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode crawler = root;
        int level = 0;
        for (level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = new TrieNode();
            }
            crawler = crawler.children[index];
        }
        crawler.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode crawler = root;
        for (int level = 0; level < word.length(); level++) {
            int index = word.charAt(level) - 'a';
            if(crawler.children[index] == null){
                return false;
            }
            crawler = crawler.children[index];
        }
        return crawler.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        for (int level = 0; level < prefix.length(); level++) {
            int index = prefix.charAt(level) - 'a';
            if(crawler.children[index] == null){
                return false;
            }
            crawler = crawler.children[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-26 23:38
 */
public class WordDictionary {

    TreeNoe root = null;

    class TreeNoe{
        boolean isString = false;
        TreeNoe[] child = new TreeNoe[26];
    }

    /** Initialize your data structure here. */
    public WordDictionary() {

        root = new TreeNoe();

    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TreeNoe cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(cur.child[index] == null){
                cur.child[index] = new TreeNoe();
                cur = cur.child[index];
            }
        }
        cur.isString = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {

      return match(word,root,0);

    }

    private boolean match(String word, TreeNoe root, int n) {
        if(n >= word.length()){
            return root.isString;
        }else {
            char tmp = word.charAt(n);
            if (tmp == '.') {
                for (int i = 0; i < 26; i++) {
                    if(root.child[i] != null && match(word,root.child[i],n+1)){
                        return true;
                    }
                }
                return false;
            }else {
                if (root.child[tmp - 'a'] == null) {
                    return false;
                }
                return match(word, root.child[tmp - 'a'], n + 1);
            }

        }
    }

}

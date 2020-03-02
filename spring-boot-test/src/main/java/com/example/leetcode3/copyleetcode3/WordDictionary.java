package com.example.leetcode3.copyleetcode3;

/**
 * @author yingru.ljw
 * @date 2020-03-02 21:29
 */
public class WordDictionary {


    TreeNode root = null;

    class TreeNode{
        TreeNode[] childs;
        boolean isWord =false;
        public TreeNode(){
            childs = new TreeNode[26];
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TreeNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if(cur.childs[word.charAt(i) -'a'] == null){
                cur.childs[word.charAt(i) - 'a'] = new TreeNode();
            }
            cur = cur.childs[word.charAt(i)-'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(word,root,0);
    }

    private boolean dfs(String word, TreeNode root, int n) {
        if(n >= word.length()){
            return root.isWord;
        }else {
            char tmp = word.charAt(n);
            if(tmp == '.'){
                for (int i = 0; i < 26; i++) {
                    if(root.childs[i] != null){
                        if(dfs(word,root.childs[i],n+1)){
                            return true;
                        }
                    }
                }
                return false;
            }else {
                if(root.childs[word.charAt(n)-'a'] == null){
                    return false;
                }
                root = root.childs[word.charAt(n)-'a'];
                return dfs(word,root,n+1);
            }
        }
    }

}

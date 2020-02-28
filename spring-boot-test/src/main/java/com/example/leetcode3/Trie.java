package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-26 16:05
 */
public class Trie {

    TreeNode root;

    class TreeNode{

        boolean isString;
        TreeNode[] childs;
        public TreeNode(){
            this.childs = new TreeNode[26];
            this.isString = false;
        }

    }

    /** Initialize your data structure here. */
    public Trie() {
        root = new TreeNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index =(int)(word.charAt(i) - 'a');
            if(cur.childs[index] == null){
                cur.childs[index] = new TreeNode();
                cur = cur.childs[index];
            }
        }
        cur.isString = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode node = find(word);
        return node != null && node.isString;
    }

    private TreeNode find(String word) {
        TreeNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int) (word.charAt(i)- 'a');
            if(cur.childs[index] == null){
                return null;
            }
            cur = cur.childs[index];
        }
        return cur;

    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode node = find(prefix);
        return node != null;
    }


}

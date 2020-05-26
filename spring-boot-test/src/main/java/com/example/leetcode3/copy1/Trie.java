package com.example.leetcode3.copy1;

/**
 * @author yingru.ljw
 * @date 2020-03-02 20:19
 */
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));



    }

    TreeNode root;

    class TreeNode{

        boolean isString;
        TreeNode[] childs;

        TreeNode(){
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
            int index = word.charAt(i) - 'a';
            if(cur.childs[index] == null){
                cur.childs[index] = new TreeNode();
                cur = cur.childs[index];
            }
        }
        cur.isString = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TreeNode cur= root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) -'a';
            if(cur.childs[index] == null){
                return false;
            }
            cur = cur.childs[index];
        }
        return cur != null && cur.isString;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TreeNode cur= root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) -'a';
            if(cur.childs[index] == null){
                return false;
            }
            cur = cur.childs[index];
        }
        return cur != null;
    }



}

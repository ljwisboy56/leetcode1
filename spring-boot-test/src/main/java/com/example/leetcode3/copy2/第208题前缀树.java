package com.example.leetcode3.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-30 01:06
 */
public class 第208题前缀树 {
    class Trie {

        Trie root = null;

        private boolean is_string = false;

        private Trie childs[] = new Trie[26];

        public Trie() {
        }

        public void insert(String word) {//插入单词
            Trie cur = root;
            char w[] = word.toCharArray();
            for (int i = 0; i < w.length; ++i) {
                if (cur.childs[w[i] - 'a'] == null) {
                    cur.childs[w[i] - 'a'] = new Trie();
                }
                cur = cur.childs[w[i] - 'a'];
            }
            cur.is_string = true;
        }

        public boolean search(String word) {//查找单词
            Trie cur = root;
            char w[] = word.toCharArray();
            for (int i = 0; i < w.length; ++i) {
                if (cur.childs[w[i] - 'a'] == null) {
                    return false;
                }
                cur = cur.childs[w[i] - 'a'];
            }
            return cur.is_string;
        }

        public boolean startsWith(String prefix) {//查找前缀
            Trie cur = root;
            char p[] = prefix.toCharArray();
            for (int i = 0; i < p.length; ++i) {
                if (cur.childs[p[i] - 'a'] == null) {
                    return false;
                }
                cur = cur.childs[p[i] - 'a'];
            }
            return true;
        }

    }

}

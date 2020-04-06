package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-03-29 14:36
 */
public class 第173题二叉搜索树迭代器 {

    int index;

    List<Integer> list = null;

    public 第173题二叉搜索树迭代器(TreeNode root) {
        list = new ArrayList<>();
        this.fillList(root);
    }

    private void fillList(TreeNode root) {
        if(root == null){
            return;
        }
        if(root.left != null){
            fillList(root.left);
        }
        list.add(root.val);
        if(root.right != null){
            fillList(root.right);
        }
    }

    /** @return the next smallest number */
    public int next() {
        int tmp =  list.get(index);
        index++;
        return tmp;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index != list.size();
    }


}

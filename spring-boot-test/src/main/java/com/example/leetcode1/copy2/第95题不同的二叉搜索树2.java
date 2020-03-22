package com.example.leetcode1.copy2;

import com.example.letcodeeasy.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-22 18:24
 */
public class 第95题不同的二叉搜索树2 {


    public List<TreeNode> generateTrees(int n) {
        if(n <= 0){
            return new LinkedList<>();
        }
        return help(1,n);
    }

    private LinkedList<TreeNode> help(int start, int end) {
        LinkedList<TreeNode> allList = new LinkedList<>();
        if (start > end) {
            allList.add(null);
            return allList;
        }else {
            for (int i = start; i <= end; i++) {
                LinkedList<TreeNode> leftTrees = help(start, i - 1);
                LinkedList<TreeNode> rightTrees = help(i + 1, end);
                for (TreeNode tmp : leftTrees) {
                    for (TreeNode r : rightTrees) {
                        TreeNode current_tree = new TreeNode(i);
                        current_tree.left = tmp;
                        current_tree.right = r;
                        allList.add(current_tree);
                    }
                }
            }
        }
        return allList;
    }
}

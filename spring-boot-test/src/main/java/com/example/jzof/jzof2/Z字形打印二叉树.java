package com.example.jzof.jzof2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author yingru.ljw
 * @date 2019-12-29 22:01
 */
public class Z字形打印二叉树 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>();
        if (pRoot == null) {
            return aList;
        }

        Stack<TreeNode> s1 = new Stack<>();
        s1.add(pRoot);
        Stack<TreeNode> s2 = new Stack<>();
        while (!s1.isEmpty() || !s2.isEmpty()) {
            if (!s1.isEmpty()) {
                ArrayList<Integer> aList2 = new ArrayList<>();
                while (!s1.isEmpty()) {
                    TreeNode p = s1.pop();
                    aList2.add(p.val);
                    if (p.left != null) {
                        s2.add(p.left);
                    }
                    if (p.right != null) {
                        s2.add(p.right);
                    }
                }
                aList.add(aList2);

            } else {
                ArrayList<Integer> aList2 = new ArrayList<>();
                while (!s2.isEmpty()) {

                    TreeNode p = s2.pop();
                    if (p.right != null) {
                        s1.add(p.right);
                    }
                    if (p.left != null) {
                        s1.add(p.left);
                    }
                    aList2.add(p.val);

                }
                aList.add(aList2);
            }
        }
        return aList;
    }

}

package com.example.韩顺平;

import com.example.letcodeeasy.ListNode;
import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-09 21:03
 */
public class PDD2 {

    List<Integer> list = new ArrayList<>();

    public int find(TreeNode root, double target) {

        ThreadLocal<ListNode> t1 = new ThreadLocal<>();
        ThreadLocal t2 = new ThreadLocal();

        t1.get();

        //中序排列
        midOrder(root);

        //定义最大值
        double min = Double.MAX_VALUE;

        int index = 0;

        //遍历中序编列的值
        for (int i = 0; i < list.size(); i++) {
            if(Math.abs(list.get(i) - target) < min){
                min = Math.abs(list.get(i) - target);
                index = i;
            }
        }
        return list.get(index);

    }

    /**
     * 二叉树的中序排列
     * @param root
     */
    private void midOrder(TreeNode root) {

        if(root == null){
            return;
        }

        if(root.left != null){
            midOrder(root.left);
        }

        list.add(root.val);

        if(root.right != null){
            midOrder(root.right);
        }

    }


}

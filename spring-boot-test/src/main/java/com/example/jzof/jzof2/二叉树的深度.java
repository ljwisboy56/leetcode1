package com.example.jzof.jzof2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-29 16:10
 */
public class 二叉树的深度 {

    int depth = 1;

    ArrayList<Integer> list = new ArrayList<>();

    public int TreeDepth(TreeNode root) {
        doTreeDepth(root);
        int max = 0;
        for(int tmp : list){
            max=Math.max(tmp,max);
        }
        return max;
    }

    /**
     *
     *      1
     *   2    3
     *  4 5  6 7
     *     8
     * @param root
     */
    private void doTreeDepth(TreeNode root){

        //说明他是叶子节点，遍历到底了，那么加上他的深度
        if(root!= null && root.right == null && root.left == null){
            list.add(depth);
            //说明他不是叶子节点
        }else {
            depth++;
            if(root != null && root.left != null){
                TreeDepth(root.left);
            }
            if(root != null && root.right != null){
                TreeDepth(root.right);
            }
            depth--;
        }

    }

}

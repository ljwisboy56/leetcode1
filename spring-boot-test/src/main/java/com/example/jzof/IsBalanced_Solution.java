package com.example.jzof;


import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-15 19:47
 */
public class IsBalanced_Solution {

    /**
     *
     * 总结平衡二叉树特点：
     *
     * （1）非叶子节点最多拥有两个子节点；
     *
     * （2）非叶子节值大于左边子节点、小于右边子节点；
     *
     * （3）树的左右两边的层级数相差不会大于1;
     *
     * （4）没有值相等重复的节点;
     *
     *
     *
     *
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {

        if(root == null){
            return true;
        }

        boolean res = IsBalanced_Solution(root.left);

        if(res){
            res = IsBalanced_Solution(root.right);
        }else {
            return false;
        }

        if(res){
            res = doVergere(root);
        }else {
            return false;
        }

        return res;

    }

    private boolean doVergere(TreeNode root) {

        //左右子树的差不能大于1
        if(Math.abs(TreeDepth(root.left)- TreeDepth(root.right)) > 1){
            return false;
        }

        return true;

    }


    int depth = 1;

    ArrayList<Integer> list ;

    public int TreeDepth(TreeNode root) {
        list = new ArrayList<>();
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

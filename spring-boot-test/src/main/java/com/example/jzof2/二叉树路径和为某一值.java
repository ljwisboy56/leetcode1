package com.example.jzof2;

import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-28 15:28
 */
public class 二叉树路径和为某一值 {

    private ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

    private ArrayList<Integer> smallList = new ArrayList<>();

    private int target = 0;

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if(root == null){
            return lists;
        }

        this.target = target;

        this.doFindPath(root);

        return lists;

    }

    private void doFindPath(TreeNode root) {

        if(root == null){
            return;
        }else {
            smallList.add(root.val);
            if(constraint(smallList) && bound(root)){
                lists.add(new ArrayList<>(smallList));
            }else {
                if(root.left != null){
                    doFindPath(root.left);
                }
                if(root.right != null){
                    doFindPath(root.right);
                }
            }
            smallList.remove(smallList.size()-1);
        }

    }

    private boolean bound(TreeNode root) {
        return root.right == null && root.left == null;
    }

    private boolean constraint(ArrayList<Integer> smallList) {
        int sum = 0;
        for(Integer integer : smallList){
            sum += integer;
        }
        return sum == target;

    }
}

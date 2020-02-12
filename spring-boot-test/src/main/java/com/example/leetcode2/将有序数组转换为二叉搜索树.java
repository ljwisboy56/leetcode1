package com.example.leetcode2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-12 18:22
 */
public class 将有序数组转换为二叉搜索树 {


    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums == null || nums.length ==0){
            return null;
        }

        return buildTree(nums,0,nums.length-1);

    }

    private TreeNode buildTree(int[] nums,int start,int end) {
        if(start > end){
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums,start,mid-1);
        root.right = buildTree(nums,mid+1,end);
        return root;
    }



}

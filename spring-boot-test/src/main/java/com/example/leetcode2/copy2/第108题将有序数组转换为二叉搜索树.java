package com.example.leetcode2.copy2;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-03-22 23:16
 */
public class 第108题将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums,0,nums.length-1);
    }

    private TreeNode help(int[] nums,int start,int end) {
        if(start > end){
            return null;
        }
        int mid = (end + start)>>>1;
        TreeNode left = help(nums,start,mid-1);
        TreeNode right = help(nums,mid+1,end);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = left;
        root.right = right;
        return root;
    }

}

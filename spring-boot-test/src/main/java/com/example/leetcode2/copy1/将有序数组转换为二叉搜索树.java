package com.example.leetcode2.copy1;

import com.example.letcodeeasy.TreeNode;

/**
 * @author yingru.ljw
 * @date 2020-02-19 21:21
 */
public class 将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {

        return help(nums,0,nums.length-1);

    }

    private TreeNode help(int[] nums,int start,int end) {
        if(start > end){
            return null;
        }
        int mid = start + (end -start)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = help(nums,start,mid-1);
        root.right = help(nums,mid+1,end);

        return root;

    }
}

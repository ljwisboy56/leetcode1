package com.example.leetcode2.copyleetcode2;

import com.example.letcodeeasy.ListNode;
import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2020-02-19 21:39
 */
public class 有序链表转换二叉搜索树 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(-10);
        ListNode l2 = new ListNode(-3);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;


        TreeNode treeNode = new 有序链表转换二叉搜索树().sortedListToBST(l1);


    }

    public TreeNode sortedListToBST(ListNode head) {

        if(head == null){
            return null;
        }

        ArrayList<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        int[] nums = new int[list.size()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }

        return help(nums,0,nums.length-1);

    }

    private TreeNode dfs(ArrayList<Integer> list, int start , int end) {
        if(start > end){
            return null;
        }
        int mid = start + (end-start)/2;

        TreeNode root = new TreeNode(list.get(mid));
        root.left = dfs(list,start,mid-1);
        root.right = dfs(list,mid+1,end);

        return root;

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

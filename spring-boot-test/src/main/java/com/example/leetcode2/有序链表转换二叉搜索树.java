package com.example.leetcode2;

import com.example.letcodeeasy.ListNode;
import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2020-02-12 18:52
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

        TreeNode res = new 有序链表转换二叉搜索树().sortedListToBST(l1);

        System.out.println(res);
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

        return doBuild(list,0,list.size()-1);

    }

    private TreeNode doBuild(ArrayList<Integer> list, int start, int end) {

        if(start > end){
            return null;
        }

        int mid = start + (end - start)/2;

        TreeNode root = new TreeNode(list.get(mid));

        root.left = doBuild(list,start,mid-1);
        root.right = doBuild(list,mid+1,end);

        return root;

    }

}

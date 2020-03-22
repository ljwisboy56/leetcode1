package com.example.leetcode2.copy2;

import com.example.letcodeeasy.ListNode;
import com.example.letcodeeasy.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-22 23:57
 */
public class 第109题有序链表转换二叉搜索树 {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }

        return help(list,0,list.size()-1);

    }

    private TreeNode help(List<Integer> list, int start, int end) {
        if(start > end){
            return null;
        }else {
            int mid = (start + end)>>>1;
            TreeNode left = help(list,start,mid-1);
            TreeNode right = help(list,mid+1,end);
            TreeNode cur = new TreeNode(list.get(mid));
            cur.left = left;
            cur.right = right;
            return cur;
        }
    }
}

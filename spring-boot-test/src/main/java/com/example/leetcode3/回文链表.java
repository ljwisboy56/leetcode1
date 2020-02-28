package com.example.leetcode3;

import com.example.letcodeeasy.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-28 11:44
 */
public class 回文链表 {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            if (list.get(left).equals(list.get(right))) {
                left++;
                right++;
            } else {
                System.out.println(1);
            }

        }


    }

    public boolean isPalindrome(ListNode head) {

        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            if (list.get(left).equals(list.get(right))) {
                left++;
                right--;
            } else {
                return false;
            }

        }

        return true;
    }
}

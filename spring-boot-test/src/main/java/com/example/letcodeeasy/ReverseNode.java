package com.example.letcodeeasy;

import com.example.order.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


/**
 * @author yingru.ljw
 * @date 2019-11-21 23:45
 */
public class ReverseNode {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> arrayList = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!(stack.isEmpty())){
            arrayList.add(stack.pop());
        }
        return arrayList;

    }




}

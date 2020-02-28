package com.example.leetcode3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2020-02-27 13:02
 */
public class 存在重复元素2 {

    public static void main(String[] args) {
        boolean res = new 存在重复元素2().containsNearbyDuplicate(new int[]{99,99},2);
        System.out.println(res);

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, LinkedList<Integer>> hashMap = new HashMap<>();
        //初始化
        for (int i = 0; i < nums.length; i++) {
            if(hashMap.containsKey(nums[i])){
                LinkedList<Integer> linkedList = hashMap.get(nums[i]);
                int curIndex = linkedList.get(0);
                if(Math.abs(i - curIndex) <= k){
                   return true;
                }
                linkedList.remove(0);
                linkedList.add(i);
            }else {
                LinkedList<Integer> linkedList = new LinkedList<>();
                linkedList.add(i);
                hashMap.put(nums[i],linkedList);
            }
        }
        return false;

    }


}

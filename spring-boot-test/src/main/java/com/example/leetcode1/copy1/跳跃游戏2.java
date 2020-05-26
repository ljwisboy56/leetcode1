package com.example.leetcode1.copy1;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-02-06 21:50
 */
public class 跳跃游戏2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,0};
        boolean res = new 跳跃游戏2().canJump(arr);
        System.out.println(res);

    }

    HashMap<Integer,Boolean> map = new HashMap<>();

    public boolean canJump(int[] nums) {

        if(nums == null || nums.length == 0){
            return true;
        }

        if(nums.length == 1 && nums[0] == 0){
            return true;
        }

        return this.doCanJump(0,nums);

    }

    private boolean doCanJump(int n, int[] nums) {

        if(n >= nums.length-1){
            return true;
        }else {
            for (int i = nums[n];i >= 1;i--){
                if(map.get(i + n) != null && !map.get(i+n)){
                    break;
                }
                map.put(i+n,Boolean.TRUE);
                if(i+n >= nums.length-1){
                    return true;
                }
                if(nums[i+n] != 0 && doCanJump(n+i,nums)){
                    return true;
                }
                map.put(i+n,Boolean.FALSE);
            }
        }
        return false;
    }

}

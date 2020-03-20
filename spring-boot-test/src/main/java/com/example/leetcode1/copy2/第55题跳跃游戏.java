package com.example.leetcode1.copy2;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-03-19 13:02
 */
public class 第55题跳跃游戏 {

    public static void main(String[] args) {
        int[] arr = {2,0};
        System.out.println(new 第55题跳跃游戏().canJump2(arr) );

    }

    public boolean canJump(int[] nums) {
        //定义初始第一步
        int len = 1;
        //从后往前走
        for (int i = nums.length - 2; i >= 0; i--) {
            //如果从后往前能达到最后一个那么len初始化回去，继续向前一个寻找
            if (nums[i] >= len) {
                len = 1;
            } else {
                //如果不能达到最后一个那么前一个元素必须保证能跳多跳一步
                len++;
            }
        }
        return len == 1;
    }

    HashMap<Integer, Boolean> map = new HashMap<>();
    public boolean canJump2(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        if(nums.length == 1 && nums[0] == 0){
            return true;
        }
        return dfs(0, nums);

    }

    private boolean dfs(int n, int[] nums) {
        //当他能到达最后的时候
        if(n >= nums.length-1){
            return true;
        }
        //当该节点的值是0那么设定该节点不能前进
        else if(nums[n] == 0){
            map.put(n,false);
            return false;
        }
        //剩余情况试探从0开始
        else {
            for (int i = nums[n]; i >= 0; i--) {
                if(map.get(i + n) != null && !map.get(i+n)){
                    break;
                }
                map.put(n+i,true);
                if(dfs(n+i,nums)){
                    return true;
                }
                map.put(n+i,false);
            }
            return false;
        }
    }

}

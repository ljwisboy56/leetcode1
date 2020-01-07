package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-07 15:06
 */
public class 跳跃游戏2 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,1,4};
        int[] arr2 = new int[]{3,2,1,0,4};
        int[] arr3 = new int[]{2,0};

        boolean res = new 跳跃游戏2().canJump(arr);

        System.out.println(res);


    }

    /**
     * 动态规划
     * @param nums dp(i) = 找到i之前的节点能不能到达i；
     * @return
     */
    public boolean canJump2(int[] nums){
        //定义dp表
        boolean[] dp = new boolean[nums.length];
        //边界条件
        dp[0] = true;

        for(int i = 1; i < nums.length;i++){
            for (int j = 0;j < i;j++){
                //当前j节点能触达的前提下，当前节点的坐标+最大步长能否触达i，找到这个j节点，就是i之前的那个可触达节点
                if(dp[j] && j + nums[j] >= i){
                    dp[i]  = true;
                    break;
                }
            }
        }

        return dp[nums.length -1 ];

    }



    boolean res = false;

    public boolean canJump(int[] nums) {

        int end = nums.length -1;

        return doCanJump(0, nums,end);

    }

    private boolean doCanJump(int n, int[] nums,int end) {

        if (n == end){
            res =  true;
        } else {
            for (int i = nums[n]; i > 0; i--) {
                n = n + i;
                if(constraint(nums,n,end)){
                    doCanJump(n,nums,end);
                }
                n = n - i;
                if(res){
                    break;
                }
            }
        }
        return res;
    }

    /**
     *
     * @param nums
     * @param n 起始坐标，
     * @param end 还有多少长度
     * @return
     */
    private boolean constraint(int[] nums, int n, int end) {
        if(res){
            return false;
        }
        if(n >= end){
            res = true;
            return false;
        }

        if(nums[n] == 0){
            return false;
        }
        return true;
    }


}

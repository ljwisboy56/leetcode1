package com.example.leetcode1.copy1;

/**
 * @author yingru.ljw
 * @date 2020-02-04 23:19
 */
public class 跳跃游戏 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,1,4};
        int res = new 跳跃游戏().jump2(arr);
        System.out.println(res);

    }

    public int jump2(int[] nums) {

        int max = 0;
        int end = 0;
        int steps = 0;
        for (int i=0;i < nums.length;i++){
            //解析，其中num[i]表示步长，即当前节点能触达的最大步长，
            //num[i]+i表示当前位置+步长，即最远能触达的指针
            max = Math.max(max,nums[i] +i);
            //end表示当前节点能触达的最远边界，即贪心的最远局部边界条件
            //当i指针走到了最远边界的时候，说明一次局部最优解求解完成
            //此时步长+1，然后更新end边界为当前局部条件所能触达的最远边界
            if(i == end){
                end = max;
                steps++;
            }
        }
        return steps;
    }

}

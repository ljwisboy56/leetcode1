package com.example.leetcode1;

/**
 * @author yingru.ljw
 * @date 2020-01-06 19:18
 */
public class 跳跃游戏 {

    //不会，抄袭一下思路：
    //用贪心算法，每次在当前位置上都找到当前位置能跳的最远的那个步长
    /**
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-ii
     */

    /**
     * dp(i,j) =
     */
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        //当前能跳的边界
        int end = 0;
        //当前能跳到的最远边界
        int maxPosition = 0;
        int steps = 0;

        for(int i = 0; i < nums.length -1;i++){
            maxPosition = Math.max(maxPosition,nums[i] +i);
            if(i == end){
                steps++;
                end = maxPosition;
            }
        }
        return steps;

    }


}

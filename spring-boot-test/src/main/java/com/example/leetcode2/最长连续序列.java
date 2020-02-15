package com.example.leetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-15 01:56
 */
public class 最长连续序列 {

    public static void main(String[] args) {
        int res = new 最长连续序列().longestConsecutive(new int[]{-1,0});
        System.out.println(res);


    }

    /**
     * 计数排序
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {

        if(nums == null || nums.length==0){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int tmp : nums){
            min = Math.min(min,tmp);
        }

        int max = Integer.MIN_VALUE;
        for (int tmp : nums){
            max = Math.max(max,tmp);
        }

        int[] bucket = new int[max - min +1];

        for (int i = 0;i < nums.length;i++){
            if(bucket[nums[i]-min] == 0){
                bucket[nums[i]-min] = 1;
            }else {
                bucket[nums[i]-min]++;
            }
        }

        int res = 1;
        int start =0;
        int end = 0;
        boolean flag = true;
        for (int i =0;i < bucket.length;i++){
            if(flag && bucket[i] != 0){
                start = i;
                flag = false;
            }
            else if(!flag && bucket[i] == 0 ){
                end = i;
                res = Math.max(end - start,res);
                start = i;
                flag = true;
            }else if(!flag && bucket.length-1 == i){
                res = Math.max(i - start+1,res);
            }

        }

        return res;

    }
}

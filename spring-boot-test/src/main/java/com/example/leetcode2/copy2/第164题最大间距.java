package com.example.leetcode2.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-28 18:26
 */
public class 第164题最大间距 {


    public int maximumGap(int[] nums) {

        if(nums == null || nums.length < 2){
            return 0;
        }

        ///先排序
        this.sort(nums);

        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(nums[i] - nums[i-1],maxGap);
        }

        return maxGap;

    }

    private void sort(int[] nums) {

        if(nums == null || nums.length == 0){
            return;
        }

        int maxValue = nums[0];
        for(int tmp : nums){
            maxValue = Math.max(tmp,maxValue);
        }

        int len = (maxValue + "").length();

        //设定桶
        int[][] bucket = new int[10][nums.length];
        //设定桶的索引记录器
        int[] bucketSize = new int[10];

        for (int i = 0,step = 1; i < len ; i++,step *= 10) {
            //分配
            for(int tmp : nums){
                int bucketIndex = tmp / step %10;
                bucket[bucketIndex][bucketSize[bucketIndex]] = tmp;
                bucketSize[bucketIndex]++;
            }
            int index = 0;
            //收集,把每个桶内的元素重新汇总
            for (int k =0;k < bucketSize.length;k++){
                if(bucketSize[k] != 0){
                    for (int l =0;l < bucketSize[k];l++){
                        nums[index++] = bucket[k][l];
                    }
                }
                bucketSize[k] = 0;
            }
        }
    }

}

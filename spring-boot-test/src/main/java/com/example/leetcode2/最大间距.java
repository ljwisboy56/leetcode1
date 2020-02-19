package com.example.leetcode2;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-17 17:43
 */
public class 最大间距 {

    public static void main(String[] args) {

        int[] arr = new int[]{1,6,9,100};

        int res = new 最大间距().maximumGap(arr);

        System.out.println(res);

    }

    public int maximumGap(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }


        countSort(nums);

        int maxGap = nums[1] - nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(nums[i] - nums[i-1],maxGap);
        }

        return maxGap;

    }

    public void radixSort(int[] arr){

        int max =arr[0];
        for (int tmp : arr){
            max = Math.max(tmp,max);
        }
        //求出这个数是多少卫
        int maxLen = (max + "").length();

        //定义二维数组，10个桶，每个桶里面能放多少个元素
        int[][] bucket = new int[10][arr.length];

        //他是用来存储每个桶的坐标最大值的
        int[] bucketSize = new int[10];

        //记录下n一个步长
        for (int i =0,n=1; i < maxLen;i++,n*=10){
            //分配
            for (int value : arr) {
                //找到放到第几个桶
                int bucketIndex = value / n % 10;

                //放到第几个桶的第几个位置，因为元素就是桶内的最大数量
                bucket[bucketIndex][bucketSize[bucketIndex]] = value;

                //更新桶的指针的最大数量
                bucketSize[bucketIndex]++;
            }

            int index = 0;
            //收集,把每个桶内的元素重新汇总
            for (int k =0;k < bucketSize.length;k++){
                if(bucketSize[k] != 0){
                    for (int l =0;l < bucketSize[k];l++){
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketSize[k] = 0;
            }
        }
    }

    public void countSort(int[] arr){

        //先找到最大
        int max = Integer.MIN_VALUE;
        for (int tmp : arr){
            max = Math.max(tmp,max);
        }

        //再找最小
        int min = Integer.MAX_VALUE;
        for (int tmp : arr){
            min = Math.min(tmp,min);
        }

        //设定好所有的桶
        int[] buckets = new int[max-min+1];

        //将所有元素划分到不同的桶里，如果这个桶本身有数据了则++；
        //每个桶的下标索引标志的是值，然而数组的值标志的是重复元素的个数
        //其实和bitmap思想是一样的
        for (int value : arr) {
            buckets[value - min]++;
        }

        int k=0;
        for (int i=0;i <buckets.length;i++){
            while (buckets[i] !=0){
                arr[k] = min + i;
                k++;
                buckets[i]--;
            }
        }

    }
}

package com.example.leetcode2.copyleetcode2;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author yingru.ljw
 * @date 2020-02-20 22:23
 */
public class 最长连续序列 {


    public static void main(String[] args) {
        int[] arr = new int[]{100, 4, 200, 1, 3, 2};
        int res = new 最长连续序列().longestConsecutive(arr);
        System.out.println(res);

    }

    public int longestConsecutive(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int tmp : nums){
            treeSet.add(tmp);
        }

        int i =0;
        for (Integer integer : treeSet){
            nums[i++] = integer;
        }

        return find(nums);

    }

    private int find(int[] nums){

        int res = 1;
        int tmp = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]+1){
                tmp++;
            }else{
                tmp=1;
            }
            res = Math.max(res,tmp);
        }
        return res;

    }

    public void radixSort(int[] arr){

        //创建10个桶
        int[][] bucket = new int[10][arr.length];

        //记录每个桶内的索引
        int[] bucketSize = new int[10];

        //找出最大值
        int maxValue = arr[0];
        for (int tmp :arr){
            maxValue = Math.max(maxValue,tmp);
        }

        //找出最大长度
        int len = (maxValue + "").length();

        for (int k = 0,n =1 ; k < len; k++,n *= 10) {
            //分配
            for (int value : arr) {
                //计算出元素的个位在桶内的指针
                int bucketIndex = value / n % 10;
                //分配
                bucket[bucketIndex][bucketSize[bucketIndex]] = value;
                //移动每个桶内的指针
                bucketSize[bucketIndex]++;
            }
            int index = 0;
            //重组
            for (int i = 0; i < bucketSize.length; i++) {
                if(bucketSize[i] != 0){
                    for (int j = 0; j < bucketSize[i]; j++) {
                        arr[index++] = bucket[i][j];
                    }
                }
                bucketSize[i] = 0;
            }
        }

    }




}

package com.example.排序;

import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2020-02-17 20:57
 */
public class 基数排序 {

    public static void main(String[] args) {

        int[] arr = new int[]{23,23,24,43,13,11,2,3,4,3};
        new 基数排序().radixSort(arr);
        Arrays.stream(arr).forEach(System.out::println);

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
            System.out.println(Arrays.toString(arr));
        }
    }

}

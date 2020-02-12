package com.example.排序;

import com.example.leetcode1.leetcodecopy1.颜色分类;

/**
 * @author yingru.ljw
 * @date 2020-02-04 18:24
 */
public class 计数排序 {

    public static void main(String[] args) {

        int[] arr = new int[]{100,2,5,1,1,10,8};
        new 计数排序().countSort(arr);
        System.out.println(arr);
    }

    /**
     * @link https://blog.csdn.net/weixin_41922289/article/details/89354587
     * 当数据散列比较均匀的时候可以用桶排序/计数排序，比如我要排1、2、10000的时候，最大和最小值差比较大
     * 就不能用桶排序
     * @param arr
     */
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
            int index = value - min;
            buckets[index]++;
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

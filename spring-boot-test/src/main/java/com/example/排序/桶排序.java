package com.example.排序;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author yingru.ljw
 * @date 2020-02-04 20:13
 */
public class 桶排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{22,1,100,30,40,23,4};
        new 桶排序().bucketSort(arr);
        System.out.println(arr);
    }

    public void bucketSort(int[] arr){

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

        //桶的数量
        int bucketNum = (max - min) / arr.length +1;

        //设定多个桶并且初始化
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
        for (int i =0; i < bucketNum;i++){
            bucketList.add(new ArrayList<>());
        }

        //把每个数散列到相应的桶中
        for (int value : arr) {
            //这个看里面有多少个跨度，来散列
            int num = (value - min) / bucketNum;
            bucketList.get(num).add(value);
        }

        //每个桶排序
        for(ArrayList<Integer> list : bucketList){
            Collections.sort(list);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (ArrayList<Integer> tmp : bucketList){
            res.addAll(tmp);
        }

        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

    }

}

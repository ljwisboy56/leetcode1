package com.example.leetcode1.leetcodecopy1;

import java.util.*;

/**
 * @author yingru.ljw
 * @date 2020-02-02 22:43
 */
public class 下一个排列 {

    public static void main(String[] args) {

        int[] arr = new int[]{5,4,7,5,3,2};


        new 下一个排列().nextPermutation(arr);

        System.out.println(1);





    }

    public void nextPermutation(int[] nums) {

        if(nums == null || nums.length == 0){
            return;
        }

        String key = "";

        for (int tmp : nums){
            key += "-"+tmp;
        }

        quanpailie(0,nums);

        Collections.sort(index);

        int curIndex = index.indexOf(key);


        if(curIndex == index.size()-1){
            String value = index.get(0);
            ArrayList<Integer> list = map.get(value);
            for (int i =0;i < nums.length;i++){
                nums[i] = list.get(i);
            }
        }else {
            String value = index.get(curIndex+1);
            ArrayList<Integer> list = map.get(value);
            for (int i =0;i < nums.length;i++){
                nums[i] = list.get(i);
            }
        }


    }


    LinkedHashMap<String,ArrayList<Integer>> map = new LinkedHashMap<>();

    ArrayList<Integer> curList = new ArrayList<>();

    ArrayList<String> index = new ArrayList<>();

    public void quanpailie(int t,int[] array){

        if(t >= array.length){
            curList = new ArrayList<>();
            String key = "";
            for(int  tmp : array){
                key += "-" + tmp;
                curList.add(tmp);
            }
            if(!index.contains(key)){
                index.add(key);
                map.put(key,curList);
            }

        }else {
            for(int i = t;i< array.length;i++){
                swap(array,t,i);
                //加一层排序就变成了有序
                quanpailie(t+1,array);
                swap(array,t,i);
            }

        }



    }

    private static void swap(int[] array, int t, int i) {
        int tmp = array[i];
        array[i] = array[t];
        array[t] = tmp;
    }


}

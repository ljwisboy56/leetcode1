package com.example.jzof;

import com.example.order.In;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yingru.ljw
 * @date 2019-12-15 15:27
 */
public class PrintMinNumber {

    ArrayList<ArrayList<Integer>> allList = new ArrayList<>();


    public static void main(String[] args) {


        int[] arr= new int[]{1,2,3,4,5,6};
        String abc = new PrintMinNumber().PrintMinNumber(arr);
        System.out.println(abc);
    }

    /**
     * 回溯法全排列
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {

        if(numbers == null || numbers.length == 0){
            return null;
        }

        doMinNumer(numbers,0);

        long min = Long.MAX_VALUE;

        for(ArrayList<Integer> integers:allList){
            StringBuilder str = new StringBuilder();
            for(Integer integer:integers){
                str.append(integer);
            }
            //转成数字
            long strInt = Long.valueOf(str.toString());
            min = Math.min(strInt,min);
        }
        return String.valueOf(min);
    }

    private void doMinNumer(int[] numbers, int t) {

        if(t >= numbers.length){
            ArrayList<Integer> tmpList = new ArrayList<>();
            for(int num : numbers){
                tmpList.add(num);
            }
            allList.add(tmpList);
        }else {
            for(int i = t;i<numbers.length;i++){
                swap(numbers,t,i);
                doMinNumer(numbers,t+1);
                swap(numbers,t,i);
            }
        }
    }

    private void swap(int[] numbers, int t, int i) {
        int tmp = numbers[t];
        numbers[t] = numbers[i];
        numbers[i]=tmp;
    }
}

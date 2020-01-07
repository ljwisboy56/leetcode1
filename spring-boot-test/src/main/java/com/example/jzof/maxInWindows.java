package com.example.jzof;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-21 20:28
 */
public class maxInWindows {

    public static void main(String[] args) {

        int[] nums = new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer>  list = new maxInWindows().maxInWindows(nums,3);
        System.out.println(list);
    }


    int length ;

    ArrayList<Integer> list = new ArrayList();

    public ArrayList<Integer> maxInWindows(int [] num, int size){

        length = num.length;

        domaxInWindows(0,num,size);

        return list;

    }

    private ArrayList<Integer> domaxInWindows(int t, int[] num, int size) {
        if(t > length - size){
            int max = selectMaxValue(t,size,num);
            list.add(max);
        }else {
            domaxInWindows(t+1,num,size);
        }
        return list;

    }


    private int selectMaxValue(int t, int size, int[] num) {
        int max = Integer.MIN_VALUE;
        for(int i = t;i <= size;i++){
            max = Math.max(num[i],max);
        }
        return max;
    }
}

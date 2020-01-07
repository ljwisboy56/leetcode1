package com.example.jzof;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-21 20:50
 */
public class maxooo {

    public static void main(String[] args) {

        int[] nums = new int[]{2,3,4,2,6,2,5,1};
        ArrayList<Integer>  list = new maxooo().maxInWindows(nums,3);
        System.out.println(list);
    }


    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> maxInWindows(int [] num, int size){
        if(num == null){
            return list;
        }

        if(size == 0){
            return list;
        }
        for(int i =0;i <= num.length-size;i++){
            int max = selectMaxValue(i,size,num);
            list.add(max);
        }
        return list;
    }

    private int selectMaxValue(int t, int size, int[] num) {
        int count = 1;
        int max = Integer.MIN_VALUE;
        System.out.println("---------");
        for(int i = t;i <= t+size-1;i++){
            max = Math.max(num[i],max);
            System.out.println(num[i]);

        }
        return max;
    }
}

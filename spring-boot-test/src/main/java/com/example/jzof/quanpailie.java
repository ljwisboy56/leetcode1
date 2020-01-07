package com.example.jzof;

import com.example.order.In;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * @author yingru.ljw
 * @date 2019-12-14 20:22
 */
public class quanpailie {


    static int[] array = new int[]{1,2,3};

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static ArrayList curList = new ArrayList();

    public static void main(String[] args) {

        quanpailie(0);

        list.forEach(System.out::println);

    }

    /**
     *
     * 肯定是回溯，然后呢用的是排列树
     *
     *
     *
     *
     */
    public static void quanpailie(int t){


        if(t >= array.length){
            curList = new ArrayList();
            for(int  tmp : array){
                curList.add(tmp);
            }
            list.add(curList);
        }else {
            for(int i = t;i< array.length;i++){
                swap(array,t,i);
                quanpailie(t+1);
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

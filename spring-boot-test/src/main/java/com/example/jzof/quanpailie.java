package com.example.jzof;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author yingru.ljw
 * @date 2019-12-14 20:22
 */
public class quanpailie {

    static int[] array = new int[]{1,3,4,2};

    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    static ArrayList curList = new ArrayList();

    public static void main(String[] args) {

        Arrays.sort(array);
        new quanpailie().quanpailie2(0,array);
        list.forEach(System.out::println);
        System.out.println(list.size());
    }

    /**
     * 肯定是回溯，然后呢用的是排列树
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


    /**
     * 排列树用我自己这个实现，这个是比较好的
     * @param t
     * @param array
     */
    public void quanpailie2(int t,int[] array){
        if(t >= array.length-1){
            ArrayList<Integer> tmpList = new ArrayList<>();
            for(int  tmp : array){
                tmpList.add(tmp);
            }
            list.add(tmpList);
        }else {
            for(int i = t;i< array.length;i++){
                if(list.size()==5){
                    System.out.println(1);
                }
                swap(array,t,i);
                //加一层排序就变成了有序
                quanpailie2(t+1,array);
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

package com.example.leetcode1.copy1;


import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-02-01 23:45
 */
public class 字排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        List<List<Integer>> allList = new 字排序().zipaixu(arr,0);
        System.out.println(allList.toString());


    }

    //[[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
    //[[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
    public List<List<Integer>> allList = new ArrayList<>();

    int[] x;

    int target;


    public List<List<Integer>> zipaixu(int[] arr, int target) {

        this.target = target;

        x = new int[arr.length];

        doFind2(0, arr);

        return allList;

    }

    private void doFind(int n, int[] arr) {

        if (n >= arr.length) {
            output(x, arr);
        } else {
            for (int i = 0; i <= 1; i++) {
                x[n] = i;
                doFind(n + 1, arr);
                x[n] = 0;
            }
        }


    }

    private void output(int[] x, int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < x.length; i++) {
            if (x[i] == 1) {
                list.add(arr[i]);
            }
        }
        allList.add(list);
    }

    List<Integer> list = new ArrayList<>();

    private void doFind2(int n, int[] arr) {

        if (n >= arr.length) {
            allList.add(new ArrayList<>(list));
        } else {
            for (int i = 0; i <= 1; i++) {
                if(i == 1){
                    list.add(arr[n]);
                }
                doFind2(n + 1, arr);
                if(i == 1){
                    list.remove(list.size()-1);
                }
            }
        }


    }
}

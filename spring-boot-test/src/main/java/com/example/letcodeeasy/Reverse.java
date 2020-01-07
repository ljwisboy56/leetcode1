package com.example.letcodeeasy;

import com.example.order.In;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author yingru.ljw
 * @date 2019-11-19 22:35
 */
public class Reverse {

    public static void main(String[] args) {
        int[] arr = new int[]{
                23,24,43,13,11,2,3,4,3
        };

        reverse(arr);
        Arrays.stream(arr).forEach(System.out::println);

    }

    private static void reverse(int[] arr) {

        for(int i = 0;i < arr.length /2 ;i++){
            swap(arr,i,arr.length-1-i);
        }

    }

    private static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;

    }
}

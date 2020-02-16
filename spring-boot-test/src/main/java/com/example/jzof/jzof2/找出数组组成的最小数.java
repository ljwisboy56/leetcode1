package com.example.jzof.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-29 14:56
 */
public class 找出数组组成的最小数 {


    String str = "";

    long min = Long.MAX_VALUE;

    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0){
            return str;
        }

        doFindMinValue(0,numbers);
        return str;

    }

    private void doFindMinValue(int n, int[] numbers) {

        if(n >= numbers.length){
            long value = countSum(numbers);
            if(value < min){
                min = value;
            }
            str =  String.valueOf(min);
        }else {
            for(int i = n;i < numbers.length;i++){
                swap(numbers,i,n);
                doFindMinValue(n+1,numbers);
                swap(numbers,i,n);
            }
        }
    }

    private long countSum(int[] numbers) {
        String res = "";
        for(int tmp : numbers){
            res += String.valueOf(tmp);
        }

        return Long.valueOf(res);

    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

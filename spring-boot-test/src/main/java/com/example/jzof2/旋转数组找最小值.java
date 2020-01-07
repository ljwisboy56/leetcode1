package com.example.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-22 19:47
 */
public class 旋转数组找最小值 {


    public static void main(String[] args) {

        int[] arr = new int[]{2,3,4,5,5,6,1,2};
        int res = new 旋转数组找最小值().minNumberInRotateArray(arr);
        System.out.println(res);

    }


    public int minNumberInRotateArray(int [] array) {

        int res = 0;

        if(array == null || array.length == 0){
            return res;
        }

        for(int i =0;i < array.length -1;i++){
            if(array[i] >= array[i+1]){
                return array[i+1];
            }
        }

        return array[0];

    }



}

package com.example.jzof;

/**
 * @author yingru.ljw
 * @date 2019-12-15 16:59
 */
public class InversePairs {

    public int InversePairs(int [] array) {

        if(array == null || array.length == 0){
            return 0%1000000007;
        }

        int num = 0;

        for(int i = 0;i< array.length;i++ ){
            for(int j = i;j<array.length;j++){
                if(array[i] > array[j]){
                    num++;
                }
            }
        }

        return num%1000000007;

    }






}

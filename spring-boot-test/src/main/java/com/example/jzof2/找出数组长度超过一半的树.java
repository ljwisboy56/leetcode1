package com.example.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-29 01:28
 */
public class 找出数组长度超过一半的树 {

    public int MoreThanHalfNum_Solution(int [] array) {

        if(array == null){
            return 0;
        }

        for(int tmp : array){
            if(constraint(array,tmp)){
                return tmp;
            }
        }
        return 0;

    }

    private boolean constraint(int[] array,int x) {

        int sum = array.length/2;
        int count = 0;
        for(int a : array){
            if(a == x){
                count++;
            }
        }
        return count > sum;
    }

}

package com.example.jzof2;

import java.util.ArrayList;

/**
 * @author yingru.ljw
 * @date 2019-12-22 23:45
 */
public class 调整数组中奇数偶数的位置 {


    public void reOrderArray(int [] array) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int tmp : array){
            if(tmp %2 == 1){
                list.add(tmp);
            }
        }

        for(int tmp : array){
            if(tmp % 2 ==0){
                list.add(tmp);
            }
        }

        for(int i = 0;i < list.size();i++){
            array[i] = list.get(i);
        }
    }

}

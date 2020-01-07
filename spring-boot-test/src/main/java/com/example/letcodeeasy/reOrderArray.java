package com.example.letcodeeasy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2019-11-25 00:47
 */
public class reOrderArray {


    public void reOrderArray(int [] array) {

        List<Integer> list = new ArrayList<>();

        for (int value : array) {

            if (value % 2 == 1) {
                list.add(value);
            }
        }

        for (int value : array) {

            if (value % 2 == 0) {
                list.add(value);
            }
        }

        for(int i = 0;i < list.size();i++){
            array[i] = list.get(i);
        }
    }

}

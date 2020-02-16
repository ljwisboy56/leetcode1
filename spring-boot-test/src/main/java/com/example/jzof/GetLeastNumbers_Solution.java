package com.example.jzof;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2019-12-07 20:55
 */
public class GetLeastNumbers_Solution {


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();


        if(input == null || k <= 0){
            return list;
        }

        if(input.length < k){
            return list;
        }


        Arrays.sort(input);


        for (int i = 0;i < k;i++){
            list.add(input[i]);
        }


        return list;

    }
}

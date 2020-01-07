package com.example.jzof2;

import java.util.HashSet;

/**
 * @author yingru.ljw
 * @date 2019-12-29 15:36
 */
public class 逆序对的总数 {

    HashSet<String> set = new HashSet<>();

    int count= 0;

    public int InversePairs(int [] array) {

        if(array == null || array.length == 0){
            return 0%1000000007;
        }

        for(int i = 0;i < array.length;i++){
            for(int j = i+1 ;j < array.length;j++){
                String key = array[i] + "-" + array[j];
                if(set.contains(key)){
                    continue;
                }else {
                    set.add(key);
                    if(array[i] >= array[j]){
                        count++;
                    }
                }
            }
        }
        return count%1000000007;

    }
}

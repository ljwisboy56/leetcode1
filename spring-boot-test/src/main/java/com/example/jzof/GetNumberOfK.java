package com.example.jzof;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2019-12-15 19:16
 */
public class GetNumberOfK {

    Map<Integer,Integer> map = new HashMap<>();

    public int GetNumberOfK(int [] array , int k) {

        if(array == null || array.length == 0){
            return 0;
        }

        for(int tmp : array){
            if(map.get(tmp) == null){
                map.put(tmp,1);
            }else {
                Integer value = map.get(tmp);
                map.put(tmp,++value);
            }
        }



        Integer res =  map.get(k);
        if(res == null){
            return 0;
        }else {
            return res;
        }

    }
}

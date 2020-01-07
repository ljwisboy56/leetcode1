package com.example.jzof;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2019-12-15 20:58
 */
public class FindNumsAppearOnce {


    Map<Integer,Integer> map = new HashMap<>();

    /**
     *
     *
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        if(array == null || array.length == 0){
            return;
        }

        for(int tmp : array){
            if(map.get(tmp) == null){
                map.put(tmp,1);
            }else {
                Integer value =map.get(tmp);
                map.put(tmp,++value);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(list.size() == 2){
                break;
            }
            if(entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }

        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }


}

package com.example.jzof2;

import com.example.order.In;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2019-12-29 15:18
 */
public class 第一个只出现一次的字符 {

    LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();

    public int FirstNotRepeatingChar(String str) {

        if(str == null){
            return -1;
        }

        char[] chars = str.toCharArray();

        for(char cc : chars){
            if(map.containsKey(cc)){
                Integer v = map.get(cc);
                map.put(cc,++v);
            }else {
                map.put(cc,1);
            }
        }


        Character character = null;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                character =  entry.getKey();
                break;
            }
        }

        if(character == null){
            return -1;
        }else {
            return str.indexOf(character);
        }

    }
}

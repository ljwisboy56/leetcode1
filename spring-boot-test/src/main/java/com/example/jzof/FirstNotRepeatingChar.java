package com.example.jzof;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yingru.ljw
 * @date 2019-12-15 16:26
 */
public class FirstNotRepeatingChar {


    public static void main(String[] args) {
        int res = new FirstNotRepeatingChar().FirstNotRepeatingChar("google");
        System.out.println(res);
    }

    Map<Character, Integer> map = new LinkedHashMap<>();


    public int FirstNotRepeatingChar(String str) {

        int res = -1;

        char[] chars = str.toCharArray();


        for (char aChar : chars) {
            if (map.get(aChar) == null) {
                map.put(aChar, 1);
            } else {
                Integer value = map.get(aChar);
                map.put(aChar, ++value);
            }
        }

        //一个记录位置的数组
        Character min = null;

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                min = entry.getKey();
                break;
            }
        }

        if(min !=null){
            int num = 0;
            for (char tmp : chars){
                if(tmp == min){
                    res = num;
                }
                num++;
            }
        }else {
            res = -1;
        }

        return res;
    }

}

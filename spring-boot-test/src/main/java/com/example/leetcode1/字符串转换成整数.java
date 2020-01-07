package com.example.leetcode1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2019-12-30 20:15
 */
public class 字符串转换成整数 {
    static HashMap<Character,Integer> map = null;

    static {
        map = new HashMap<>();
        map.put('0',0);
        map.put('1',1);
        map.put('2',2);
        map.put('3',3);
        map.put('4',4);
        map.put('5',5);
        map.put('6',6);
        map.put('7',7);
        map.put('8',8);
        map.put('9',9);
    }


    public static void main(String[] args) {
//        double a = Math.pow(10,2);
//        System.out.println(a);

        int res = new 字符串转换成整数().myAtoi("-123");
        System.out.println(res);


    }


    public int myAtoi(String str) {
        boolean flag = false;

        if(str == null){
            return 0;
        }

        str = str.trim();



        char[] chars = str.toCharArray();

        if(chars[0] == '-'){
            flag = true;
        }

        if(chars[0] == '+'){
            flag = false;
        }

        List<Character> list = new ArrayList<>();

        for (char tmp : chars){
            if(map.containsKey(tmp)){
                list.add(tmp);
            }else {
                continue;
            }
        }

        //"123"
        //拼装成树
        int di = 1;
        int resInt = 0;
        for(int i= list.size()-1;i >= 0;i--){
           int tmp = map.get(list.get(i));
           di = di * 10 ;
           resInt = resInt + tmp * di;
        }

        if(flag){
            return  -resInt/10;
        }else {
            return resInt/10;
        }

    }
}

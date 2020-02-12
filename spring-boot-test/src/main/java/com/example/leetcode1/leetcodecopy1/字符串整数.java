package com.example.leetcode1.leetcodecopy1;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2020-01-19 23:50
 */
public class 字符串整数 {

    public static void main(String[] args) {

        int res = new 字符串整数().myAtoi("+1");
        System.out.println(res);


    }

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

    public int myAtoi(String str) {

        if(str == null || "".equals(str)){
            return 0;
        }

        int start = 0;
        int end = 0;
        int len = str.length();

        boolean flag = false;

        while (str.charAt(start) == ' '){
            start++;
        }

        if(str.charAt(start) == '-'){
            start++;
            flag = true;
        }

        if(str.charAt(start) == '+'){
            start++;
            flag = false;
        }

        if(str.length() == start){
            return 0;
        }

        //如果不合法则返回0；
        if(!map.containsKey(str.charAt(start))){
            return 0;
        }


        for (int i = start;i < len;i++){
            if(end != 0){
                break;
            }
            if(map.containsKey(str.charAt(i))){
                start = i;
                for (int j = i+1;j <len;j++){
                    if(map.containsKey(str.charAt(j))){
                        end = j;
                    }else {
                        break;
                    }
                }
            }else {
                break;
            }
        }

        long ll;
        if(flag){
            ll = - Long.valueOf(str.substring(start,end+1));
        }else {
            ll = Long.valueOf(str.substring(start,end+1));
        }

        if(ll > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(ll < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int) ll;


    }

}

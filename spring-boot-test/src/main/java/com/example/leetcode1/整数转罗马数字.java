package com.example.leetcode1;

import com.example.order.In;

import java.util.HashMap;

/**
 * @author yingru.ljw
 * @date 2019-12-31 21:18
 */
public class 整数转罗马数字 {

    private static HashMap<Integer,String> map = new HashMap<>();

    static {
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        map.put(4,"IV");
        map.put(9,"IX");
        map.put(40,"XL");
        map.put(90,"XC");
        map.put(400,"CD");
        map.put(900,"CM");
    }


    public String intToRoman(int num) {

        char[] chars = String.valueOf(num).toCharArray();

        StringBuilder res = new StringBuilder();

        for(int i = chars.length-1; i >= 0;i--){
            res.append(doRule(Integer.parseInt(String.valueOf(chars[chars.length-1-i])),i));
        }

        return res.toString();

    }

    public String doRule(Integer integer,Integer pp) {

        StringBuilder res = new StringBuilder();
        int base = count(pp);
        int n = 1;
        while (true) {
            if (integer == 4) {
                res.append(map.get(4*base));
                break;
            } else if (integer == 5) {
                res.append(map.get(5*base));
                break;
            }else if(integer == 9){
                res.append(map.get(9*base));
                break;
            } else {
                if(n <= integer){
                    if(n <= 3){
                        res.append(map.get(base));
                    }else if(n == 4){
                        res.setLength(0);
                        res.append(map.get(4*base));
                    }else if(n == 5){
                        res.setLength(0);
                        res.append(map.get(5*base));
                    }else if(n == 9){
                        res.setLength(0);
                        res.append(map.get(9*base));
                    }else {
                        res.append(map.get(base));
                    }
                    n++;
                }else {
                    break;
                }
            }
        }
        return res.toString();
    }

    private int count(Integer integer) {
        int res =1;
        for (int i =0;i <= integer;i++){
            res *= 10;
        }
        return res/10;
    }

}

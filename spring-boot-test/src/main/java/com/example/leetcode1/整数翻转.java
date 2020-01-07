package com.example.leetcode1;

import com.example.order.In;

/**
 * @author yingru.ljw
 * @date 2019-12-30 19:54
 */
public class 整数翻转 {

    public static void main(String[] args) {
        String x = "-012";
        Integer v = Integer.valueOf(x);
//        System.out.println(v);
        int res = new 整数翻转().reverse(-120);
        System.out.println(res);


    }


    public int reverse(int x) {

        int result = 0;

        try{
            String xStr = String.valueOf(x);
            char[] xChars = xStr.toCharArray();

            //第一种情况为负数
            if(xChars[0] == '-'){
                char[] res = new char[xChars.length-1];
                for(int i = xChars.length-1;i >= 1;i--){
                    res[xChars.length-1-i] = xChars[i];
                }
                result = -Integer.valueOf(new String(res));
            }else {
                char[] res = new char[xChars.length];
                for(int i = xChars.length-1;i >= 0;i--){
                    res[xChars.length-1-i] = xChars[i];
                }
                result = Integer.valueOf(new String(res));
            }
        }catch (Exception e){
            return 0;
        }
        return result;
    }

}

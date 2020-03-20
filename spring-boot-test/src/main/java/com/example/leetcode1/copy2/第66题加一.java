package com.example.leetcode1.copy2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yingru.ljw
 * @date 2020-03-19 23:44
 */
public class 第66题加一 {

    public static void main(String[] args) {
        int[] res = new 第66题加一().plusOne(new int[]{9,9,9});
        System.out.println(res);

    }


    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return null;
        }
        //用来存储
        List<Integer> list = new ArrayList<>();
        boolean flag = false;
        for (int i = digits.length-1; i >= 0 ; i--) {
            int val = digits[i] % 10;
            if(i == digits.length -1){
                val++;
            }
            else if(flag){
                val++;
            }
            //标志是否进位
            flag = val == 10;
            list.add(val % 10);
        }

        //处理最后一次
        if(flag){
            list.add(1);
        }

        //输出结果
        int[] res = new int[list.size()];
        for (int i = list.size()-1; i >=0 ; i--) {
            res[list.size()-1-i]=list.get(i);
        }
        return res;
    }

}

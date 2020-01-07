package com.example.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-29 14:52
 */
public class 整数中1出现的次数 {

    public int NumberOf1Between1AndN_Solution(int n) {

        int num = 0;
        //把每个数都转成字符串来处理
        for(int j = 1;j<=n;j++){
            String nstr= String.valueOf(j);
            char[] chars = nstr.toCharArray();
            for (char aChar : chars) {
                if (aChar == '1') {
                    num++;
                }
            }
        }
        return num;

    }
}

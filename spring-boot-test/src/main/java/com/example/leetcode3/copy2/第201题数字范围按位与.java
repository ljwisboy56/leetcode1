package com.example.leetcode3.copy2;

/**
 * @author yingru.ljw
 * @date 2020-03-30 00:00
 */
public class 第201题数字范围按位与 {

    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while (m != n){
            m >>= 1;
            n >>= 1;
            //用count来记录左移了多少步，到时候右移回来
            count++;
        }
        return m <<=count;
    }

}

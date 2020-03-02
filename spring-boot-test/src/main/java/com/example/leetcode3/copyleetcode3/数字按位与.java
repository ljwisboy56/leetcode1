package com.example.leetcode3.copyleetcode3;

/**
 * @author yingru.ljw
 * @date 2020-03-02 14:07
 */
public class 数字按位与 {


    /**
     * 解析：
     * 2种情况讨论：当n的二进制位数大于m则一定为0，因为进位的过程中，肯定有某位是0，只要有一位是0那么整个竖式都是0
     * 另一种情况：我们只需要右移两个数，当他们两个相等的时候，说明是最高位相等了，那此时再把数右移回来就是与的结果。
     * @param m
     * @param n
     * @return
     */
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

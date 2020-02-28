package com.example.leetcode3;

/**
 * @author yingru.ljw
 * @date 2020-02-26 12:21
 */
public class 数字范围按位与 {


    /**
     *
     * 5:0 1 0 1
     * 6:0 1 1 0
     * 7:0 1 1 1
     * -----------
     *   0 1 0 0
     *
     *考虑范围[m, n]，如果n比m二进制位数高的话，在累计按位与的过程中，数字的每一个二进制位数必然都出现过0，所以一旦出现位数不同的情况，结果必然为0。
     *
     * 程序中，m, n在向右移位的过程中，如果m, n相等了，就说明累计按位与的左边肯定等于m, n此时的状态，这时候就可以向左移回来了，相当于右边所有位数都补0，相等的部分照旧。
     *
     * 如果m, n位数不相等，肯定会移到底，两者都为0时才会相等停止循环，这时候再向左移多少结果都是0。
     *
     * 作者：tuotuoli
     * 链接：https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/solution/yi-wei-suan-fa-by-tuotuoli/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     */
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0; // 统计移位次数
        while (m != n)
        {
            m >>= 1;
            n >>= 1;
            count++;
        }
        n <<= count;
        return n;
    }

}

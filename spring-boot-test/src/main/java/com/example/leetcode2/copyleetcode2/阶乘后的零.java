package com.example.leetcode2.copyleetcode2;

/**
 * @author yingru.ljw
 * @date 2020-02-23 15:31
 */
public class 阶乘后的零 {

    /**
     * 说下思路：
     * 找出有多少个5，有多少个25，有多少个125以此类推，
     * 因为想要末尾为0只能是2*5，2又远大于5的个数，所以只要看因子里面有多少个5
     * 因为每隔 5 个数出现一个 5，所以计算出现了多少个 5，我们只需要用 n/5 就可以算出来。
     *
     * 但还没有结束，继续分析。
     *
     * ... * (1 * 5) * ... * (1 * 5 * 5) * ... * (2 * 5 * 5) * ... * (3 * 5 * 5) * ... * n
     *
     * 每隔 25 个数字，出现的是两个 5，所以除了每隔 5 个数算作一个 5，每隔 25 个数，还需要多算一个 5。
     *
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            //先统计有多少个5
            //然后统计多少个25
            n /= 5;
            count += n;
        }
        return count;
    }

}

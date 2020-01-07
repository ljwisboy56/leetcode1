package com.example.letcodeeasy;

/**
 * @author yingru.ljw
 * @date 2019-11-24 23:31
 */
public class NumberOf1 {


    /**
     * 10011101
     * 00000001
     * 结题思想：
     * 把这个数依次右移（>>>）注意采用无符号右移，这样不会补位
     * 然后拿这个位来与1做'&'判断有多少个不是0的，
     * 或者说有多少个与完还是1的就可以了
     *
     */
    private static int NumberOf1_low(int n) {

        int num = 0;
        while(n != 0){
            if((n&1) == 1){
                num++;
            }
            n = n >>> 1;     //逻辑右移，无符号右移，左侧只用零填充
        }
        return num;
    }


    public static void main(String[] args) {
        NumberOf1_low(7);
    }
}

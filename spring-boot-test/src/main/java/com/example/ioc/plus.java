package com.example.ioc;

/**
 * @author yingru.ljw
 * @date 2019-12-31 11:39
 */
public class plus {

    public static void main(String[] args) {

        int a=2;

        int b=3;

        int t1 = a & b;

        int t2 = t1 << 1;

        int t3 = a^b;

        int t4 = t2^t3;

        System.out.println(t4);

        System.out.println(((a&b)<<1)^(a^b));


    }


}

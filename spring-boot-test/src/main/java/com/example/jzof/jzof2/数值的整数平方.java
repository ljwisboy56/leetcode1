package com.example.jzof.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-22 23:39
 */
public class 数值的整数平方 {


    /**
     * 0.1^2
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {

        if (exponent ==0){
            return 0;
        }
        double res = 1;

        for (int i = 0;i < Math.abs(exponent);i++){
            res = res * base;
        }

        if(exponent < 0){
            return 1/res;
        }

        return res;

    }
}

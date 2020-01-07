package com.example.letcodeeasy;

/**
 * @author yingru.ljw
 * @date 2019-11-25 00:25
 */
public class Power {


    public double Power(double base, int exponent) {
        double  result=1;
        for(int i=0;i<Math.abs(exponent);i++){
            result*=base;
        }
        if(exponent<0){
            result=1/result;
        }
        return result;
    }
}

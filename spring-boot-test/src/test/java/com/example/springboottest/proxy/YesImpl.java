package com.example.springboottest.proxy;

/**
 * @author lijiawen
 * @date 2019/2/15 上午10:38
 */
public class YesImpl implements Yes {

    @Override
    public void print() {
        System.out.println("yes");
    }
}

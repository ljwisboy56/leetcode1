package com.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lijiawen
 * @date 2019/3/16 下午7:07
 */
public class Rntfinancial {

    static ReentrantLock reentrantLock = new ReentrantLock();
    static Condition a = null;


    public static void main(String[] args) throws InterruptedException {
        a =  reentrantLock.newCondition();
        reentrantLock.lock();
        a.await();

        System.out.println(System.currentTimeMillis());

    }

}

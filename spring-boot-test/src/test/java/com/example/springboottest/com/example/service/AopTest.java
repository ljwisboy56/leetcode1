package com.example.springboottest.com.example.service;

import com.example.alibba.aop.ExceptionCatch;
import com.example.alibba.aop.MainfConfigAop;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lijiawen
 * @date 2019/1/26 下午2:47
 */
public class AopTest {


    @Test
    public void test(){

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainfConfigAop.class);
        ExceptionCatch e = annotationConfigApplicationContext.getBean(ExceptionCatch.class);
        e.DDD();

        try {
            ReentrantLock reentrantLock = new ReentrantLock();
            reentrantLock.tryLock(1, TimeUnit.SECONDS);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

    }

}

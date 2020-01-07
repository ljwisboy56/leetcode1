package com.example.springboottest.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lijiawen
 * @date 2019/2/15 上午10:34
 */
public class Myhandlder implements InvocationHandler {


    private Object target;

    public Myhandlder(Yes yes){

        this.target = yes;

    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("前方法");
        method.invoke(target,args);
        System.out.println("后增加");
        return null;

    }
}

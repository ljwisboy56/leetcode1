package com.example.springboottest.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author lijiawen
 * @date 2019/2/15 上午10:36
 */
public class ProxyTest {

    @Test
    public void test(){

        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = this.getClass().getClassLoader();

        //代理对象的类型，即其中有哪些方法
        Class[] interfaces = new Class[]{Yes.class};



        Yes yes = (Yes) Proxy.newProxyInstance(loader, interfaces, new Myhandlder(new YesImpl()));
        yes.print();


    }

}

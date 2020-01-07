package com.example.classloader;

/**
 * @author yingru.ljw
 * @date 2019-08-02 11:55
 */
public class Test {

    public static void main(String[] args) {
        ClassLoader a = Test.class.getClassLoader();
        ClassLoader b = Thread.currentThread().getContextClassLoader();
        ClassLoader c = ClassLoader.getSystemClassLoader();

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);



    }
}

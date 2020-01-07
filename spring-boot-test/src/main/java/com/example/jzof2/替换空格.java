package com.example.jzof2;

/**
 * @author yingru.ljw
 * @date 2019-12-22 17:33
 */
public class 替换空格 {

    public static void main(String[] args) {
        String res = new 替换空格().replaceSpace(new StringBuffer("we are happy"));
        System.out.println(res);

    }

    public String replaceSpace(StringBuffer str) {
        if(str == null){
            return null;
        }

        String abc = str.toString();
        String finalResult = abc.replace(" ","%20");
        return finalResult;
    }
}

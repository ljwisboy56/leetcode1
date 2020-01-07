package com.example.alibba;

/**
 * @author yingru.ljw
 * @date 2019-09-09 15:39
 */
public class TTTTT {

    public static void main(String[] args) {

        try{
            t1();
        }catch (Exception e){
            throw e;
        }


    }


    public static void t1(){
        throw new RuntimeException("i want you");
    }


    public void aa(){

        //场景1
        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b); //true

        //场景2
        Integer c = 128;
        Integer d = 128;
        System.out.println(a == b); //false


    }

}

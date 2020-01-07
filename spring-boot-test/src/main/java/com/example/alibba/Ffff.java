package com.example.alibba;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author yingru.ljw
 * @date 2019-09-03 15:05
 */
public class Ffff {

    public String getClassName(){
        return this.getClass().getSimpleName();
    }

    public static void pp(){

        List<String> list = new ArrayList<>();

        list.add("adc");


       for (String a : list){
           if(a.equals("adc")){
               continue;
           }

           System.out.println("ok");

       }

    }

    public static void main(String[] args) {
        pp();
    }
}

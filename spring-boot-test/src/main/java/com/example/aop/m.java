package com.example.aop;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author yingru.ljw
 * @date 2019-12-26 17:48
 */
public class m {


    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.entrySet().stream().parallel().forEach(new Consumer<Map.Entry<String, String>>() {
            @Override
            public void accept(Map.Entry<String, String> stringStringEntry) {
                doSth(stringStringEntry.getKey(),stringStringEntry.getValue());
            }
        });

    }

    private static void doSth(String key, String value){
        ;
    }
}

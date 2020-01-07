package com.example.aop;

import com.google.gson.Gson;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author lijiawen
 * @date 2019/1/26 下午2:49
 */

@Component
public class ExceptionCatch{

    @OutAdvice
    @ExceptionAnnotation
    public void DDD(){
        System.out.println("dddddddddddddd");
    }

}

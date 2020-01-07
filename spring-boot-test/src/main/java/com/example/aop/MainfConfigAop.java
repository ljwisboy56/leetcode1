package com.example.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.nio.channels.Channel;

/**
 * @author lijiawen
 * @date 2019/1/20 下午7:13
 */
@EnableAspectJAutoProxy
@Configuration
public class MainfConfigAop {

    public void div(int a ,int b){
        int v = a / b;
        System.out.println(v);
    }

    @Bean
    public ExceptionCatch exceptionCatch(){

//        Channel
        return new ExceptionCatch();
    }

    @Bean
    public AnnotatainonExceptinoAdvice annotatainonExceptinoAdvice(){
        return new AnnotatainonExceptinoAdvice();
    }

    @Bean
    public OutAnnotation outAnnotation(){
        return new OutAnnotation();
    }



}

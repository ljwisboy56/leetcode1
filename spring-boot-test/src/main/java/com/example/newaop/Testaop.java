package com.example.newaop;

import org.aspectj.lang.annotation.Around;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lijiawen
 * @date 2019/3/3 下午4:03
 */
@EnableAspectJAutoProxy
@Configuration
public class Testaop {

    @Bean
    public Mathcalcutor mathcalcutor(){
        return new Mathcalcutor();
    }

    @Bean
    public Want want(){
        return new Want();
    }


}

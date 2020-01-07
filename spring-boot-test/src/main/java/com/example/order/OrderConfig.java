package com.example.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author lijiawen
 * @date 2019/5/17 下午2:25
 */

@EnableAspectJAutoProxy
@Configuration
public class OrderConfig {

    @Bean
    public James james(){
        return new James();
    }

    @Bean
    public OutAdvice outAdvice(){
        return new OutAdvice();
    }

    @Bean
    public InAdvice inAdvice(){
        return new InAdvice();
    }

    @Bean
    public SwitchAdvice switchAdvice(){
        return new SwitchAdvice();
    }
}

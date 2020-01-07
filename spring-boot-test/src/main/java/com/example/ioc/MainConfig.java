package com.example.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lijiawen
 * @date 2019/1/19 下午2:56
 */
@Configuration
public class MainConfig {

    @Bean(initMethod = "init")
    public Car car(){
        return new Car();
    }

    @Bean
    public CarPostProcessor carPostProcessor(){
        return new CarPostProcessor();
    }

    @Bean(initMethod = "init")
    public Bike bike(){
        return new Bike();
    }

}

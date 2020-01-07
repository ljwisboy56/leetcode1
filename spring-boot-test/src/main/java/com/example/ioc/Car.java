package com.example.ioc;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import javax.annotation.PostConstruct;

/**
 * @author lijiawen
 * @date 2019/1/19 下午2:57
 */
public class Car implements InitializingBean{

    private int a = 0;


    public Car(){
        System.out.println("car construcor");

    }

    public void init(){
        System.out.println("====car init====");
    }

    @Override
    public void afterPropertiesSet() {

        System.out.println("======car InitializingBean=======");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("========car PostConstruct========");
    }


}

package com.example.ioc;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author lijiawen
 * @date 2019/1/19 下午3:42
 */
//@Component
public class CarPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName){
        System.out.println("====postProcessBeforeInitialization=========="+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName){
        System.out.println("====postProcessAfterInitialization=========="+beanName);
        return bean;
    }

}

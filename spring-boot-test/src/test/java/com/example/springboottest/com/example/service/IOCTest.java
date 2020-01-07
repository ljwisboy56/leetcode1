package com.example.springboottest.com.example.service;

import com.example.ioc.Car;
import com.example.ioc.MainConfig;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * @author lijiawen
 * @date 2019/1/19 下午2:52
 */
public class IOCTest {

        @Test
        public void test01(){
            ApplicationContext context = new XmlWebApplicationContext();
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
            Car car  = (Car) applicationContext.getBean("car");

            Environment a = applicationContext.getEnvironment();

            String aa = a.getProperty("systemProperties");
            System.out.println(aa);


        }

}

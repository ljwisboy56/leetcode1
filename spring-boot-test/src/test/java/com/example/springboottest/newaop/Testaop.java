package com.example.springboottest.newaop;

import com.example.newaop.Want;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lijiawen
 * @date 2019/3/3 下午4:04
 */


public class Testaop {

    @Test
    public void test(){

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(Testaop.class);

        Want e = (Want) annotationConfigApplicationContext.getBean(Want.class);
        e.iwant();

        annotationConfigApplicationContext.getBean(Want.class);


    }

}

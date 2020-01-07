package com.example.springboottest.aopordertest;

import com.example.newaop.Want;
import com.example.order.James;
import com.example.order.OrderConfig;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author lijiawen
 * @date 2019/3/3 下午4:04
 */


public class Testaop {

    @Test
    public void test(){

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(OrderConfig.class);

        James e = (James) annotationConfigApplicationContext.getBean(James.class);
        e.slumDunk(new James.Stdudent());



    }

}

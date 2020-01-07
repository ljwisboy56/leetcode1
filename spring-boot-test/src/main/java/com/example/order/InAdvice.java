package com.example.order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * @author lijiawen
 * @date 2019/5/17 下午2:29
 */

@Aspect
@Component
@Order(value = -90)
public class InAdvice{

    @Around("@annotation(com.example.order.In)")
    public Object doAroundLog(ProceedingJoinPoint pjp) throws Throwable {
        Object resultValue = null;
        try {
            System.out.println("In start");
            ts();
            resultValue = pjp.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            System.out.println("In end");
        }
        return resultValue;
    }

    public void ts(){
        throw new RuntimeException();
    }

}

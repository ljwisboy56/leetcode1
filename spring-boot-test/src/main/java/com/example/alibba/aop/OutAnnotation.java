package com.example.alibba.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author lijiawen
 * @date 2019/2/21 上午12:09
 */
@Aspect
@Component
public class OutAnnotation {

    @Around("@annotation(com.example.alibba.aop.OutAdvice)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("out out out");
        return point.proceed();
    }

}

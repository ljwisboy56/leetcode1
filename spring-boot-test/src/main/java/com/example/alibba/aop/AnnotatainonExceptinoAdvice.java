package com.example.alibba.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author lijiawen
 * @date 2019/2/16 下午8:20
 */
@Aspect
@Component
public class AnnotatainonExceptinoAdvice {

    @Around("@annotation(com.example.alibba.aop.ExceptionAnnotation)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        System.out.println("yes i am aop");
        return point.proceed();
    }

}

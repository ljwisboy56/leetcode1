package com.example.order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lijiawen
 * @date 2019/5/17 下午2:27
 */

@Aspect
@Component
//@Order(val = 89)
public class OutAdvice {

    @Around("@annotation(com.example.order.Out)")
    public Object doAroundLog(ProceedingJoinPoint pjp) throws Throwable {
        Object resultValue = null;
        try {
            System.out.println("out  start");

            resultValue = pjp.proceed();
        } catch (Throwable e) {
            throw e;
        } finally {
            System.out.println("out  end ");

        }
        return resultValue;
    }


}

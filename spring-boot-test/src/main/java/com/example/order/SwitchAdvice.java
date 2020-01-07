package com.example.order;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author yingru.ljw
 * @date 2019-09-02 21:40
 */

@Aspect
@Component
public class SwitchAdvice {

    @Around("@annotation(com.example.order.SwitchTest)&& @annotation(annotation)")
    public Object doAroundLog(ProceedingJoinPoint pjp,SwitchTest annotation) throws Throwable {

        if(annotation.tt().equals("a")){

            Class clazz =  pjp.getSignature().getDeclaringType();

            boolean res = KEBI.class.isAssignableFrom(clazz);
            System.out.println(res);

            String a = pjp.getArgs()[0].getClass().getSimpleName();
            System.out.println("a="+a);

            String name = getMethodName(pjp);
            System.out.println(name);
            System.out.println("asbc");

            System.out.println("运行时类名："+clazz.getSimpleName());


            Signature signature =  pjp.getSignature();
            Class returnType = ((MethodSignature) signature).getReturnType();
            String rname = returnType.getName();
            System.out.println(rname);

            return null;
        }else {
            return pjp.proceed();
        }

    }


    /**
     * 获取全类名
     */
    private String getMethodName(ProceedingJoinPoint point) {
        return String.format("%s.%s", point.getSignature().getDeclaringType().getSimpleName(), point.getSignature().getName());
    }

    /**
     * 获取返回值类型
     * @param point
     * @return 1:返回值为整数 2：返回值为boolean 3:返回值为void 4:为obj
     */
    private int getReturnType(ProceedingJoinPoint point){
        Signature signature =  point.getSignature();
        Class returnType = ((MethodSignature) signature).getReturnType();
        String rname = returnType.getName();
        if("java.lang.Integer".equals(rname) || "int".equals(rname)){
            return 1;
        }
        if("java.lang.Boolean".equals(rname)|| "boolean".equals(rname)){
            return 2;
        }
        if("void".equals(rname)){
            return 3;
        }
        return 0;

    }
}

package com.forgeeks.SpringDZ5.core.utils;

import com.forgeeks.SpringDZ5.core.service.ProductService;
import lombok.Data;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Data
//@RestController
//@RequestMapping("api/v1/statistic")
public class AspectApp {
    private String worktimeData;
    private long ultimateTime;
    private long productServTime;


//    @Pointcut("within(com.forgeeks.SpringDZ5.core.service.*)")
//    public void serviceClassMethods(){};

//    @Around("within(com.forgeeks.SpringDZ5.core.service.*)")
//    @Around("execution(* com.forgeeks.SpringDZ5.core.service.*.*(..))")
////    @Around("serviceClassMethods()")
//    public Object countServicesWorktime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        System.out.println("start counting worktime of method: " + (MethodSignature) proceedingJoinPoint.getSignature());
//        long begin = System.currentTimeMillis();
//        Object out = proceedingJoinPoint.proceed();
//        long end = System.currentTimeMillis();
//        long worktime = end - begin;
//        worktimeData = (MethodSignature) proceedingJoinPoint.getSignature() + " worktime " + worktime;
//        System.out.println(worktimeData);
//        System.out.println("end counting worktime of method: " + (MethodSignature) proceedingJoinPoint.getSignature());
////        System.out.println(out.getClass());
//        ultimateTime = ultimateTime + worktime;
//        return out;
//    }

    @Around("execution(* com.forgeeks.SpringDZ5.core.service.*.*(..))")
    public Object countServicesWorktime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//        System.out.println("start counting worktime of method: " + (MethodSignature) proceedingJoinPoint.getSignature());
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long worktime = end - begin;
        worktimeData = (MethodSignature) proceedingJoinPoint.getSignature() + " worktime " + worktime;
        if (proceedingJoinPoint.getThis() instanceof ProductService){
//            System.out.println("YEAP!Cart!");
            productServTime = productServTime + worktime;
        }
//        System.out.println(worktimeData);
//        System.out.println("end counting worktime of method: " + (MethodSignature) proceedingJoinPoint.getSignature());
        ultimateTime = ultimateTime + worktime;
//        System.out.println(proceedingJoinPoint.getKind());
//        System.out.println(proceedingJoinPoint.getTarget());
//        System.out.println(proceedingJoinPoint.getThis());
//        System.out.println(proceedingJoinPoint.getStaticPart());
//        System.out.println(proceedingJoinPoint.getSourceLocation());
        return out;
    }
}

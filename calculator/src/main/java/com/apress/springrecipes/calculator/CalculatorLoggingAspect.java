package com.apress.springrecipes.calculator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CalculatorLoggingAspect {

    private final Log log = LogFactory.getLog(this.getClass());

    @Before("execution(* *.*(..))")
    public void logJointPoint(JoinPoint joinPoint) {
        log.info("Join point kind : " + joinPoint.getKind());
        log.info("Signature declaring type : " + joinPoint.getSignature().getDeclaringTypeName());
        log.info("Signature name : " + joinPoint.getSignature().getName());
        log.info("Arguments : " + Arrays.toString(joinPoint.getArgs()));
        log.info("Target class : " + joinPoint.getTarget().getClass().getName());
        log.info("This class : " + joinPoint.getThis().getClass().getName());
    }

//    @Around("execution(* *.*(..))")
//    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("The method " + joinPoint.getSignature().getName() +
//                "() begins with " + Arrays.toString(joinPoint.getArgs()));
//
//        try {
//            Object result = joinPoint.proceed();
//            log.info("Ter method " + joinPoint.getSignature().getName() +
//                "() ends with " + result);
//            return result;
//        } catch (IllegalArgumentException e) {
//            log.error("An exception " + e + " has been thrown in " + joinPoint.getSignature().getName() + "()");
//            throw e;
//        }
//    }
}

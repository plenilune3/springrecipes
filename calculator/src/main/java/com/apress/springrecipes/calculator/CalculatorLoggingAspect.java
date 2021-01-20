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

    @Around("execution(* *.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("The method " + joinPoint.getSignature().getName() +
                "() begins with " + Arrays.toString(joinPoint.getArgs()));

        try {
            Object result = joinPoint.proceed();
            log.info("Ter method " + joinPoint.getSignature().getName() +
                "() ends with " + result);
            return result;
        } catch (IllegalArgumentException e) {
            log.error("An exception " + e + " has been thrown in " + joinPoint.getSignature().getName() + "()");
            throw e;
        }
    }

//    @Before("execution(* ArithmeticCalculator.add(..))")
//    public void logBefore() {
//        log.info("The method add() begins");
//    }

//    @Before("execution(* *.*(..))")
//    public void logBefore(JoinPoint joinPoint) {
//        log.info("The method " + joinPoint.getSignature().getName() +
//                "() begins with " + Arrays.toString(joinPoint.getArgs()));
//
//    }
//
//    @After("execution(* *.*(..))")
//    public void logAfter(JoinPoint joinPoint) {
//        log.info("The method " + joinPoint.getSignature().getName() +
//                "() ends");
//    }
//
//    @AfterReturning(
//            pointcut = "execution(* *.*(..))",
//            returning = "result")
//    public void logAfterReturning(JoinPoint joinPoint, Object result) {
//        log.info("Ter method " + joinPoint.getSignature().getName() +
//                "() ends with " + result);
//    }
//
//    @AfterThrowing(
//            pointcut = "execution(* *.*(..))",
//            throwing = "e"
//    )
//    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
//        log.error("An exception " + e + " has been thrown in " + joinPoint.getSignature().getName() + "()");
//    }
}

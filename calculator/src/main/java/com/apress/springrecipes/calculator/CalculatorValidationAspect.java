package com.apress.springrecipes.calculator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(0)
public class CalculatorValidationAspect {

    private final Log log = LogFactory.getLog(this.getClass());

    @Before("execution(* *.*(double, double))")
    public void validationBefore(JoinPoint joinPoint) {
        for (Object arg : joinPoint.getArgs()) {

            try {
                validate((Double) arg);
            } catch(IllegalArgumentException e) {
                log.error("Illegal argument " + Arrays.toString(joinPoint.getArgs()) + " in " +
                        joinPoint.getSignature().getName() + "() : " + e.getMessage());
                throw e;
            }
        }
    }

    private void validate(Double arg) {
        if (arg < 0) {
            throw new IllegalArgumentException("Positive numbers only");
        }
    }
}

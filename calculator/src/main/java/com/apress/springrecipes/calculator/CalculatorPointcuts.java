package com.apress.springrecipes.calculator;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CalculatorPointcuts {

    @Pointcut("within(UnitCalculator+)")
    public void unitOperation() {}

    @Pointcut("within(ArithmeticCalculator+)")
    public void arithmeticOperation() {}

//    @Pointcut("unitOperation() || arithmeticOperation()")
    @Pointcut("@within(LoggingRequired) || unitOperation() || arithmeticOperation()")
    public void loggingOperation() {}

}

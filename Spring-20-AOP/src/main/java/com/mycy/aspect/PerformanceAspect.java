package com.mycy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceAspect {
    Logger logger = LoggerFactory.getLogger(PerformanceAspect.class);

    @Pointcut("@annotation(com.mycy.annotation.ExecutionTime)")
    private void anyExecutionTimeOperation(){}

    @Around("anyExecutionTimeOperation()")
    public Object anyExecutionTimeOperationAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        long timeBeforeExecution = System.currentTimeMillis();
        Object result;
        logger.info("Execution starts");
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        //define after log
        long timeAfterExecution = System.currentTimeMillis();
        logger.info("Execution time taken: {} ms - Method: {} - Parameters: {}",
                (timeAfterExecution-timeBeforeExecution),
                proceedingJoinPoint.getSignature().toShortString(),
                proceedingJoinPoint.getArgs());
        return result;
    }
}

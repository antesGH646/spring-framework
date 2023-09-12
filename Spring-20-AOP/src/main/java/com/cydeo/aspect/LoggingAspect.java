package com.cydeo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Instead of writing the logs inside the controllers, etc. Aspect class is used
 * to write the logs and control them
 */
@Aspect//Telling Spring that this is an aspect programming, Spring will return proxy objects
@Configuration//Telling Spring that this is a configuration class, Spring will create proxies of the methods
public class LoggingAspect {

    //creating a Logger object for LoggingAspect class
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    //Requesting to monitor what is happening on CourseController, passing the path of the target object
    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")
    private void pointcut(){}

    //creating an advice and passing the associated point cut method name
    @Before("pointcut()")
    public void log(){
        logger.info("Logger info ------");
    }

    //you may combine the point cut and the advice methods
    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
    public void beforeAdvice(){
        logger.info("Logger info ------");
    }

    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")
    private void anyProductRepositoryFindById(){}

    //executing with @Before advice
    @Before("anyProductRepositoryFindById()")
    public void beforeCourseRepoOperation(JoinPoint joinPoint){
        logger.info("Before (findById) : -> Method: {} - Arguments: {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    //@within is used to match classes with in certain types e.g. classes within a sub-package (.*)
    @Pointcut("within(com.cydeo.controller..*)")
    private void anyControllerOperation(){}

    //monitoring any of the above imports e.g. the Service (org.springframework.stereotype.Service)
    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceOperation(){
    }

    //combining two pointcuts using logical operator
    @Before("anyControllerOperation() || anyServiceOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint){
        logger.info("Before () -> Method : {} - Arguments : {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    /**
     * Both annotations are used to match Join Points
     * The @annotation is used at method level, but @within is used on the class level.
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void anyDeleteCourseOperation(){}

    @Before("anyDeleteCourseOperation()")
    public void beforeControllerAdvice2(JoinPoint joinPoint){
        logger.info("Before -> Method : {} - Arguments : {} - Target: {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    /**
     * Point cut with @annotation method associated with @AfterReturning advice
     * AfterReturning accepts two params the target object and the returning object
     * So define the parameters in the AfterReturning method
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetCourseOperation(){}

    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, Object result){
        logger.info("After returning -> Method: {} - result: {}", joinPoint.getSignature().toShortString(),result.toString());
    }

    @AfterReturning(pointcut = "anyGetCourseOperation()", returning = "result")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, List<Object> result){
        logger.info("After returning(List) -> Method: {} - result: {}", joinPoint.getSignature().toShortString(),result.toString());
    }

    @AfterThrowing(pointcut = "anyGetCourseOperation()", throwing = "exception")
    public void afterThrowingControllerAdvice(JoinPoint joinPoint, RuntimeException exception){
        logger.info("After Throwing -> Method: {} - Exception: {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }

    @After("anyGetCourseOperation()")
    public void afterControllerAdvice(JoinPoint joinPoint) {
        logger.info("After finally -> Method : {}", joinPoint.getSignature().toShortString());
    }

    /**
     * The Around contains executed Before or After methods.
     * The Around method has the ProceedingJointPoint type to
     * call the proceeding() method.
     * The proceeding() method causes the underlying method to execute
     * It is good the Around advice to return a value from the device method
     * as the matched JoinPoint might have a return type
     */

    @Pointcut("@annotation(com.cydeo.annotation.Loggable)")
    private void anyLoggableMethodOperation(){}

    @Around("anyLoggableMethodOperation()")
    public Object anyLoggableMethodOperationAdvice(ProceedingJoinPoint proceedingJoinPoint){
        logger.info("Before () -> Method : {} - Parameters: {}", proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());
        Object results = null;
        try {
            results =proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        logger.info("After -> Method: {} - Results: {}", proceedingJoinPoint.getSignature().toShortString(),results.toString());
        return results;
    }
}
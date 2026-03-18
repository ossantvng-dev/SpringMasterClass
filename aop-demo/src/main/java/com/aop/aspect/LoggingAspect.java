package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /*
        Before ANY method in ANY class inside com.aop.service (and its subpackages) is executed,
        run this advice.

        - execution(* com.aop..*(..)) → this is the pointcut
        - logMethodCall(JoinPoint) → this is the advice method, not a pointcut

     */
    @Before("com.aop.aspect.CommonPointCutConfig.servicePackageConfig()") // when
    public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
        logger.info("Before Aspect {} method is called with following args: {}", joinPoint, joinPoint.getArgs()); // what
    }

    @After("execution(* com.aop.service..*(..))")
    public void logMethodCallAfterExecutionV2(JoinPoint joinPoint) {
        logger.info("After Aspect {} has executed", joinPoint);
    }

    @AfterThrowing(pointcut = "execution(* com.aop.service..*(..))", throwing = "exception")
    public void logMethodCallAfterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("AfterThrowing Aspect {} has executed with exception {}", joinPoint, exception.getMessage());
    }

    @AfterReturning(pointcut = "execution(* com.aop.service..*(..))", returning = "resultValue")
    public void logMethodCallAfterReturning(JoinPoint joinPoint, Object resultValue) {
        logger.info("AfterReturning Aspect {} has executed returning {}", joinPoint, resultValue);
    }

    /*
        A simple analogy:

            Pointcut = “All methods in com.aop.repository”
            Pointcut method = A bookmark with that name
            Advice = “Whenever a method from that group runs, log something”

            The pointcut method is never executed.
            The advice method is executed every time the pointcut matches.

    @Pointcut("execution(* com.aop.repository..*(..))")
    public void repositoryMethods() {}


    @After("repositoryMethods()")
    public void logMethodCallAfterExecution(JoinPoint joinPoint) {
        logger.info("After Aspect {} method is called", joinPoint);
    } */

}

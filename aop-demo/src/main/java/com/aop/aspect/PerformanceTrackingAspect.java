package com.aop.aspect;

import com.aop.annotation.TrackTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceTrackingAspect {

    private final Logger logger = LoggerFactory.getLogger(PerformanceTrackingAspect.class);

    @Around("execution(* com.aop..*(..))")
    public Object findExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(); // execute the method
        long end = System.currentTimeMillis();
        long duration = end - start;
        logger.info("Around Aspect - Execution time of {} :: {} ms", joinPoint.getSignature(), duration);
        return result;
    }

    @Around("@annotation(trackTime)")
    public Object findExecutionTime(ProceedingJoinPoint joinPoint, TrackTime trackTime) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - start;
        logger.info("`Annotation` - Execution time of {} :: {} ms", joinPoint.getSignature(), duration);
        return result;
    }

}

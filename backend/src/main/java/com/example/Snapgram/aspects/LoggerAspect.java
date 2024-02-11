package com.example.Snapgram.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Around("execution(* com.example.Snapgram.controllers.*.*(..))")
    public Object logBeforeMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable{
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        logger.info("Calling method " + methodName + " in class " + className);

        Object result = joinPoint.proceed();

        logger.info("Exiting method " + methodName + " in class " + className);
        return result;
    }
}

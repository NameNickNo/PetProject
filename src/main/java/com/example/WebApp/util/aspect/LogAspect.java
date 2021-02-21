package com.example.WebApp.util.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogAspect {

    @Around("execution(* com.example.WebApp.service.*.*(..))")
    public Object aroundServiceMethodExecution(ProceedingJoinPoint point) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = point.proceed();
        long end = System.currentTimeMillis();
        log.info("Execution time of method {} : {} msec", point.getSignature(), end - start);
        return proceed;
    }
}

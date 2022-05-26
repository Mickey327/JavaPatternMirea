package ru.mirea.task15;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class AspectExample {
    @Around("execution(public * ru.mirea.task15.Market.MarketService.*(..))")
    public Object adviseListLock(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long estimatedTime = System.currentTimeMillis() - startTime;
        log.info("Method was running for " + estimatedTime + "ms");
        return result;
    }
}

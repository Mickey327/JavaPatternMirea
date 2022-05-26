package ru.mirea.task3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Scope("singleton")
@Component
@Aspect
public class AspectClass {
    private Semaphore semaphore = new Semaphore(1);
    private Lock lock = new ReentrantLock();

    @Around("execution(public * java.util.List.*(..))")
    public Object adviseListLock(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        lock.lock();
        System.out.println("Монитор захвачен");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("Монитор будет освобожден через 1 секунд");
        Thread.sleep(1000);
        lock.unlock();
        return result;
    }
    @Around("execution(public * java.util.Set.*(..))")
    public Object adviseSetSemaphore(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        semaphore.acquire();
        System.out.println("Монитор захвачен");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("Монитор будет освобожден через 1 секунд");
        Thread.sleep(1000);
        semaphore.release();
        return result;
    }
}

package ru.otus.spring.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {

//    @Before("execution(* ru.otus.spring.dao.PersonDaoSimple.findByName(String))")
//    public void logBefore(JoinPoint joinPoint) {
//        System.out.println("Прокси : " + joinPoint.getThis().getClass().getName());
//        System.out.println("Класс : " + joinPoint.getTarget().getClass().getName());
//
//        System.out.println("Вызов метода : " + joinPoint.getSignature().getName());
//    }

    @Around("execution(* ru.otus.spring.dao.PersonDaoSimple.*(..))")
    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Прокси : " + joinPoint.getThis().getClass().getName());
        System.out.println("Класс : " + joinPoint.getTarget().getClass().getName());

        System.out.println("Вызов метода before around: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: " + Arrays.toString(joinPoint.getArgs()));

        var res = joinPoint.proceed();
        System.out.println("Result call method: " + res);
//        return res;
    }
}

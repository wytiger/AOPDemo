package com.wytiger.aopdemo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * description ：
 * author : wuyong_cd
 * date : 2019/10/9 0009 14:44
 */
@Aspect
public class ClickAspect {

    @Pointcut("execution(void com.wytiger.aopdemo.MainActivity.testClick(android.view.View))")
    public void clickPointCut() {

    }

    @Before("clickPointCut()")
    public void before(ProceedingJoinPoint joinPoint) {
        System.out.println("@Before");
    }

    @Around("clickPointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("do something 1");
        joinPoint.proceed();
        System.out.println("do something 2");
    }

    @After("clickPointCut()")
    public void after(JoinPoint point) {
        System.out.println("@After");
    }

    @AfterReturning("clickPointCut()")
    public void afterReturning(JoinPoint point, Object returnValue) {
        System.out.println("@AfterReturning");
    }

    @AfterThrowing(value = "clickPointCut()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("@afterThrowing");
        System.out.println("ex = " + ex.getMessage());
    }


}

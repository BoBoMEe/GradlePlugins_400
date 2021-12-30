package com.bobomee.aop_runtime.aspectj;

import com.bobomee.aop_annotation.Check;
import com.bobomee.aop_runtime.CheckerHolder;
import com.bobomee.aop_runtime.checker.Checker;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class CheckAspectj {
    private static final String TAG = "CheckAspectj";
    private static final String ANNOTATION = "com.bobomee.aop_annotation.Check";

    @Pointcut("within(@" + ANNOTATION + " *)")
    public void withinAnnotatedClass() {
    }

    @Pointcut("execution(!synthetic * *(..)) && withinAnnotatedClass()")
    public void methodInsideAnnotatedType() {
    }

    @Pointcut("execution(!synthetic *.new(..)) && withinAnnotatedClass()")
    public void constructorInsideAnnotatedType() {
    }

    @Pointcut("execution(@" + ANNOTATION + " * *(..)) || methodInsideAnnotatedType()")
    public void method() {
    }

    @Pointcut("execution(@" + ANNOTATION + " *.new(..)) || constructorInsideAnnotatedType()")
    public void constructor() {
    }

    @Around("(method() || constructor()) && @annotation(check)")
    public Object aroundJoinPoint(ProceedingJoinPoint joinPoint, Check check) throws Throwable {
        Object[] args = joinPoint.getArgs();
        boolean result = check(check.value(), joinPoint);
        return result ? null : joinPoint.proceed(args);
    }

    private boolean check(String[] value, ProceedingJoinPoint joinPoint) {
        Checker checker = CheckerHolder.getChecker();
        if (null == checker)return false;
        else return checker.check(value, joinPoint);
    }
}

package com.bobomee.aop_runtime.checker;

import org.aspectj.lang.JoinPoint;

public interface Checker {
    boolean check(String[] value, JoinPoint joinPoint);
}

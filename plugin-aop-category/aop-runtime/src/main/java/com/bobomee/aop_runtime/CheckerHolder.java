package com.bobomee.aop_runtime;

import com.bobomee.aop_runtime.checker.Checker;

public final class CheckerHolder {
    private static Checker sChecker;

    public static void setChecker(Checker checker) {
        sChecker = checker;
    }

    public static Checker getChecker() {
        return sChecker;
    }
}

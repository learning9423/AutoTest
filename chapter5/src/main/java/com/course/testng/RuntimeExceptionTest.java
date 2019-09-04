package com.course.testng;

import org.testng.annotations.Test;

public class RuntimeExceptionTest {
    @Test(expectedExceptions = ArithmeticException.class)
    public void runtimeExceptionTest(){
        System.out.println("这是一个异常测试");
        throw new ArithmeticException();
    }
}

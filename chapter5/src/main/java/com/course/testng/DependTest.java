package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void group1() {
        System.out.println("GroupOnClass1开始运行");
        throw new ArithmeticException();
    }
    @Test(dependsOnMethods = {"group1"})
    public void group2() {
        System.out.println("GroupOnClass2开始运行");
    }
}

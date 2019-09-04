package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThread1 {
    @Test(threadPoolSize = 3,invocationCount = 10)
    public void test1(){
        System.out.println("线程ID："+Thread.currentThread().getId());
        System.out.println("线程1");
    }
}

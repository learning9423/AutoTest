package com.course.testng.multiThread;

import org.testng.annotations.Test;

public class MultiThread2 {
    @Test
    public void test1(){
        System.out.println("线程ID："+Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.println("线程ID："+Thread.currentThread().getId());
    }
    @Test
    public void test3(){
        System.out.println("线程ID："+Thread.currentThread().getId());
    }
    @Test
    public void test4(){
        System.out.println("线程ID："+Thread.currentThread().getId());
    }
}

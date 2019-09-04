package com.course.testng;

import org.testng.annotations.Test;

public class TimeOut {
    @Test(timeOut = 2000)
    public void test1(){
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("超时测试");
        }

    }
}

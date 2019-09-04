package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "group1")
public class GroupOnClass1 {
    public void group1(){
        System.out.println("GroupOnClass1开始运行");
    }
}

package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "group3")
public class GroupOnClass3 {
    public void group3(){
        System.out.println("GroupOnClass3开始运行");
    }
}

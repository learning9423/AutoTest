package com.course.testng.group;

import org.testng.annotations.Test;

@Test(groups = "group2")
public class GroupOnClass2 {
    public void group2(){
        System.out.println("GroupOnClass2开始运行");
    }
}

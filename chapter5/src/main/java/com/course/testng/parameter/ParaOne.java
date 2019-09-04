package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParaOne {
    @Test
    @Parameters({"name","age"})
    public void group2(String name,int age ){
        System.out.println("姓名："+name+","+"年龄："+age);
    }
}

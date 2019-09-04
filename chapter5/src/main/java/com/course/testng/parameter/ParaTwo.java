package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParaTwo {

    @Test(dataProvider = "data1")
    public void group2(String name,int age ){
        System.out.println("姓名："+name+","+"年龄："+age);
    }
    @DataProvider(name = "data1")
    public Object[][] object(){
        Object[][] obj = new Object[][]
                {
                        {"张昭",20},{"樊俊彦",300}
                };

        return obj;
    }
}
package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class ParaThree {
    @Test(dataProvider = "data1")
    public void group2(String name,int age ){
        System.out.println("姓名："+name+","+"年龄："+age);
    }
    @Test(dataProvider = "data1")
    public void group1(String name,int age){
        System.out.println("姓名："+name+","+"年龄："+age);
    }
    @DataProvider(name = "data1")
    public Object[][] object(Method method){
        Object[][] obj = null;
        if(method.getName().equals("group1")){
         obj=new Object[][]{
                 {"zhangsan",30},{"lisi",50}
         };
        }else if (method.getName().equals("group2")){
            obj=new Object[][]{
                    {"樊俊彦",30},{"张永超",50}
            };
        }
        return obj;
    }
}

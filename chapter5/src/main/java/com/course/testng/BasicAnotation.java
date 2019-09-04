package com.course.testng;

import org.testng.annotations.*;

public class BasicAnotation {
    @Test
    public void testCase() {
        System.out.println("这个一个testng用例测试");
    }
    @Test(enabled = false)
    public void testCase2(){
       System.out.println("这是测试用例2");
    }

    @BeforeMethod
    public void beforeMethod(){
       System.out.println("这是测试用例前运行的方法");
        }
    @AfterMethod
    public void afterMethod(){
       System.out.println("这是测试用例之后运行的方法");
        }
     @BeforeClass
    public void beforeClass(){
        System.out.println("这是类运行之前运行的方法");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("这是类运行之后运行的方法");
    }
    @BeforeSuite
    public void beforeSiute(){
        System.out.println("beforesiute测试套件");
    }
    @AfterSuite
    public void afterSiuter(){
        System.out.println("aftersiute测式套件");
    }
    }


package com.course.testng.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
    @Test(groups = "server")
    public void testServer1() {
        System.out.println("这是服务端组测试用例1");
    }
    @Test(groups ="server" )
    public void testServer2(){
        System.out.println("这是服务端测试用例2");
    }
    @Test(groups = "client")
    public void testClient1() {
        System.out.println("这是客户端组测试用例1");
    }
    @Test(groups = "client")
    public void testClient2(){
        System.out.println("这是客户端组测试用例2");
    }
    @BeforeGroups("server")
    public void beforeGroupOnMethod() {
        System.out.println("服务端组测试用例前执行");
    }
    @AfterGroups("server")
    public void afterGroupOnMethod(){
        System.out.println("服务端组测试用例执行后");
    }
}

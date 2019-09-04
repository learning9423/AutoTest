package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class PostRequest {
    String url;
    private ResourceBundle bundle;
    private CookieStore store;//SetCookies方法需要getcookies的cookie
    @BeforeTest                //所以设置为类方法
    public void getUrl(){
        bundle=ResourceBundle.getBundle("application");
        url=bundle.getString("test.url");
    }
    @Test
    public void  getCookies() throws IOException {
        String result;
        String geturl;
        String methodurl=bundle.getString("getcookies.uri");
        geturl=url+methodurl;

        HttpGet get=new HttpGet(geturl);
        DefaultHttpClient client =new DefaultHttpClient();
        HttpResponse response= client.execute(get);

        result = EntityUtils.toString(response.getEntity(),"UTF-8");
        System.out.println(result);
//        获取cookies
        store=client.getCookieStore();
        List<Cookie> list=store.getCookies();
        for (Cookie cookie:list
        ) {
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("name:"+name+";value:"+value);
        }

    }
    @Test(dependsOnMethods = "getCookies")
    public  void setPostRequest() throws IOException {
//        声明结果变量
        String result;
//        拼接URL
        String geturl;
        String methodurl=bundle.getString("post.uri");
        geturl=this.url+methodurl;
//        声明一个defaulthttpclient方法
        DefaultHttpClient client=new DefaultHttpClient();
//        声明httppost方法
        HttpPost post=new HttpPost(geturl);
//        设置参数
        JSONObject para=new JSONObject();
        para.put("name","张昭");
        para.put("age","18");
//        设置cookie
        client.setCookieStore(this.store);
//        设置头信息
        post.setHeader("content-type","application/json");
//        声明实体对象，装载json数据
        StringEntity entity=new StringEntity(para.toString(),"UTF-8");
        post.setEntity(entity);
//        执行post请求
        HttpResponse response=client.execute(post);
//        解析json实体响应
        result=EntityUtils.toString(response.getEntity(),"UTF-8");
        JSONObject json1=new JSONObject(result);
           String name1= (String) json1.get("name");
           String age1= (String) json1.get("age");
//       判断返回值是否与期望值一样
//        Assert.assertEquals("张昭","name1");
//        Assert.assertEquals("18","age1");
//        输出结果
        System.out.println(name1);
        System.out.println(age1);
        System.out.println(result);
//        store= client.getCookieStore();
//        List<Cookie> list=store.getCookies();
//        for (Cookie cookie:list
//        ) {
//            String name=cookie.getName();
//            String value=cookie.getValue();
//            System.out.println("name:"+name+";value:"+value);
//        }
    }



}

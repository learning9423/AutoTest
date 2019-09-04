package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class BundelCookies {
//  因为每个方法请求的方法名不一样，所以需要将URL单独拿出来
//    在每个方法里进行拼接。
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

        result = EntityUtils.toString(response.getEntity());
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
    public void setCookies() throws IOException {
        String result;
        String geturl;
        String methodurl=bundle.getString("setcookies.uri");
        geturl=url+methodurl;
        HttpGet get=new HttpGet(geturl);
        DefaultHttpClient client=new DefaultHttpClient();
        client.setCookieStore(store);
        HttpResponse response=client.execute(get);
        int statuscode= response.getStatusLine().getStatusCode();
        System.out.println(statuscode);
        if (statuscode==200){
            result=EntityUtils.toString(response.getEntity());
            System.out.println(result);
            store=client.getCookieStore();
            List<Cookie> list=store.getCookies();
            for (Cookie cook:list
                 ) {
                String name=cook.getName();
                String value=cook.getValue();
                System.out.println("带cookie信息请求的返回cookie字段："+name+";值："+value);
            }
        }

    }
}

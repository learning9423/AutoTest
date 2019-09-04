package com.course.httpclient;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;


public class HttpHeader {
    @Test
    public void getheader() throws IOException, ParseException {
        HttpGet get=new HttpGet(URI.create("http://www.baidu.com"));
        HttpClient client=new DefaultHttpClient();

        HttpResponse response= client.execute(get);
        String result = EntityUtils.toString(response.getEntity());

        System.out.println(result);


    }
}

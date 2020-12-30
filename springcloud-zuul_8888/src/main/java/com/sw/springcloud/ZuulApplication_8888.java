package com.sw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @Author suaxi
 * @Date 2020/12/30 10:50
 */

@SpringBootApplication
@EnableZuulProxy //开启Zuul路由网关
public class ZuulApplication_8888 {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication_8888.class,args);
        //http://www.suaxi.com:8888/springcloud-provider-dept/dept/get/1
    }
}

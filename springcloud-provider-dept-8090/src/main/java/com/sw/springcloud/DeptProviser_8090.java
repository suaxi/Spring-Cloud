package com.sw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author suaxi
 * @Date 2020/12/28 21:49
 */

@SpringBootApplication
@EnableEurekaClient //服务启动后自动注册到Eureka中
@EnableDiscoveryClient //开启服务发现
public class DeptProviser_8090 {
    public static void main(String[] args) {
        SpringApplication.run(DeptProviser_8090.class,args);
    }
}

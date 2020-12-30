package com.sw.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author suaxi
 * @Date 2020/12/29 11:02
 */

@SpringBootApplication
@EnableEurekaServer //服务端
public class EurekaConfigServer_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConfigServer_7001.class,args);
    }
}

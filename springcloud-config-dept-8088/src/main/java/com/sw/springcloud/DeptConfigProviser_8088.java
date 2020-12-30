package com.sw.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author suaxi
 * @Date 2020/12/28 21:49
 */

@SpringBootApplication
@EnableEurekaClient //服务启动后自动注册到Eureka中
@EnableDiscoveryClient //开启服务发现
public class DeptConfigProviser_8088 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConfigProviser_8088.class,args);
    }

    //注册监控信息
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }
}

package com.sw.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author suaxi
 * @Date 2020/12/28 22:15
 */

@Configuration
public class ConfigBean {

    //配置负载均衡实现RestTemplate
    //IRule
    //RoundRobinRule 轮询
    //RandomRule 随机数
    //AvailabilityFilteringRule 先过滤不可用的服务，对剩下的进行轮询
    //RetryRule 先按照轮询获取服务，如果获取服务失败，则会在指定的时间内进行重试
    @Bean
    @LoadBalanced //注册Ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

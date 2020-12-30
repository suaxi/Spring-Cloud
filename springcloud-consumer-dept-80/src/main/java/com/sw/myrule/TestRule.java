package com.sw.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author suaxi
 * @Date 2020/12/29 16:12
 */

@Configuration
public class TestRule {

    @Bean
    public IRule myRule(){
        return new MyRandomRule();
    }
}

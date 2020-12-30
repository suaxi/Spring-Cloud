package com.sw.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sw.springcloud.pojo.Dept;
import com.sw.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author suaxi
 * @Date 2020/12/28 21:44
 * 提供RestFul服务
 */

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id")Long id){
        Dept dept = deptService.findDept(id);
        if (dept==null){
            throw new RuntimeException("不存在id为"+id+"的用户，或者信息无法找到");
        }
        return dept;
    }

    //熔断后的备选方法
    public Dept hystrixGet(@PathVariable("id")Long id){
        Dept dept = deptService.findDept(id);
        return new Dept()
                .setDeptno(id)
                .setDname("不存在id为"+id+"的用户，或者信息无法找到,null-->@Hystrix")
                .setDb_source("No message in MySQL");
    }
}

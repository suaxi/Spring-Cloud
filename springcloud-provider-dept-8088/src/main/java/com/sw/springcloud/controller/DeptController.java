package com.sw.springcloud.controller;

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

    //获取配置信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept){
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id")Long id){
        Dept dept = deptService.findDept(id);
        if (dept==null){
            throw new RuntimeException("查询失败");
        }
        return dept;
    }

    @GetMapping("/dept/list")
    public List<Dept> findAll(){
        return deptService.findAll();
    }

    //获取注册进来的微服务的信息
    @GetMapping("/dept/discovery")
    public Object discovery(){
        //获取微服务列表清单
        List<String> services = client.getServices();
        System.out.println("discovery==>services:"+services);

        //通过微服务id得到具体的信息
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost()+"\t"+
                    instance.getPort()+"\t"+
                    instance.getUri()+"\t"+
                    instance.getServiceId()+"\t"
            );
        }
        return this.client;
    }
}

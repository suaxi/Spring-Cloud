package com.sw.springcloud.controller;

import com.sw.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author suaxi
 * @Date 2020/12/28 22:16
 */

@RestController
public class DeptConsumerController {

    //将RestTemplate注册到spring中，再直接调用
    //(url,实体：Map，Class<T> responseType)

    @Autowired
    private RestTemplate restTemplate; //提供多种便捷访问远程http服务的方法，简单的RestFul服务模板

    //private static final String REST_URL_PREFIX = "http://localhost:8088";
    //启用Ribbon时，访问的url是一个变量（服务者ID），不再是单一的地址
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping(value = "/consumer/dept/add",produces = {"application/json;charset=UTF-8"})
    public boolean add(Dept dept){
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add",dept,Boolean.class);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",produces = {"application/json;charset=UTF-8"})
    public Dept get(@PathVariable("id")Long id){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id,Dept.class);
    }

    @RequestMapping(value = "/consumer/dept/list",produces = {"application/json;charset=UTF-8"})
    public List<Dept> list(){
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list",List.class);
    }
}

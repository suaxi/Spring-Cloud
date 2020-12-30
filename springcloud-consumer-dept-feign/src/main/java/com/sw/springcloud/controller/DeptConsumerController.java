package com.sw.springcloud.controller;

import com.sw.springcloud.pojo.Dept;
import com.sw.springcloud.service.DeptClientService;
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

    @Autowired
    private DeptClientService client;

    @RequestMapping(value = "/consumer/dept/add",produces = {"application/json;charset=UTF-8"})
    public boolean add(Dept dept){
        return this.client.addDept(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}",produces = {"application/json;charset=UTF-8"})
    public Dept get(@PathVariable("id")Long id){
        return this.client.findById(id);
    }

    @RequestMapping(value = "/consumer/dept/list",produces = {"application/json;charset=UTF-8"})
    public List<Dept> list(){
        return this.client.findAll();
    }
}

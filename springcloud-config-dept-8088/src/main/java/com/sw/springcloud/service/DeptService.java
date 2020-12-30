package com.sw.springcloud.service;

import com.sw.springcloud.pojo.Dept;

import java.util.List;

/**
 * @Author suaxi
 * @Date 2020/12/28 21:34
 */

public interface DeptService {

    public boolean addDept(Dept dept);

    public Dept findDept(Long id);

    public List<Dept> findAll();
}

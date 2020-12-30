package com.sw.springcloud.service;

import com.sw.springcloud.dao.DeptDao;
import com.sw.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author suaxi
 * @Date 2020/12/28 21:42
 */

@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptDao deptDao;

    @Override
    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }

    @Override
    public Dept findDept(Long id) {
        return deptDao.findDept(id);
    }

    @Override
    public List<Dept> findAll() {
        return deptDao.findAll();
    }
}

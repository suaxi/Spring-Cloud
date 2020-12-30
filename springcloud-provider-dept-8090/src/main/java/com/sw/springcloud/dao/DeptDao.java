package com.sw.springcloud.dao;

import com.sw.springcloud.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author suaxi
 * @Date 2020/12/28 21:34
 */

@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findDept(Long id);

    public List<Dept> findAll();
}

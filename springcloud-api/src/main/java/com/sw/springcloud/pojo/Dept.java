package com.sw.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author suaxi
 * @Date 2020/12/28 21:07
 */

@Data
@NoArgsConstructor
@Accessors(chain = true) //链式编程
public class Dept implements Serializable {
    private Long deptno;
    private String dname;
    private String db_source; //数据存在哪个数据库

    public Dept(String dname) {
        this.dname = dname;
    }
}

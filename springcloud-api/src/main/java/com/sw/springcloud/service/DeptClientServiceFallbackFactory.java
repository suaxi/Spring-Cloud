package com.sw.springcloud.service;

import com.sw.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author suaxi
 * @Date 2020/12/30 9:33
 * 服务降级
 */

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public Dept findById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("未查询到数据，该服务现已被关闭")
                        .setDb_source("没有数据库信息");
            }

            @Override
            public List<Dept> findAll() {
                return null;
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
    /*
    服务熔断：服务端，某个服务超时或异常，引起熔断（类似于保险丝）

    服务降级：客户端，从系统整体负载考虑，当某个服务熔断或关闭之后，服务将不再被调用
             此时在客户端可以设置一个回调FallbackFactory，返回一个默认的缺省值，可以
             提升用户体验，但服务质量随之下降
     */
}

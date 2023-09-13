package com.cjd.mybatis.test.mapper;

import com.cjd.mybatis.binding.MapperProxyFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : chenjd
 * @Date : 2023/9/13 20:26
 **/
public class ApiTest {


    @Test
    public void test1(){
        // 获取代理工厂
        MapperProxyFactory<IUserMapper> factory = new MapperProxyFactory<>(IUserMapper.class);

        // 初始化xml配置方法
        Map<String,String> sqlSession = new HashMap<>();
        sqlSession.put("com.cjd.mybatis.test.mapper.IUserMapper.queryUserName","模拟执行Mapper.xml 中 SQL语句的操作：查询用户姓名");
        sqlSession.put("com.cjd.mybatis.test.mapper.IUserMapper.queryUserImg","模拟执行Mapper.xml 中 SQL语句的操作：查询用户头像");

        // 创建代理对象
        IUserMapper userMapper = factory.newInstance(sqlSession);

        // 调用方法
        String res1 = userMapper.queryUserName("6666");
        String res2 = userMapper.queryUserImg("6666");

        System.out.println(res1);
        System.out.println(res2);

    }

}

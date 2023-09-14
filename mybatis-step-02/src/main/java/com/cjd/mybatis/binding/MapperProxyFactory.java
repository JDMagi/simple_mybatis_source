package com.cjd.mybatis.binding;

import com.cjd.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @Author : chenjd
 * @Date : 2023/9/13 20:25
 **/
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

}

package com.cjd.mybatis.binding;

import cn.hutool.core.lang.ClassScanner;
import com.cjd.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author : chenjd
 * @Date : 2023/9/14 20:36
 **/
public class MapperRegistry {


    private final Map<Class<?>,MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public  <T> T getMapper(Class<T> type, SqlSession sqlSession){

        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>)knownMappers.get(type);

        if (mapperProxyFactory == null){
            throw new RuntimeException("Type"+ type + "不知道这个mapper注册");
        }

        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("获取Mapper配置异常",e);
        }

    }

    public <T> void addMapper(Class<T> type){

       if (type.isInterface()){
           if (hasMapper(type)){
               throw new RuntimeException("重复注册"+ type);
           }
           knownMappers.put(type,new MapperProxyFactory<>(type));
       }

    }

    public void addMappers(String packageName){

        Set<Class<?>> mapperSet = ClassScanner.scanPackage(packageName);
        for (Class<?> mapperClass : mapperSet) {
            addMapper(mapperClass);
        }

    }

    public <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }


}

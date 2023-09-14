package com.cjd.mybatis.session.defaults;

import com.cjd.mybatis.binding.MapperRegistry;
import com.cjd.mybatis.session.SqlSession;

/**
 * @Author : chenjd
 * @Date : 2023/9/14 20:38
 **/
public class DefaultSqlSession implements SqlSession {

    /**
     * 映射器注册机
     */
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return (T)( "你被代理了" + statement);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T)( "你被代理了" + statement + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type,this);
    }
}

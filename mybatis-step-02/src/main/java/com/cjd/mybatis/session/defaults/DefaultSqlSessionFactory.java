package com.cjd.mybatis.session.defaults;

import com.cjd.mybatis.binding.MapperRegistry;
import com.cjd.mybatis.session.SqlSession;
import com.cjd.mybatis.session.SqlSessionFactory;

/**
 * @Author : chenjd
 * @Date : 2023/9/14 20:38
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}

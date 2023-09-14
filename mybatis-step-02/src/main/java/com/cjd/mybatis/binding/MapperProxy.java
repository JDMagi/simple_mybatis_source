package com.cjd.mybatis.binding;

import com.cjd.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @Author : chenjd
 * @Date : 2023/9/13 20:25
 **/
public class MapperProxy<T> implements InvocationHandler, Serializable {


    private static final long serialVersionUID = -1755512392703960050L;

    private SqlSession sqlSession;

    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())){
            return method.invoke(this,args);
        }
        return sqlSession.selectOne(method.getName(),args);
    }
}

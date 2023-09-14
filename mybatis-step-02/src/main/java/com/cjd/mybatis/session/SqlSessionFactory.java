package com.cjd.mybatis.session;

/**
 * @Author : chenjd
 * @Date : 2023/9/14 20:38
 **/
public interface SqlSessionFactory {

    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();

}

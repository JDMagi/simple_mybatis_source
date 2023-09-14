package mapper;

import com.cjd.mybatis.binding.MapperProxyFactory;
import com.cjd.mybatis.binding.MapperRegistry;
import com.cjd.mybatis.session.SqlSession;
import com.cjd.mybatis.session.SqlSessionFactory;
import com.cjd.mybatis.session.defaults.DefaultSqlSessionFactory;
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

        // 1. 注册Mapper
        MapperRegistry mapperRegistry = new MapperRegistry();

        // 扫描包
        mapperRegistry.addMappers("mapper");

        // 从sqlSession工厂获取Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(mapperRegistry);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 获取映射对象
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        ISchoolMapper schoolMapper = sqlSession.getMapper(ISchoolMapper.class);

        // 测试
        String s = mapper.queryUserName("111");
        System.out.println(s);

        String s1 = schoolMapper.querySchoolName("1111");
        System.out.println(s1);

    }

}

package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/3 16:41
 * @Email: 1796235969@qq.com
 */
public class CacheMapperTest {

    @Test
    public void testQueryEmpByCacheTwo() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        List<Emp> emps1 = mapper1.queryEmpByCache();
        System.out.println(emps1);
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        List<Emp> emps2 = mapper2.queryEmpByCache();
        System.out.println(emps2);
        sqlSession2.close();
    }

    @Test
    public void testQueryEmpByCache() {
        SqlSession sqlSession1 = SqlSessionUtils.getSqlSession();
        SqlSession sqlSession2 = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
//        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        List<Emp> emps1 = mapper1.queryEmpByCache();
        System.out.println(emps1);
//        mapper1.inserEmp(new Emp(null, "九九", 22, "女", "7655@qq.com", null));
//        sqlSession1.clearCache();
        List<Emp> emps2 = mapper1.queryEmpByCache();
        System.out.println(emps1);
    }
}

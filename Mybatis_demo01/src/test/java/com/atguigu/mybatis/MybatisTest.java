package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/1 0:18
 * @Email: 1796235969@qq.com
 */
public class MybatisTest {

    @Test
    public void test01() throws IOException {
        // 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取工厂类生成器
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 获取工厂类
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        int i = userMapper.saveUser();
        sqlSession.commit();

        System.out.println("result = " + i);

    }
}

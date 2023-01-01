package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/1 19:24
 * @Email: 1796235969@qq.com
 */
public class ParameterMapperTest {
    @Test
    public void queryAllUserTest() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> users = mapper.queryAllUser();
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void queryUserByName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.queryUserByName("张三");
        // 在mapper接口只有一个参数时，#{}和${}可以以任意字符串接收参数，但是${}要注意单引号问题
        System.out.println(user);


    }

}

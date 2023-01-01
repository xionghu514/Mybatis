package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.ParameterMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 在mapper接口传入多个参数时，此时mybatis是将这些参数放入map中，以两种方式进行存储，
     * 1.arg0 arg1
     * 2.param1 param2
     * 因此只需要以#{} ${} 访问值即可
     * 3. mapper接口有多个参数时可以将这些参数手动放入map中
     */
    @Test
    public void checkUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkUser("张三", "123456");
        System.out.println(user);
    }

    @Test
    public void checkLoginByMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "张三");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

}

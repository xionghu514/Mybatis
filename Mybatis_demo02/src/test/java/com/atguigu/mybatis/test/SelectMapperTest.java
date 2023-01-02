package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/2 12:10
 * @Email: 1796235969@qq.com
 */
public class SelectMapperTest {

    /**
     * mybatis的各种查询功能
     *  1. 若查询结果只有一条数据，可以通过实体类对象或者集合来接收
     *  2. 若查询结果有多条数据，可以通过list集合来接收，但不可以同过实体类来接收，否则会报错: TooManyResultsException
     */

    @Test
    public void testQueryUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.queryUserById(10);
        System.out.println(user);
    }

    @Test
    public void testQueryAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.queryAllUser();
        System.out.println(users);
    }


}

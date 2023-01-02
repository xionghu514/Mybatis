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
     *  1. 若查询结果只有一条数据，
     *   <1. 可以通过 实体类对象 来接收
     *   <2. 可以通过 list 来接收
     *   <2. 可以通过 map 来接收
     *      map结果：{password=123456, sex=男, id=10, age=15, email=123456@qq.com, username=张三}
     *  2. 若查询结果有多条数据
     *   <1. 可以通过 list 来接收
     *   <2. 可以通过 map 类型的 list 来接收
     *   <3. 可以在mapper接口上添加 @MapKey 注解，以每条数据转换的map集合作为值，以某个字段作为键
     *   但不可以同过实体类来接收，否则会报错: TooManyResultsException
     *
     *  mybatis设置了默认的类型别名
     *  例如:
     *      java.lang.Integer -> Integer int
     *      int -> _int _integer
     *      Map -> map
     */

    @Test
    public void testQueryAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.queryAllUserToMap());
    }

    @Test
    public void testQueryUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.queryUserByIdToMap(10));
    }

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        System.out.println(mapper.getCount());
    }

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

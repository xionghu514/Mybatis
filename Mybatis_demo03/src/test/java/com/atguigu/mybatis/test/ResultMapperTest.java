package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/2 16:09
 * @Email: 1796235969@qq.com
 */
public class ResultMapperTest {
    /**
     * 解决字段名和属性名不一致的方法:
     *  1.为字段起别名，保持和属性名一样
     */
    @Test
    public void testQueryEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.queryEmp();
        System.out.println(emps);
    }
}

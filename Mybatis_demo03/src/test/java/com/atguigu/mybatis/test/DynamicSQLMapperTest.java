package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/2 22:53
 * @Email: 1796235969@qq.com
 */
public class DynamicSQLMapperTest {
    @Test
    public void testQueryEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        System.out.println(mapper.queryEmpByCondition(new Emp(null, "张三", 12, "男", "1232@qq.com", null)));
    }
}

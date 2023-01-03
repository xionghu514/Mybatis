package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/2 22:53
 * @Email: 1796235969@qq.com
 */
public class DynamicSQLMapperTest {

    /**
     *  动态sql标签：
     *     1. if：根据标签中test的表达式决定sql语句是否拼接
     *     2. where：
     *          where标签有内容时，会自动生成where关键字，并且将内容前的 and 或者 or 删掉
     *          如过where标签没有内容，where将不生效
     *          注意：where只能删除内容前的and 或者 or，内容后的 and 或者 or无法删除
     *     3. trim
     *          若标签中有内容：
     *              prefix|suffix: 在trim标签中的内容 添加前缀或者后缀
     *              prefixOverrides|suffixOverrides：将trim标签中的内容的前前面或者后面去掉指定内容
     *          若标签中没有内容：trim也不会生效
     *     4. choose when otherwise  相当于 if...else if...else
     *          when最少有一个，otherwise最多只能有一个
     *     5. foreach
     *          collection：设置需要循环的集合或者数组
     *          item：设置集合或者数组中的一个元素
     *          open：设置foreach标签中所有内容的开头
     *          close：设置foreach标签中所有内容的结尾
     *          separator：设置foreach中内容与内容的分割符
     *
     */

    @Test
    public void testInsertMoreByarray() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> emps = new ArrayList<>();
        emps.add(new Emp(null, "赵六", 12, "男", "123456@qq.com", null));
        emps.add(new Emp(null, "塞俄", 18, "女", "1275@qq.com", null));
        emps.add(new Emp(null, "老八", 28, "男", "8888@qq.com", null));
        mapper.insertMoreByarray(emps);
    }

    @Test
    public void testDeleteMoreByArray() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        mapper.deleteMoreByArray(new Integer[] {7,8,9});
    }

    @Test
    public void testQueryEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        System.out.println(mapper.queryEmpByCondition(new Emp(null, "张三", null, "男", null, null)));
    }
}

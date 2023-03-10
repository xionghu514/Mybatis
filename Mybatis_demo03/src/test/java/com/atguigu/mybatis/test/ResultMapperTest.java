package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.DeptMapper;
import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Dept;
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
     *  2.设置全局配置(mapUnderscoreToCamelCase)，将 _ 自动映射为驼峰
     *  3.通过resultMap 设置自定义的映射关系：
     *      <resultMap id="resultEmpMap" type="Emp">
     *         <id column="eid" property="eid"></id>
     *         <result column="emp_name" property="empName"/>
     *         <result column="age" property="age"></result>
     *         <result column="sex" property="sex"></result>
     *         <result column="did" property="did"></result>
     *     </resultMap>
     *
     * 处理多对一映射关系
     *  1.使用级联属性赋值
     *  2.association
     *  3.分步查询
     *      好处: 可以进行延迟加载
     *
     * 处理一对多映射关系
     *  1.collection
     *  2.分步查询
     */

    @Test
    public void testQueryDeptAndEmpByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.queryDeptAndEmpByStepOne(1);
        System.out.println(dept.getDeptName());
    }

    @Test
    public void testQueryDeptAnEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.queryDeptAndEmp(1);
        System.out.println(dept);
    }

    @Test
    public void testQueryEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.queryEmp();
        System.out.println(emps);
    }

    @Test
    public void testEmpAndDeptResultMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.queryEmpByDept(1);
        System.out.println(emp);
    }

    @Test
    public void testQueryEmpAndDeptByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.queryEmpAndDeptByStepOne(2);
        System.out.println(emp.getEmpName());
    }
}

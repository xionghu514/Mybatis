package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;

import java.util.List;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/2 22:51
 * @Email: 1796235969@qq.com
 */
public interface DynamicSQLMapper {
    List<Emp> queryEmpByCondition(Emp emp);
}

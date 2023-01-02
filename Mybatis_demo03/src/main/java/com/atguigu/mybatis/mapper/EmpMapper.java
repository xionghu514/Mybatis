package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;

import java.util.List;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/2 16:00
 * @Email: 1796235969@qq.com
 */
public interface EmpMapper {
    List<Emp> queryEmp();
}

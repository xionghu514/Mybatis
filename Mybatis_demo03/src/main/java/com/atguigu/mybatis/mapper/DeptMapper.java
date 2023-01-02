package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/2 16:00
 * @Email: 1796235969@qq.com
 */
public interface DeptMapper {
    Dept queryEmpAndDeptByStepTwo(@Param("did") Integer did);
}

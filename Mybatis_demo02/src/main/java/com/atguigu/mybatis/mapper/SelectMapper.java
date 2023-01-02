package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/2 12:06
 * @Email: 1796235969@qq.com
 */
public interface SelectMapper {
    User queryUserById(@Param("id") Integer id);

    List<User> queryAllUser();
}

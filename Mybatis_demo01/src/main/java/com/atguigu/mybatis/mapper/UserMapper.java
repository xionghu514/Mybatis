package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2022/12/31 16:22
 * @Email: 1796235969@qq.com
 */
public interface UserMapper {
    // 新增用用户数据
    int saveUser();

    // 修改用户
    void updateUser();

    // 删除用户
    void deleteUser();

    // 查询一条数据
    User queryUserById();

    // 查询多条数据
    List<User> queryUsers();
}

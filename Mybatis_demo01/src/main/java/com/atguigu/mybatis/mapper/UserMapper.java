package com.atguigu.mybatis.mapper;

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
}

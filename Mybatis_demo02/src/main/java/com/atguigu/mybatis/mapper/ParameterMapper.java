package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/1 19:03
 * @Email: 1796235969@qq.com
 */
public interface ParameterMapper {
    List<User> queryAllUser();

    User queryUserByName(String username);

    User checkUser(String username, String password);

    User checkLoginByMap(Map<String, Object> map);
}

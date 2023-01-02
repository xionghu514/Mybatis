package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description:
 * @Author: xionghu514
 * @Date: 2023/1/2 13:48
 * @Email: 1796235969@qq.com
 */
public interface SQLMapper {
    void insertUser(User user);

    List<User> queryUserByLike(@Param("username") String username);

    int deleteMore(@Param("ids") String ids);

    List<User> queryUserByTableName(@Param("tableName") String tableName);
}

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
    List<User> queryUserByLike(@Param("username") String username);

    int deleteMore(@Param("ids") String ids);
}

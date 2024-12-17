package com.cdu.mapper;

import com.cdu.pojo.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 新增用户
     * @param user 用户
     * @return
     */
    int insert(User user);
    /**
     * 根据用户名查询用户1
     * @param username 用户名
     * @return
     */
    User findByUsername(String username);
}

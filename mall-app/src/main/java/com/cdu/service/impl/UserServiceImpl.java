package com.cdu.service.impl;

import com.cdu.commonts.MallConstants;
import com.cdu.mapper.UserMapper;
import com.cdu.pojo.dto.UserRegDTO;
import com.cdu.pojo.entity.User;
import com.cdu.service.UserService;
import com.cdu.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional
    public void reg(UserRegDTO userRegDTO) {
        //判断密码是否一致
        if(!userRegDTO.getPassword().equals(userRegDTO.getRePassword())){
            //密码与确认密码不一致
            // todo 抛出异常
        }
        //密码与确认密码一致
        //对密码进行加密
        //获取盐值
        String salt = UUID.randomUUID().toString().replace("-","");
        //使用盐值+密码+散列次数进行加密
        String password = MD5Utils.enctype(userRegDTO.getPassword(),salt, MallConstants.HASH_TIME);
        //封装用户注册的信息
        User user = new User();
        user.setUsername(userRegDTO.getUsername());
        user.setPassword(password);
        user.setSalt(salt);
        user.setIsDelete(MallConstants.IS_NOT_DELETE);// 0代表不删除，1：删除
        user.setCreatedUser(userRegDTO.getUsername());
        //将时间在数据库新增数据时进行设置

        //调用持久层新增用户信息
        int result = 0;
        try {
            result = userMapper.insert(user);
        } catch (Exception e) {
            // todo 抛异常
        }
        if(result != 1){
            // todo 抛异常
        }
        //执行成功了
    }
}

package com.cdu.service.impl;

import com.cdu.commons.MallConstants;
import com.cdu.commons.R;
import com.cdu.commons.ServiceCode;
import com.cdu.commons.ServiceException;
import com.cdu.mapper.UserMapper;
import com.cdu.pojo.dto.UserLoginDTO;
import com.cdu.pojo.dto.UserRegDTO;
import com.cdu.pojo.entity.User;
import com.cdu.pojo.vo.LoginUserVO;
import com.cdu.service.UserService;
import com.cdu.utils.JwtUtils;
import com.cdu.utils.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void reg(UserRegDTO userRegDTO) {
        //判断密码是否一致
        if (!userRegDTO.getPassword().equals(userRegDTO.getRePassword())) {
            //密码与确认密码不一致
            throw new ServiceException("确认密码与密码不一致", ServiceCode.DATA_CHECK_ERROR);
        }
        String salt = UUID.randomUUID().toString().replace("-", "");
        //使用盐值+密码+散列次数进行加密
        String password = MD5Utils.enctype(userRegDTO.getPassword(), salt, MallConstants.HASH_TIME);
        //封装用户注册的信息
        User user = new User();
        user.setUsername(userRegDTO.getUsername());
        user.setPassword(password);
        user.setSalt(salt);
        user.setIsDelete(MallConstants.IS_NOT_DELETE);// 0代表不删除，1：删除
        user.setCreatedUser(userRegDTO.getUsername());
        //将时间在数据库新增数据时进行设置
        user.setCreatedTime(new Date());
        user.setModifiedUser(userRegDTO.getUsername());
        user.setModifiedTime(new Date());
        //调用持久层新增用户信息
        int result = 0;
        try {
            result = userMapper.insert(user);
        } catch (Exception e) {
            throw new ServiceException("注册失败:数据库错误",ServiceCode.INSERT_ERROR);
        }
        if (result != 1) {
            throw new ServiceException("注册失败:SQL语句执行失败",ServiceCode.INSERT_ERROR);
        }
        //执行成功了
    }

    @Override
    public R<LoginUserVO> login(UserLoginDTO userLoginDTO) {
        User realUser = userMapper.findByUsername(userLoginDTO.getUsername());
        if(realUser==null){
            throw new ServiceException("该用户不存在，请检查用户名", ServiceCode.DATA_NOT_FOUND);
        }
        String password = MD5Utils.enctype(userLoginDTO.getPassword(), realUser.getSalt(), MallConstants.HASH_TIME);
        if (!realUser.getPassword().equals(password)) {
            throw new ServiceException("密码错误", ServiceCode.LOGIN_ERROR);
        }
        LoginUserVO userVO = new LoginUserVO();
        userVO.setId(realUser.getId());
        userVO.setUsername(realUser.getUsername());
        userVO.setAvatar(realUser.getAvatar());
        userVO.setToken(JwtUtils.generateToken(realUser));
        return R.ok("登录成功",userVO);
    }
}

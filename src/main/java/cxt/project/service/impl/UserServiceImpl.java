package cxt.project.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cxt.project.entity.User;
import cxt.project.mapper.UserMapper;
import cxt.project.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

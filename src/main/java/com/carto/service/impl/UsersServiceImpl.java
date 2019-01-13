package com.carto.service.impl;

import com.carto.dao.UsersDao;
import com.carto.entity.Users;
import com.carto.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    private UsersDao usersDao;

    public Users getUsersByUsername(String username) {
        return usersDao.getUsersByUsername(username);
    }
}
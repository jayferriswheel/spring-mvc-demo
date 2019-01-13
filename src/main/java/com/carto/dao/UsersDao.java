package com.carto.dao;

import com.carto.entity.Users;

public interface UsersDao {
    Users getUsersByUsername(String username);
}
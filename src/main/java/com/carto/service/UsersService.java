package com.carto.service;

import com.carto.entity.Users;

public interface UsersService {
    Users getUsersByUsername(String username);
}
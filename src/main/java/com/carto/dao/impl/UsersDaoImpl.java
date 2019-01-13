package com.carto.dao.impl;

import com.carto.dao.UsersDao;
import com.carto.entity.Users;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class UsersDaoImpl extends SqlSessionDaoSupport implements UsersDao {
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        // TODO Auto-generated method stub
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public Users getUsersByUsername(String username) {
        return this.getSqlSession().selectOne("com.test.mapper.UsersMapper.selectUsersByUsername", username);
    }
}
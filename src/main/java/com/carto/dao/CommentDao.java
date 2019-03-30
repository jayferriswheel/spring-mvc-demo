package com.carto.dao;

import com.carto.entity.CommentBean;
import com.carto.mapper.CommentMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class CommentDao extends SqlSessionDaoSupport {
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public List<CommentBean> getCommentList(String productId, int startIndex, int endIndex) {
        Map<String, Object> parameters = new java.util.HashMap();
        parameters.put("0", productId);
        parameters.put("1", startIndex);
        parameters.put("2", endIndex);
        CommentMapper mapper = this.getSqlSession().getMapper(CommentMapper.class);
        return mapper.selectRange(parameters);
//        return this.getSqlSession().selectList("com.carto.mapper.CommentMapper.selectRange", parameters);
    }
}

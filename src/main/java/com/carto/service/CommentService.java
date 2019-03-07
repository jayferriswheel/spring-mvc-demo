package com.carto.service;

import com.carto.dao.CommentDao;
import com.carto.entity.CommentBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {
    @Resource
    private CommentDao commentDao;

    public List<CommentBean> getCommentRange(String productId, int start, int end) {
        return commentDao.getCommentList(productId, start, end);
    }
}

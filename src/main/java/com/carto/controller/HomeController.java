package com.carto.controller;

import com.carto.entity.CommentBean;
import com.carto.entity.Users;
import com.carto.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Resource
    private UsersService usersService;

    @RequestMapping(value = "/hello", method = {RequestMethod.POST})
    @ResponseBody
    public String hello() {
        Users users = usersService.getUsersByUsername("larry");
        return users.getPassword();
    }


    @CrossOrigin
    @RequestMapping(value = "/commentList", method = {RequestMethod.POST})
    @ResponseBody
    public List<CommentBean> getCommentList() {
        List<CommentBean> beans = new ArrayList<CommentBean>();
        for (int i = 0; i < 5; i++) {
            CommentBean commentBean = new CommentBean();
            if (i == 1 || i == 2) {
                commentBean.isMember = false;
            }
            beans.add(commentBean);
        }

        return beans;
    }
}

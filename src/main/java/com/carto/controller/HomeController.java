package com.carto.controller;

import com.carto.entity.CommentBean;
import com.carto.service.CommentService;
import com.carto.util.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Resource
    private CommentService commentService;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(@RequestParam(value = "name") String name) {
        if (name.equals("larry")) {
            throw new MyException();
        }
        return "hello " + name;
    }

    @CrossOrigin
    @RequestMapping(value = "/commentList", method = {RequestMethod.POST})
    @ResponseBody
    public List<CommentBean> getCommentList(@RequestParam(value = "start") int start, @RequestParam(value = "end") int end, @RequestParam(value = "productId") String productId) {
        return commentService.getCommentRange(productId, start, end);
    }




}

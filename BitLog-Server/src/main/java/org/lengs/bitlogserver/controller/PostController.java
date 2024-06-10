package org.lengs.bitlogserver.controller;

import org.lengs.bitlogserver.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Author: lengs
 * @Date: 2024/6/1 13:51
 * @Description: 帖子控制层
 * @Version: 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    IPostService postService;

    @GetMapping("/list")
    public int listPost(){
        return 9;
    }
    @GetMapping("/error")
    public int error(){
        return 9/0;
        // throw new RuntimeException("自定义异常");
    }
}

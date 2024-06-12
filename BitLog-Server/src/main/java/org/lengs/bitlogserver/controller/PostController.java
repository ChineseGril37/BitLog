package org.lengs.bitlogserver.controller;

import org.lengs.bitlogserver.controller.request.PostRequest;
import org.lengs.bitlogserver.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Object listPost(){
        //System.out.println(postService.listPost());
        return postService.listPost();
    }
    @GetMapping("/")
    public Object sort(PostRequest postRequest){
        return postService.sort(postRequest);
    }
    @GetMapping("/error")
    public int error(){
            throw new RuntimeException("自定义异常");
    }
}

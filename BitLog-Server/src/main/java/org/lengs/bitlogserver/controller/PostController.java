package org.lengs.bitlogserver.controller;

import org.lengs.bitlogserver.controller.request.PageRequest;
import org.lengs.bitlogserver.entity.Post;
import org.lengs.bitlogserver.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Object sort(PageRequest pageRequest){
        return postService.sort(pageRequest);
    }
    @GetMapping("/error")
    public int error(){
            throw new RuntimeException("自定义异常");
    }
}

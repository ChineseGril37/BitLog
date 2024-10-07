package org.lengs.bitlogserver.controller;

import org.lengs.bitlogserver.common.MarkDownReader;
import org.lengs.bitlogserver.controller.request.PostRequest;
import org.lengs.bitlogserver.entity.Post;
import org.lengs.bitlogserver.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * @Author: lengs
 * @Date: 2024/6/1 13:51
 * @Description: 博客贴控制层
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
    @GetMapping("/sort")
    public Object sort(PostRequest postRequest){

        return postService.sort(postRequest);
    }
    @GetMapping("/selectById")
    public Post selectById(PostRequest postRequest) throws IOException {
        Post post = postService.selectById(postRequest);
        if(post == null){
            throw new RuntimeException("查询不到对应的结果");
        }
        post.setFile(MarkDownReader.markDownReader("C:\\Users\\lengs\\IdeaProjects\\BitLog\\debug.md"));
        System.out.println(post.getFile());
        return post;
    }
    @GetMapping("/runtimeError")
    public int error(){
        throw new RuntimeException("自定义异常");
    }

    @GetMapping("/Error")
    public int arithmeticError(){
        //int[] ans = new int[1];
        //return ans[1];
        throw new ArithmeticException ("计算异常");
    }
}

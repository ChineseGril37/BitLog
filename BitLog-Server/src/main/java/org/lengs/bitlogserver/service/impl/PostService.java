package org.lengs.bitlogserver.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lengs.bitlogserver.controller.request.PostRequest;
import org.lengs.bitlogserver.dao.PostMapper;
import org.lengs.bitlogserver.entity.Post;
import org.lengs.bitlogserver.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author: lengs
 * @Date: 2024/6/1 13:51
 * @Description:
 * @Version: 1.0
 */
@Service
public class PostService implements IPostService {
    @Autowired
    PostMapper postMapper;
    @Override
    public List<Post> listPost() {
        return postMapper.listPost();
    }

    @Override
    public Object sort(PostRequest postRequest) {
        System.out.println("postRequest.getPageNum()="+postRequest.getPageNum());
        System.out.println("postRequest.getPageSize()="+postRequest.getPageSize());
        PageHelper.startPage(postRequest.getPageNum(),postRequest.getPageSize());
        List<Post> posts = postMapper.sort(postRequest);
        return new PageInfo<>(posts);
    }
}

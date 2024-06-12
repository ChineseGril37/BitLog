package org.lengs.bitlogserver.service.impl;

import org.lengs.bitlogserver.controller.request.PostRequest;
import org.lengs.bitlogserver.dao.PostDao;
import org.lengs.bitlogserver.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Author: lengs
 * @Date: 2024/6/1 13:51
 * @Description:
 * @Version: 1.0
 */
@Service
public class PostService implements IPostService {
    @Autowired
    PostDao postDao;
    @Override
    public Object listPost() {
        return postDao.listPost();
    }

    @Override
    public Object sort(PostRequest postRequest) {
        return postDao.sort(postRequest);
    }
}

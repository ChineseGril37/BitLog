package org.lengs.bitlogserver.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.lengs.bitlogserver.controller.request.PostRequest;
import org.lengs.bitlogserver.dao.PostMapper;
import org.lengs.bitlogserver.entity.Post;
import org.lengs.bitlogserver.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.lengs.bitlogserver.common.MarkDownReader;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
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
    public Object listPost() {
        return postMapper.listPost();
    }

    @Override
    public Object sort(PostRequest postRequest) {
        PageHelper.startPage(postRequest.getPageNum(), postRequest.getPageSize());
        List<Post> posts = postMapper.sort(postRequest);
        // System.out.printf("Fetched posts from database: %s%n", posts);
        switch (postRequest.getSelectType()) {
            case "Likes":
                posts.sort(Comparator.comparing(Post::getLikes).reversed());
                break;
            case "Views":
                posts.sort(Comparator.comparing(Post::getViews).reversed());
                break;
            case "CreateTime":
                posts.sort(Comparator.comparing(Post::getCreatetime).reversed());
                break;
            case "UpdateTime":
                posts.sort(Comparator.comparing(Post::getUpdatetime).reversed());
                break;
            default:
                // 默认按热度排序,注意先别调用
                posts.sort(Comparator.comparing(Post::getHotpoint).reversed());
                break;
        }
        return new PageInfo<>(posts);
    }

    @Override
    public Post selectById(PostRequest postRequest) throws IOException {
        Post post = postMapper.selectById(postRequest);
        if (post == null) {
            return null;
        }
        String filePath = post.getFile();
        if (filePath != null && !filePath.isBlank()) {
            // 格式化路径，确保为绝对路径
            java.io.File file = new java.io.File(filePath);
            if (!file.isAbsolute()) {
                file = new java.io.File(System.getProperty("user.dir"), filePath);
            }
            post.setFile(MarkDownReader.markDownReader(file.getCanonicalPath()));
        }
        return post;
    }
}

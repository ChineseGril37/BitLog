package org.lengs.bitlogserver.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lengs.bitlogserver.controller.request.PostRequest;
import org.lengs.bitlogserver.entity.Post;
import java.util.List;

/**
 * @Author: lengs
 * @Date: 2024/6/10 21:00
 * @Description: post mapper
 * @Version: 1.0
 */
@Mapper
public interface PostMapper {
    List<Post> listPost();

    List<Post> sort(PostRequest postRequest);

    Post selectById(PostRequest postRequest);
}

package org.lengs.bitlogserver.dao;

import org.apache.ibatis.annotations.Mapper;
import org.lengs.bitlogserver.controller.request.PostRequest;


/**
 * @Author: lengs
 * @Date: 2024/6/10 21:00
 * @Description:
 * @Version: 1.0
 */
@Mapper
public interface PostDao {
    Object listPost();

    Object sort(PostRequest postRequest);
}

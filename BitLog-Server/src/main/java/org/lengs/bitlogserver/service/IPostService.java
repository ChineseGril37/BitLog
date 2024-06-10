package org.lengs.bitlogserver.service;

import org.lengs.bitlogserver.controller.request.PageRequest;
import org.lengs.bitlogserver.entity.Post;

import java.util.List;

/**
 * @Author lengs
 * @Date 2024/6/1 13:51
 * @Description:
 * @Version 1.0
 */

public interface IPostService {
    Object listPost();

    Object sort(PageRequest pageRequest);
}

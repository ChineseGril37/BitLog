package org.lengs.bitlogserver.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: lengs
 * @Date: 2024/6/2 13:38
 * @Description: 帖子实体
 * @Version: 1.0
 */
public class Post {
    @ApiModelProperty(value = "用户角色id")
    private long id;
    private String title;
    private String type;

}

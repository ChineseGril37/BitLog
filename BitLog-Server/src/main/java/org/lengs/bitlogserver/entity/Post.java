package org.lengs.bitlogserver.entity;

import java.io.File;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: lengs
 * @Date: 2024/6/2 13:38
 * @Description: 帖子实体
 * @Version: 1.0
 */
@Data
public class Post {
    @ApiModelProperty(value = "用户角色id")
    private Integer id;
    private Integer author;
    private String title;
    private String type;
    private Date createtime;
    private Date updatetime;
    private Integer likes;
    private Integer views;
    private Double hotpoint;
    private String shortcut;
    private String file;
}

package org.lengs.bitlogserver.entity;

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
    private Long id;
    private String title;
    private String type;
    private Date createTime;
    private Date updateTime;
    private Integer view;
}

package org.lengs.bitlogserver.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private Integer id;
    private Integer post_id;
    private String email;
    private String name;
    private String content;
    private Integer likes;
    private Date timestamp;
}

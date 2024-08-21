package org.lengs.bitlogserver.entity;

import lombok.Data;

@Data
public class Article {
    private Integer post_id;
    private Integer file_id;
    private Comment[] comments;
    public Article(Integer post_id, Integer file_id, Comment[] comments) {
        this.post_id = post_id;
        this.file_id = file_id;
        this.comments = comments;
    }

}

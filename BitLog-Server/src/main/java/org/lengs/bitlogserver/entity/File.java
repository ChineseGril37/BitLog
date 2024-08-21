package org.lengs.bitlogserver.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class File {
    private Integer id;
    private String fileName;
    private String filePath;
    private Long fileSize;
    private Date createtime;
    private Date updatetime;
    private MultipartFile file;
}

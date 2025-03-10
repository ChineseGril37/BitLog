package org.lengs.bitlogserver.controller.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.File;

/**
 * @Author: lengs
 * @Date: 2024/6/11 19:04
 * @Description:
 * @Version: 1.0
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class PostRequest extends BaseRequest {
    private Integer id;
    private String type;
    private String selectType = "Hot";
    private File file;
}

package org.lengs.bitlogserver.controller.request;

import lombok.Data;

/**
 * @author lengs
 */
@Data
public class BaseRequest {
    private Integer pageNum = 1;
    private Integer pageSize = 20;
}

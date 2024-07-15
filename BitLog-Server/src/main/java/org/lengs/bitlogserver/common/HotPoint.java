package org.lengs.bitlogserver.common;

import lombok.Data;

/**
 * @Author: lengs
 * @Date: 2024/7/15 上午10:11
 * @Description: 基于温度、点赞、评论、浏览数量的热度算法实现
 * @Version: 1.0
 */
@Data
public class HotPoint {
    private static final double VIEW_COUNT_WEIGHT = 5.0;
    private static final double COMMENT_COUNT_WEIGHT = 3.0;
    private static final double UPDATE_TIMESTAMP_WEIGHT = 2.0;
    private static final double LIKE_COUNT_WEIGHT = 1.5;
    private static final double TAG_HEAT_WEIGHT = 1.0;
}

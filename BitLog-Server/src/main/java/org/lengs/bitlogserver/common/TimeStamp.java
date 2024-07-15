package org.lengs.bitlogserver.common;

import lombok.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * @Author: lengs
 * @Date: 2024/7/15 上午10:04
 * @Description:
 * @Version: 1.0
 */
@Data
public class TimeStamp {

    private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 将 yyyy-MM-dd HH:mm:ss 格式的日期时间字符串转换为时间戳
     *
     * @param dateTime 日期时间字符串
     * @return 时间戳（毫秒）
     * @throws ParseException 日期时间解析异常
     */
    public static long convertToTimestamp(String dateTime) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        Date date = sdf.parse(dateTime);
        return date.getTime();
    }

    /**
     * 将时间戳转换为 yyyy-MM-dd HH:mm:ss 格式的日期时间字符串
     *
     * @param timestamp 时间戳（毫秒）
     * @return 日期时间字符串
     */
    public static String convertToDateTime(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        Date date = new Date(timestamp);
        return sdf.format(date);
    }

    /**
     * 比较两个时间戳
     *
     * @param timestamp1 第一个时间戳
     * @param timestamp2 第二个时间戳
     * @return -1 如果第一个时间戳早于第二个时间戳，0 如果两个时间戳相等，1 如果第一个时间戳晚于第二个时间戳
     */
    public static int compareTimestamps(long timestamp1, long timestamp2) {
        return Long.compare(timestamp1, timestamp2);
    }

    /**
     * 比较两个 yyyy-MM-dd HH:mm:ss 格式的日期时间字符串
     *
     * @param dateTime1 第一个日期时间字符串
     * @param dateTime2 第二个日期时间字符串
     * @return -1 如果第一个日期时间早于第二个日期时间，0 如果两个日期时间相等，1 如果第一个日期时间晚于第二个日期时间
     * @throws ParseException 日期时间解析异常
     */
    public static int compareDateTimes(String dateTime1, String dateTime2) throws ParseException {
        long timestamp1 = convertToTimestamp(dateTime1);
        long timestamp2 = convertToTimestamp(dateTime2);
        return compareTimestamps(timestamp1, timestamp2);
    }
}

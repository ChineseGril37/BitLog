package org.lengs.bitlogserver.common;

/**
 * @Author: lengs
 * @Date: 2024/10/7 下午6:31
 * @Description:
 * @Version: 1.0
 */
import org.lengs.bitlogserver.entity.Post;

import java.io.*;

public class MarkDownReader {

    // 读取Markdown文件内容并返回File对象
    public static String markDownReader(String path) throws IOException {
        StringBuilder content = new StringBuilder();
        File file = new File(path);

        // 确认文件是否存在
        if (!file.exists() || !file.isFile()) {
            throw new IOException("File not found: " + path);
        }

        // 读取文件内容
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new IOException("Error reading file: " + path, e);
        }

        return content.toString();
    }
}

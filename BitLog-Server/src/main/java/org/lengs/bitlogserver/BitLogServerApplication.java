package org.lengs.bitlogserver;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @Author: lengs
 * @Date: 2024/5/31 23:47
 * @Description:
 * @Version: 1.0
 */
@RestController
@SpringBootApplication
public class BitLogServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BitLogServerApplication.class, args);
    }
    // 健康检查的接口
    @GetMapping
    public String health(){
        return "SUCCESS！";
    }

}

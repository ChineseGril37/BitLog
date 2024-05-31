package org.lengs.bblogserver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author lengs
 */
@RestController
@SpringBootApplication
public class BbLogServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(BbLogServerApplication.class, args);
        System.out.println("Hello World");
    }
    // 健康检查的接口
    @GetMapping
    public String health(){
        return "SUCCESS！";
    }

}

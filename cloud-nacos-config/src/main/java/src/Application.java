package src;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: lty
 * @Date: 2020/3/27 15:52
 */

@RestController
@RefreshScope
@SpringBootApplication
@EnableDiscoveryClient
public class Application {
    public static void main(String[] args) {
       SpringApplication.run(Application.class,args);
    }

    @Value("${test.name:null}")
    String NAME;


    @RequestMapping("test")
    public void tesst() {
        System.out.println(NAME);
    }
}

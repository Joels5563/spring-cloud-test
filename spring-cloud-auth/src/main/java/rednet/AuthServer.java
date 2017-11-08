package rednet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhouchao
 * @Description 权限服务
 * @date 2017/10/30 16:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AuthServer {

    public static void main(String[] args) {
        SpringApplication.run(AuthServer.class, args);
    }

}

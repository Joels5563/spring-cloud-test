package rednet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author zhouchao
 * @Description 配置文件服务器
 * @date 2017/10/17 11:16
 */

@SpringBootApplication
//设置当前项目为配置文件服务器
@EnableConfigServer
public class ConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
}

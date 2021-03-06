package rednet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhouchao
 * @Description 简单的控制器, 测试
 * @date 2017/10/16 15:10
 */

@Controller
@SpringBootApplication
public class SampleController {

    @Autowired
    private CounterService counterService;

    @ResponseBody
    @RequestMapping(value = "/")
    String home() {
        counterService.increment("rednet.hello.count");
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}

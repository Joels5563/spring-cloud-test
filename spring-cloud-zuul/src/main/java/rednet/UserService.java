package rednet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author zhouchao
 * @Description 用户服务
 * @date 2017/10/30 16:39
 */
@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    private static final String SERVICE_NAME = "cloud-service";

    public List<String> getAuthList(String username) {
        return restTemplate.getForObject("http://" + SERVICE_NAME + "/service/auth?username={username}", List.class, username);
    }

    //public List<String> getAuthList(String username) {
    //    List<String> authList = new ArrayList<>();
    //    if(username.equals("admin")) {
    //        authList.add("/service/test");
    //    }
    //    if (username.equals("user")) {
    //        authList.add("/service/user");
    //    }
    //    authList.add("/service/guest");
    //    return authList;
    //}
}

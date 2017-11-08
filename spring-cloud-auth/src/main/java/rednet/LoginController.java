package rednet;

import jwt.JWTInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import util.JwtHelper;

/**
 * @author zhouchao
 * @Description 登录
 * @date 2017/10/30 15:59
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username) {
        JWTInfo jwtInfo = new JWTInfo(username,"11","zhouchao");
        try {
            return JwtHelper.generateToken(jwtInfo,60*30);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}

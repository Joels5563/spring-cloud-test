package rednet.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rednet.service.domain.UserService;
import rednet.service.model.User;

import java.util.List;

/**
 * @author zhouchao
 * @Description 用户信息控制器
 * @date 2017/10/17 14:31
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user",method=RequestMethod.GET)
	public List<User> readUserInfo(){
		List<User> ls=userService.searchAll();		
		return ls;
	}
}

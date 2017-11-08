package rednet.service.web;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rednet.service.domain.UserService;
import rednet.service.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhouchao
 * @Description 用户信息控制器
 * @date 2017/10/17 14:31
 */
@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

	private UserService userService;

	private DiscoveryClient client;

	//@RequestMapping(value="/user",method=RequestMethod.GET)
	//public List<UserInfo> readUserInfo(){
	//	ServiceInstance instance = client.getLocalServiceInstance();
	//	System.out.println("/users, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
	//	List<UserInfo> ls=userService.searchAll();
	//	return ls;
	//}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {
		return "user";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}

	@RequestMapping(value = "/guest", method = RequestMethod.GET)
	public String guest() {
		return "guest";
	}

	@RequestMapping(value = "/auth", method = RequestMethod.GET)
	public List<String> getAuthList(String username) {
		List<String> authList = new ArrayList<>();
		if (username.equals("admin")) {
			authList.add("/service/test");
		}
		if (username.equals("user")) {
			authList.add("/service/user");
		}
		authList.add("/service/guest");
		return authList;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<UserInfo> all() {
		return userService.searchAll();
	}
}

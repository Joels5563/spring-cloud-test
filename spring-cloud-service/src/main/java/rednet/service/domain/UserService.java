package rednet.service.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rednet.service.dao.UserDao;
import rednet.service.model.User;

import java.util.List;

/**
 * @author zhouchao
 * @Description 用户服务
 * @date 2017/10/17 14:31
 */
@Service
@Transactional(rollbackFor = {})
public class UserService {


    @Autowired
    private UserDao userMapper;

    public List<User> searchAll() {
        List<User> list = userMapper.findAll();
        return list;
    }
}

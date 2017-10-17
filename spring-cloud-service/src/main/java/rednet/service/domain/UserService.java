package rednet.service.domain;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rednet.service.dao.UserDao;
import rednet.service.model.User;

import java.util.List;


@Service
@Transactional
public class UserService {


    @Autowired
    private UserDao userMapper;

    public List<User> searchAll() {
        List<User> list = userMapper.findAll();
        return list;
    }
}

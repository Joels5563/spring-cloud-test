package rednet.service.domain;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rednet.service.dao.UserInfoMapper;
import rednet.service.model.UserInfo;

import java.util.List;

/**
 * @author zhouchao
 * @Description 用户服务
 * @date 2017/10/17 14:31
 */
@Service
@Transactional(rollbackFor = NullPointerException.class)
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService {

    private UserInfoMapper userMapper;

    public List<UserInfo> searchAll() {
        return userMapper.findAll();
    }
}

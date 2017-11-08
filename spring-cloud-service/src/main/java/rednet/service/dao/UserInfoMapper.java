package rednet.service.dao;

import org.apache.ibatis.annotations.Mapper;
import rednet.service.model.UserInfo;

import java.util.List;

/**
 * @author zhouchao
 * @Description 用户信息mapper
 * @date 2017/10/23 17:00
 */
@Mapper
public interface UserInfoMapper {
    /**
     * 通过username查找用户信息
     *
     * @param username 用户账号
     * @return 用户信息
     */
    UserInfo findByUsername(String username);

    List<UserInfo> findAll();
}

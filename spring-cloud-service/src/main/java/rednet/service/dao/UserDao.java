package rednet.service.dao;

import rednet.service.model.User;

import java.util.List;

/**
 * @author zhouchao
 * @Description 用户表dao
 * @date 2017/10/17 14:31
 */
public interface UserDao {

    /**
     * 查找所有的用户信息
     *
     * @return 用户信息列表
     */
    List<User> findAll();
}

package rednet.service.dao;

import rednet.service.model.User;

import java.util.List;

public interface UserDao {

	List<User> findAll();
}

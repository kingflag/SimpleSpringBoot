package hello.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.Mapper.UserMapper;
import hello.domain.User;

@Component
public class UserDao {

	@Autowired
	UserMapper userMapper;

	public List<User> queryall() {
		List<User> users = userMapper.queryall();
		return users;
	}

	public String user() {
		User user = userMapper.findUserById("1");
		return user.getName() + "-----" + user.getAge();

	}
}

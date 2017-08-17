package hello.service;

import java.util.List;

import hello.domain.User;

public interface IUserService {
	
	public String add();

	public List<User> queryall();

	public String delete();

	public String change();
	
	public Boolean addsome();

}

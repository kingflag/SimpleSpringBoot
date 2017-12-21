package hello.controller;

import hello.domain.User;

public interface IUserController {

	public String add(User user);

	public String queryall();

	public String delete();

	public String change();

	public Boolean addsome();
}

package hello.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.controller.IUserController;
import hello.domain.User;
import hello.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements IUserController {

	@Autowired
	IUserService userServiceImpl;

	@Override
	@RequestMapping("/add")
	public String add() {

		return "add";
	}

	@Override
	@RequestMapping("/queryall")
	public String queryall() {
		List<User> users = userServiceImpl.queryall();
		System.out.println(users.toString());
		return "queryall:"+users.toString();
	}

	@Override
	@RequestMapping("/delete")
	public String delete() {

		return "delete";
	}

	@Override
	@RequestMapping("/change")
	public String change() {

		return "change";
	}

	@Override
	@RequestMapping("/addsome")
	public Boolean addsome() {
		Boolean result = userServiceImpl.addsome();
		return result;
	}

}

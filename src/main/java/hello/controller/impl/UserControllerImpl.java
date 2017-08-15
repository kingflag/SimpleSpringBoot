package hello.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.controller.IUserController;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements IUserController {

	
	@Override
	@RequestMapping("/add")
	public String add() {
		
		return "add";
	}

	@Override
	@RequestMapping("/queryall")
	public String queryall() {
		
		return "queryall";
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

}

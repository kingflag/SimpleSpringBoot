package hello.controller.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

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
		Map<String, Object> result = new HashMap<>();
		List<User> users = new ArrayList<User>();
		Gson gson = new Gson();
		String resdata = "";
		try {
			users = userServiceImpl.queryall();
			result.put("state", "200");
			result.put("data", users);
			resdata = gson.toJson(result);
			System.out.println(resdata);
		} catch (Exception e) {
			result.put("state", "400");
			result.put("data", "err");
			resdata = gson.toJson(result);
		} finally {
			return resdata;
		}

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

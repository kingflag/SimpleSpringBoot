package hello.controller.impl;

import com.google.gson.Gson;
import hello.controller.IUserController;
import hello.domain.User;
import hello.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserControllerImpl implements IUserController {

	@Autowired
	IUserService userServiceImpl;

	/**
	 * 添加成员
	 * @param user
	 * @return
	 */
	@Override
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public String add(@RequestBody User user) {
		String result = "";
		if (user == null){
			result = "参数不可为空";
		}else{
			result = user.getName();
		}
		return result;
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

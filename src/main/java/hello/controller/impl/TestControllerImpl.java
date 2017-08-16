package hello.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.controller.ITestController;

@RestController
@RequestMapping("/testController")
public class TestControllerImpl implements ITestController {

	
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

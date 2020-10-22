package lfzh.controller;

import javax.servlet.http.HttpSession;

import lfzh.exception.SSMException;
import lfzh.model.User;
import lfzh.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
	@Autowired
	private IUserService userService;

	@RequestMapping({ "/", "/login" })
	public String login() {
		return "login";
	}

	@RequestMapping("index")
	public String index1() {
		return "index";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, HttpSession session,Model model) throws SSMException {
		User loginUser = userService.login(user);
		// 把登陆的信息保存到session中
		if(loginUser==null || !loginUser.getPassword().equals(user.getPassword())){
			model.addAttribute("a", "用户名或密码错误!!!!");
			return "login";
		}else{
			session.setAttribute("loginUser", loginUser);
			return "redirect:/index";
		}
	}
}


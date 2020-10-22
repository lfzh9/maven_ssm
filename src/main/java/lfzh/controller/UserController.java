package lfzh.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import lfzh.model.Dept;
import lfzh.model.User;
import lfzh.service.IDeptService;
import lfzh.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IDeptService deptService;

	@RequestMapping("/list")
	public String list(HttpSession session, Model model){
		 // 获取登陆信息
		 User loginUser = (User) session.getAttribute("loginUser");
		 // 未登录 跳转到登陆页面
		 if (loginUser == null) {
		 return "redirect:/";
		 }

		// 如果登陆 获取所有的用户 传递到页面
		List<User> users = userService.list();
		model.addAttribute("users", users);
		return "user/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET )
	public String add(Model model){
//		model.addAttribute("user",new User());
		List<Dept> depts = deptService.list();
		model.addAttribute("depts", depts);
		return "user/add";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@Validated User user){
//		System.out.println(name);
		userService.add(user);
		return "redirect:/user/list";
	}
	@RequestMapping("/verifyUsername")
	@ResponseBody
	public String  verifyUsername( String username){
		String str="null" ;
		User user = userService.loadByUsername(username);
		if(user!=null){
			str = "用户名已存在";
		}
		return str;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(int id){
		userService.delete(id);
		return "0";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET )
	public String update(Model model,@PathVariable int id){
		User user = userService.loadById(id);
		model.addAttribute("user",user);
		List<Dept> depts = deptService.list();
		model.addAttribute("depts", depts);
		return "user/update";
	}
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public String update(@Validated User user,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "user/update";
		}
		userService.update(user);;
		return "redirect:/user/list";
	}
}

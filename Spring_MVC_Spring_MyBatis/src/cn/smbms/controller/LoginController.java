package cn.smbms.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.smbms.pojo.User;
import cn.smbms.service.user.UserService;
import cn.smbms.tools.Constants;

@Controller
public class LoginController {

	private Logger logger = Logger.getLogger(LoginController.class);
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/login.html")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/dologin.html",method=RequestMethod.POST)
	public String doLogin(@RequestParam String userCode,@RequestParam String userPassword,
			HttpServletRequest request,HttpSession session)throws Exception{
		User user = userService.login(userCode, userPassword);
		if(null != user){
			if(user.getUserPassword().equals(userPassword)){
				session.setAttribute(Constants.USER_SESSION,user);
				return "redirest:/sys/main.html";
			}else{
				request.setAttribute("error", "密码不正确！");
			}
		}else{
			request.setAttribute("error", "用户不存在！");
		}
		return "login";
	}
	
	@RequestMapping(value="/logout.html")
	public String logout(HttpSession session){
		session.removeAttribute(Constants.USER_SESSION);
		return "login";
	}
	
	@RequestMapping(value="/sys/main.html")
	public String main(){
		return "frame";
	}
}

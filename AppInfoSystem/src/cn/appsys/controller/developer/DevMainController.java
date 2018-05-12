package cn.appsys.controller.developer;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.appsys.service.user.UserService;
import cn.appsys.tools.Constants;

@Controller
@RequestMapping(value = "/dev/flatform")
public class DevMainController {

	private final Logger logger = Logger.getLogger(DevLoginController.class);
	@Resource
	private UserService devUserService;

	// 登录成功跳转主页验证
	@RequestMapping(value = "/main")
	public String main(HttpSession session) {
		logger.debug("main()");
		if (session.getAttribute(Constants.DEV_USER_SESSION) == null) {
			return "redirect:/dev/login";
		}
		return "developer/main";
	}
}

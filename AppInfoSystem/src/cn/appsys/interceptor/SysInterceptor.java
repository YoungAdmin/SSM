package cn.appsys.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.appsys.pojo.BackendUser;
import cn.appsys.tools.Constants;

public class SysInterceptor extends HandlerInterceptorAdapter{

	private Logger logger = Logger.getLogger(SysInterceptor.class);
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
		logger.debug("=================================À¹½ØÆ÷£ºSysInterceptor preHandle!");
		HttpSession session = request.getSession();
		BackendUser user = (BackendUser)session.getAttribute(Constants.USER_SESSION);
		if(null == user){
			response.sendRedirect(request.getContextPath() + "/403.jsp");
			return false;
		}
		return true;
	}
}

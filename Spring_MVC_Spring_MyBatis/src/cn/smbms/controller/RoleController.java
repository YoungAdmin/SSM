package cn.smbms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.smbms.pojo.Role;
import cn.smbms.service.role.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	private Logger logger = Logger.getLogger(RoleController.class);
	
	@Resource
	private RoleService roleService;
	
	@RequestMapping("/rolelist.html")
	public String roleList(Model model){
		List<Role> roleList = roleService.getRoleList();
		logger.info("rolelist============>size:"+roleList.size());
		model.addAttribute("roleList", roleList);
		return "rolelist";
	}
}

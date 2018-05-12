package cn.smbms.dao.role;

import java.util.List;

import cn.smbms.pojo.Role;

public interface RoleMapper {
	
	/**
	 * 获取角色列表
	 * @return
	 * @throws Exception
	 */
	public List<Role> getRoleList()throws Exception;
}

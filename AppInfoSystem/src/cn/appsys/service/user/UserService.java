package cn.appsys.service.user;

import cn.appsys.pojo.BackendUser;
import cn.appsys.pojo.DevUser;

public interface UserService {

	/**
	 * 通过DevUser查询用户信息
	 * 
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public DevUser getDevUserByUserCode(String devCode);
	
	/**
	 * 通过userCode查询用户信息
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public BackendUser getBackendUserByUserCode(String userCode);
}
